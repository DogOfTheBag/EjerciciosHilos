package alber.Ejercicio2;


import java.io.File;

public class Main {
    public static void main(String[] args) {
        //lo mismo que el 1 pero en palabras
        long t_comienzo, t_fin;
        t_comienzo = System.currentTimeMillis();

        for (int i = 0; i < args.length; i++) {
            HiloContadorPalabras hilo = new HiloContadorPalabras(new File(args[i]));
            hilo.start();
        }
        t_fin= System.currentTimeMillis();
        long tiempototal = t_fin - t_comienzo;
        System.out.println("El proceso ha tardado: "+ tiempototal +" miliseg");
    }
}
