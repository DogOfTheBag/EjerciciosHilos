package alber.Ejercicio5;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //hacemos primero el array de 10k numeros
        int[] numeros = new int[10000];
        //creamos el objeto random para hacer los numeros aleatorios entre 0 y 99 (el segundo valor es el maximo que se excluye
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(0,100);
        }
        //creamos el executor al que le pasaremos después las tareas
        ExecutorService executor = Executors.newFixedThreadPool(4);
        /*Puesto que tenemos que dividir la suma en 4 elementos, dividimos los 10000 numeros en 4 partes
        * de modo que tengamos 2500 elementos por suma*/
        int totalElementos = numeros.length;
        int trozo = totalElementos / 4;

        /*Puesto que tenemos que usar Callable para que nos devuelvan la suma de cada uno
        * utilizaremos future para usar get() y que podamos coger dichos numeros.
        * haremos una lista puesto a que tenemos 4 callable*/
        ArrayList<Future<Integer>> futuros = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            /*asignamos el inicio y fin que le vamos a dar a cada tarea
            * 0 x 2500 = 0 , 1 x 2500 = 2500, 2 x 2500 = 5000
            * y luego el fin sera el inicio + 2500 numeros, en caso de ser el ultimo directamente 10k*/
            int inicio = i * trozo;
            int fin;

            if(i==3)
                fin = totalElementos;
            else
                fin = inicio + trozo;

            /*Creamos la tarea, y después con el future, subimos la promesa (la tarea) al pool de los 4 hilos que hemos hecho
            * usando ExecutorService (submit(tarea)), y lo añadimos a la lista de futuros*/
            Callable<Integer> tarea = new TareaSuma(numeros, inicio, fin);
            Future<Integer> futuro = executor.submit(tarea);
            futuros.add(futuro);
        }
        //por ultimo, recorremos los 4 futuros usando get y haciendo la suma para sacar el total
        int sumaTotal= 0;
        for (Future<Integer> futuro : futuros) {
            sumaTotal += futuro.get();
        }
        //apagamos el executeService
        executor.shutdown();
        System.out.println("Suma total del Array = " + sumaTotal);

        //podemos hacer la suma total normal para comprobar que nos ha salido bien
        int sumaSecuencial = 0;

        for (int num : numeros) {
            sumaSecuencial += num;
        }

        System.out.println("Suma total del array secuencial = " + sumaSecuencial);

    }
}
