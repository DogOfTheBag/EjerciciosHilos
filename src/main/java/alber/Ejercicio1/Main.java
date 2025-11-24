package alber.Ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        /*He hecho la lectura de los chars primero con los hilos, esto es lo mismo pero sencuencial para ver la diferencia de tiempo*/
        long t_comienzo, t_fin;
        t_comienzo = System.currentTimeMillis();

        for (int i = 0; i < args.length; i++) {
            File archivo = new File(args[i]);
            FileReader reader = new FileReader(archivo);
            int c;
            int contador = 0;
            while((c = reader.read()) !=-1){
                contador++;
            }
            System.out.println("NUM DE CHARS EN EL FICHERO: " + archivo + ": " + contador);
        }

        t_fin= System.currentTimeMillis();
        long tiempototal = t_fin - t_comienzo;
        System.out.println("El proceso ha tardado: "+ tiempototal +" miliseg");

        t_comienzo = System.currentTimeMillis();
        
        /*Creamos el numeros de hilos dependiendo de la cantidad de argumentos que nos hayan pasado,
        * y le pasamos por constructor al hilo cada fichero, y lo inicializamos*/
        System.out.println("\nCON HILOS");
        for (int i = 0; i < args.length; i++) {
            HiloContadorChars hilo = new HiloContadorChars(new File(args[i]));
            hilo.start();
        }


        t_fin= System.currentTimeMillis();
        tiempototal = t_fin - t_comienzo;
        System.out.println("El proceso ha tardado: "+ tiempototal +" miliseg");

    }
}
