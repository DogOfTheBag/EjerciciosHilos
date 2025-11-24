package alber.Ejercicio3;

public class Cola {
    char caracter;
    private boolean disponible = false;


    public synchronized void put(char c){
        while(disponible){ //mientras haya un char mandado ya no actua
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // asignamos el char, decimos que esta disponible para que el get lo coja y notificamos para que deje de esperar
        caracter = c;
        disponible = true;
        //notifyAll para todos los consumidores
        notifyAll();
    }

    public synchronized void get(){
        //si no hay char pendiente espera
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //imprimimos el char que ha puesto el put, decimos que no hay char disponible y notificamos
        System.out.print(caracter);
        disponible = false;
        notifyAll();
    }
}
