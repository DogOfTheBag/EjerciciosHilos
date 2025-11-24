package alber.Ejercicio4;

public class Arbitro {

    private final int TOTAL_JUGADORES;
    private int turno;
    private int numeroAdivinar;
    private boolean juegoTerminado;

    public Arbitro(int totalJugadores) {
        this.TOTAL_JUGADORES = totalJugadores;
        numeroAdivinar = 1 + (int) (10 * Math.random());
        turno = 1;
    }

    public int getTurno() {
        return turno;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    private boolean comprobarVictoria(int numeroPensado) {
        if (numeroPensado == numeroAdivinar)
            return true;
        return false;
    }
    /*debemos hacer este método sincronizado para que no se metan entre ellos y haya lios
    *basicamente el jugador que le toque genera un numero, y comprobamos si el numero pensado es igual al que hay que adivinar
    * si lo es, lo imprimimos y marcamos el juego como terminado, si no seguimos y sumamos uno al turno.
    * Si es el ultimo jugador, volvemos al primer turno */
    public synchronized void hacerJugada(Jugador jugador) {
        jugador.setNumeroPensado(jugador.generarNumero());
        System.out.println("JUGADOR " + jugador.getIdJugador() + " DICE: " + jugador.getNumeroPensado());
        if (this.comprobarVictoria(jugador.getNumeroPensado())) {
            System.out.println("JUGADOR " + jugador.getIdJugador() + " GANA, ADIVINÓ EL NÚMERO");
            juegoTerminado = true;
        }else {
            if (turno == TOTAL_JUGADORES)
                turno = 1;
            else
                turno++;
        }
    }
}
