package alber.Ejercicio3;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //creamos el fichero con el texto a leer
        File archivoTexto = new File("fichTextoEj3.txt");

        //cola, consumidores y productor
        Cola cola = new Cola();
        Productor p = new Productor(archivoTexto,cola);
        Consumidor c = new Consumidor(archivoTexto,cola);
        Consumidor c2 = new Consumidor(archivoTexto,cola);

        p.start();
        c.start();

        p.join();
        c.join();

        //no entiendo como hacer varios consumidores solo se ejecuta el primero
       // c2.start();


    }

}
