public class Main {
    public static void main(String[] args) {

        CartaDiCredito cartaScaduta = new CartaDiCredito("1111-2222-3333-4444", 12, 2024, "123", 1000);

        CartaDiCredito cartaPocoSaldo = new CartaDiCredito("5555-6666-7777-8888", 6, 2027, "456", 20);

        CartaDiCredito cartaValida = new CartaDiCredito("9999-0000-1111-2222", 11, 2027, "789", 500);

        ProcessorePagamenti processore = new ProcessorePagamenti();

        processore.effettuaPagamento(cartaScaduta, 50);
        processore.effettuaPagamento(cartaPocoSaldo, 100);
        processore.effettuaPagamento(cartaValida, 100);
        processore.effettuaPagamento(cartaValida, 50);
        processore.effettuaPagamento(cartaValida, 200);

        processore.stampaLog();

    }
}