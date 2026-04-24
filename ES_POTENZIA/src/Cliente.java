import java.util.Random;

public class Cliente extends Thread {
    private static int serviti = 0;
    private static int rinunce = 0;

    private Sportello sportello;
    private Random rand = new Random();

    public Cliente(Sportello s, String nome) {
        super(nome);
        this.sportello = s;
    }

    public void run() {
        try {
            if (!sportello.accedi(5000)) {
                System.out.println(getName() + " rinuncia");
                rinunce++;
                return;
            }

            System.out.println(getName() + " servito");

            Thread.sleep(2000 + rand.nextInt(2000));

            sportello.lascia();
            serviti++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getServiti() {
        return serviti;
    }
    public static int getRinunce() {
        return rinunce;
    }
}