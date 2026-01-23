import java.util.Random;

public class CircuitoBancario {

    private Random ran = new Random();

    public boolean autorizzaPagamento(CartaDiCredito carta, double importo)
            throws ConnessioneBancariaException {

        int valore = ran.nextInt(101);

        if (valore < 10) {

            throw new ConnessioneBancariaException("Timeout di rete");

        } else if (valore < 15) {

            throw new FrodeRilevataException("Attività sospetta rilevata");

        }
        carta.scalaSaldo(importo);
        return true;
    }
}
