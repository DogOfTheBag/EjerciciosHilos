package alber.Ejercicio3;

public class Jugador extends Thread{
    private int idJugador;
    private Arbitro arbitro;
    private int numeroPensado;

//el ejercicio nos pide que le demos un id y el mismo arbitro a todos
    public Jugador(int id, Arbitro arbitro){
        this.idJugador = id;
        this.arbitro = arbitro;
    }
    /*Lo que hace cada hilo cuando se ejecuta es empezar a jugar. Mientras no se haya terminado el juego, el hilo
    * comprueba si es su turno, y si lo es, juega, si no se queda ejecutandolo hasta que le toque*/
    @Override
    public void run() {
        while(!arbitro.isJuegoTerminado())
        if(arbitro.getTurno() == idJugador){
            arbitro.hacerJugada(this);
        }
    }
    //el random genera un numero entre 0 y 0.9, lo multiplicamos por 10 para que salga entre 1 y 9, y + 1 por si sale 0 o para que pueda salir 10
    public int generarNumero(){
        int numero = 1 + (int) (10* Math.random());
        return numero;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public int getNumeroPensado() {
        return numeroPensado;
    }

    public void setNumeroPensado(int numeroPensado) {
        this.numeroPensado = numeroPensado;
    }
}
