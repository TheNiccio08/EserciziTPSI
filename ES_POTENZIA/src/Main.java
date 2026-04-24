public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sportello s = new Sportello();

        Cliente[] clienti = new Cliente[8];

        for (int i = 0; i < 8; i++) {
            clienti[i] = new Cliente(s, "Cliente" + i);
            clienti[i].start();
        }

        for (Cliente c : clienti) {
            c.join();
        }

        System.out.println("Serviti: " + Cliente.getServiti());
        System.out.println("Rinunce: " + Cliente.getRinunce());
    }
}