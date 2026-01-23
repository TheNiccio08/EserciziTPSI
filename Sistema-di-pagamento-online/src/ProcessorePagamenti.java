import java.util.ArrayList;

public class ProcessorePagamenti {

    private ArrayList<String> logTransazioni = new ArrayList<>();

    public boolean effettuaPagamento(CartaDiCredito carta, double importo) {


        if (carta.isScaduta()) {

            logTransazioni.add("Pagamento rifiutato: carta scaduta (" + carta.getNumero() + ")");
            return false;

        }

        if (!carta.hasSaldo(importo)) {

            logTransazioni.add("Pagamento rifiutato: saldo insufficiente (" + carta.getNumero() + ")");
            return false;

        }


        CircuitoBancario circuito = new CircuitoBancario();

        try {

            circuito.autorizzaPagamento(carta, importo);
            logTransazioni.add("Pagamento autorizzato: €" + importo);
            return true;

        } catch (ConnessioneBancariaException e) {

            logTransazioni.add("Errore connessione, riprovare");
            return false;

        } catch (FrodeRilevataException e) {

            logTransazioni.add("FRODE RILEVATA - Carta bloccata");
            return false;

        }
    }

    public void stampaLog() {

        System.out.println("=== LOG TRANSAZIONI ===");
        for (String voce : logTransazioni) {
            System.out.println(voce);
            
        }
    }
}
