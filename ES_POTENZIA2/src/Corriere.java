import java.util.Random;

public class Corriere extends Thread {
    private Magazzino magazzino;
    private Random rand = new Random();

    public Corriere(Magazzino m) {
        this.magazzino = m;
    }

    public void run() {
        int tentativiFalliti = 0;

        try {
            while (tentativiFalliti < 3) {
                Integer pacco = magazzino.preleva();

                if (pacco == null) {
                    tentativiFalliti++;
                    System.out.println("Magazzino vuoto (tentativo " + tentativiFalliti + ")");
                    continue;
                }

                tentativiFalliti = 0;

                Thread.sleep(2000 + rand.nextInt(2000));
                System.out.println("Consegnato pacco " + pacco);
            }

            System.out.println("Corriere termina: nessun pacco disponibile");

        } catch (InterruptedException e) {
            System.out.println("Errore");
        }
    }
}
