import java.util.LinkedList;

public class Magazzino {
    private LinkedList<Integer> coda = new LinkedList<>();
    private int capacita = 4;

    public synchronized void deposita(int pacco) throws InterruptedException {
        while (coda.size() == capacita) {
            wait();
        }

        coda.add(pacco);
        System.out.println("Depositato pacco " + pacco + " (tot=" + coda.size() + ")");
        notifyAll();
    }

    public synchronized Integer preleva() throws InterruptedException {
        if (coda.isEmpty()) {
            wait(4000);
        }

        if (coda.isEmpty()) {
            return null;
        }

        int pacco = coda.removeFirst();
        System.out.println("Prelevato pacco " + pacco + " (restanti=" + coda.size() + ")");
        notifyAll();
        return pacco;
    }
}
