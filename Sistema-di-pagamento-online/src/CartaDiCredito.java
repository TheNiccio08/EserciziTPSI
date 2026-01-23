public class CartaDiCredito {

    private String numero;
    private int scadenzaMese;
    private int scadenzaAnno;
    private String cvv;
    private double saldo;

    public CartaDiCredito(String numero, int scadenzaMese, int scadenzaAnno, String cvv, double saldo) {
        this.numero = numero;
        this.scadenzaMese = scadenzaMese;
        this.scadenzaAnno = scadenzaAnno;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    public boolean isScaduta() {
        int mese = 1;
        int anno = 2026;

        if (scadenzaAnno < anno) {

            return true;

        } else if (scadenzaAnno == anno && scadenzaMese < mese){
            return true;
        }else{
            return false;
        }
    }
    public boolean hasSaldo(double importo) {
        return saldo >= importo;
    }

    public void scalaSaldo(double importo) {
        saldo -= importo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }
}
