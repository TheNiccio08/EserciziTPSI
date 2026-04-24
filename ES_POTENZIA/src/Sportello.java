public class Sportello {
    private int cassieriLiberi = 2;

    public synchronized boolean accedi(long timeout) throws InterruptedException {
        if (cassieriLiberi == 0) {
            wait(timeout);
        }

        if (cassieriLiberi == 0) {
            return false;
        }

        cassieriLiberi--;
        return true;
    }

    public synchronized void lascia() {
        cassieriLiberi++;
        notifyAll();
    }
}