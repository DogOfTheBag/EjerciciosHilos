package alber.Ejercicio3;

import java.io.*;

public class Productor extends Thread{
private File archivoTexto;
Cola cola;


public Productor(File archivoTexto, Cola cola){
    this.archivoTexto = archivoTexto;
    this.cola = cola;
}

    @Override
    public void run() {
    /*He leido todo el archivo y lo he convertido a un array de chars, pero se puede hacer leyendo con un read
    * y pasandolo a char el valor de int que te den*/
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoTexto))) {
            String linea;
            StringBuilder sb= new StringBuilder();

            while((linea = reader.readLine()) != null)
                sb.append(linea);

            char[] caracteres = sb.toString().toCharArray();

            for (int i = 0; i < caracteres.length; i++) {
                cola.put(caracteres[i]);
                Thread.sleep(100);
            }

            System.out.println("PRODUCTOR TERMINADO");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
