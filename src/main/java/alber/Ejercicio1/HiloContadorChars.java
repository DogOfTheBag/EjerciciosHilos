package alber.Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloContadorChars extends Thread{
    private File archivoTexto;

    public HiloContadorChars(File archivoTexto) {
        this.archivoTexto = archivoTexto;
    }

    @Override
    public void run() {
        try {
            /*usamos un file reader para leer chars, y cada vez que leamos un char sumamos uno al contador, despues lo imprimimos*/
            FileReader reader = new FileReader(archivoTexto);
            int c;
            int contador = 0;
            while((c = reader.read()) !=-1){
                contador++;
            }
            System.out.println("NUM DE CHARS EN EL FICHERO: " + archivoTexto + ": " + contador);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
