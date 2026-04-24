import java.util.Random;

public class Operaio extends Thread {
    private Magazzino magazzino;
    private Random rand = new Random();

    public Operaio(Magazzino m, String nome) {
        super(nome);
        this.magazzino = m;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000 + rand.nextInt(2000));
                magazzino.deposita(i);
            }
        } catch (InterruptedException e) {
            System.out.println("Errore");
        }
    }
}