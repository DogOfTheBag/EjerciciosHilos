package alber.Ejercicio3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*Hacemos una constante para que si queremos cambiar el numero de jugadores, cambiamos el numero y se adapta todo*/
        final int TOTAL_JUGADORES = 5;

        Arbitro arbitro = new Arbitro(TOTAL_JUGADORES);

        System.out.println("NUMERO A ADIVINAR = " + arbitro.getNumeroAdivinar());

        /*podemos crear así a los jugadores de forma que si cambiamos el numero total se crearan sin tocar nada ese numero de jugadores
        * o bien podemos hacerlo a mano, pero esto es más correcto.*/
        for (int i = 0; i < TOTAL_JUGADORES; i++) {
            Jugador j = new Jugador (i + 1,arbitro);
            j.start();
        }
/*
        Jugador j1 = new Jugador(1,arbitro);
        Jugador j2 = new Jugador(2,arbitro);
        Jugador j3 = new Jugador(3,arbitro);
        Jugador j4 = new Jugador(4,arbitro);
        Jugador j5 = new Jugador(5,arbitro);

        j1.start();
        j2.start();
        j3.start();
        j4.start();
        j5.start();

        j1.join();
        j2.join();
        j3.join();
        j4.join();
        j5.join();
*/

    }
}
