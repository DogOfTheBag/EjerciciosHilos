package alber.Ejercicio3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Consumidor extends Thread{
    private File archivoTexto;
    Cola cola;
    char c;

    public Consumidor(File archivoTexto, Cola cola){
        this.archivoTexto = archivoTexto;
        this.cola = cola;
    }


    public int contarChars() {
        int contador = 0;

        try (FileReader fr = new FileReader("fichTextoEj3.txt")) {
            while (fr.read() != -1) {
                contador++;
            }
            return contador;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*Por alguna razón no entiendo como hacer un while que termine el consumidor, ya que el productor manda
    * las cosas, pero el consumidor no termina. En el ejemplo de nacho de clase lo hace con fors, pero aquí un for no es
    * posible a no ser que le pases el archivo y cuentes los chars (lo que he hecho yo)
    * he probado a ponerle una variable estatica a productor que cuando termine la active pero tampoco funciona
    * no se me ocurre mas*/
    @Override
    public void run() {
        int contador = contarChars();
        for (int i = 0; i < contador ; i++) {
            cola.get();
        }
        System.out.println("\nCONSUMIDOR TERMINADO");
    }
}
