package alber.Ejercicio5;

import java.util.concurrent.Callable;
/*Usamos aquí un callable para poder devolverle la suma de los numeros al future usando get después*/
public class TareaSuma implements Callable<Integer> {
    public int[] numeros;
    int inicioPosicion;
    int finalPosicion;
//le pasaremos el array de numeros completo y el intervalo de numeros donde va a sumar esta tarea
    public TareaSuma(int[] numeros, int inicioPosicion, int finalPosicion) {
        this.numeros = numeros;
        this.inicioPosicion = inicioPosicion;
        this.finalPosicion = finalPosicion;
    }
    /*el único metodo que tiene Callable es call, es como run basicamente, lo que va a hacer el objeto callable*/
    @Override
    public Integer call() throws Exception {
        int suma = 0;
        for (int i = inicioPosicion; i < finalPosicion; i++) {
            suma += numeros[i];
        }
        return suma;
    }
}
