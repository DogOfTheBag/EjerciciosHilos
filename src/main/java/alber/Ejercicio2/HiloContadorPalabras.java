package alber.Ejercicio2;

import java.io.*;

public class HiloContadorPalabras extends Thread{
    private File archivoTexto;

    public HiloContadorPalabras(File archivoTexto) {
        this.archivoTexto = archivoTexto;
    }

    @Override
    public void run() {
        try {
            /*usamos un BufferedReader para leer palabras, */
           BufferedReader reader = new BufferedReader(new FileReader(archivoTexto));
           String linea;
           int contador = 0;
            while((linea = reader.readLine()) !=null){
                //recortamos espacios del principio y final para que no cuenten
                linea.trim();
                if(!linea.isBlank()){
                    /*separamos la linea mediante cualquier tipo de espacio y la ponemos en un array de strings que nos dice cuantas hay con length*/
                    String[] palabras = linea.split("\\s+");
                    //ES += YA QUE SI TIENES LINEAS DIFERENTES TIENES QUE IR SUMANDO AL CONTADOR IGUALMENTE
                    contador += palabras.length;
                }

            }
            System.out.println("NUM DE PALABRAS EN EL FICHERO: " + archivoTexto + ": " + contador);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
