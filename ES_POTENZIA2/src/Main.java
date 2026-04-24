public class Main {
    public static void main(String[] args) throws InterruptedException {
        Magazzino m = new Magazzino();

        Operaio o1 = new Operaio(m, "Operaio-1");
        Operaio o2 = new Operaio(m, "Operaio-2");
        Operaio o3 = new Operaio(m, "Operaio-3");

        Corriere c = new Corriere(m);

        o1.start();
        o2.start();
        o3.start();
        c.start();

        o1.join();
        o2.join();
        o3.join();
        c.join();

        System.out.println("Fine simulazione");
    }
}