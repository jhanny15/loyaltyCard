package checkDigit;

import java.util.regex.Pattern;

/**
 * Una classe che simula una carta di fedeltà in formatto EAN13
 */
public class LoyaltyCard {

    /** Codice a 12 cifre o 13 cifre */
    private String cardNo;

    /**
     * Costruttore di default
     */
    private LoyaltyCard() {}

    /**
     * Costruttore pubblica di LoyaltyCard
     */
    public LoyaltyCard(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Metodo che controlla la validità della carta
     * @return true se la carta  è a 13 cifre ed è valida
     */
    public boolean checkValidity() throws CheckDigitException {
        if (cardNo.length() == 13) {
            return checkDigit().equals(String.valueOf(cardNo.charAt(12)));
        }
        else return false;
    }

    /**
     * Metodo che ritorna il checkDigit della carta, basato sull'algoritmo checkSum
     * @return il checkDigit
     */
    public String checkDigit() throws CheckDigitException {
        if(isFormatCorrect()) {
            //Le somme per l'algoritmo
            int pari = 0;
            int dispari = 0;

            for (int i = 0; i < 12; i++) {
                if( i % 2 == 0 ) {
                    dispari += cardNo.charAt(i) - '0';
                }
                else pari += cardNo.charAt(i) - '0';
            }

            pari *= 3;
            int somma = dispari + pari;

            if (somma % 10 != 0) {
                somma = 10 - (somma % 10);
            } else {
                somma = 0;
            }
            return String.valueOf(somma);
        }
        else throw new CheckDigitException("");
    }

    /**
     * Metodo che ritorna il numero della carta senza il checkDigit
     * @return numero di carta senza il checkDigit
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Metodo che ritorna il numero della carta con il checkDigit
     * @return numero di carta con il checkDigit
     */
    public String getFullCardNo() throws CheckDigitException {
        return cardNo + checkDigit();
    }

    /**
     * Metodo che controlla se il formato della carta è corretta
     * @return
     * @throws CheckDigitException
     */
    public boolean isFormatCorrect() throws CheckDigitException{
        Pattern p = Pattern.compile("\\d+");
        if (!p.matcher(cardNo).matches()) {
            throw new CheckDigitException("Il codice contiene caratteri non numerici!!");
        }
        else if (cardNo.length() == 12 || cardNo.length() == 13) {
            return true;
        }
        else throw new CheckDigitException("Il codice non è valido");
    }
}

