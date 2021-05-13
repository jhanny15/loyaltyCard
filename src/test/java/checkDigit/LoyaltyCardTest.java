package checkDigit;

import org.apache.commons.validator.routines.checkdigit.EAN13CheckDigit;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LoyaltyCardTest {

    @Test //1.a)
    void insertNull() {
        LoyaltyCard card = new LoyaltyCard("");
        assertThrows(CheckDigitException.class, () -> card.isFormatCorrect());
    }

    @Test //1.a)
    void insertNo() {
        LoyaltyCard card = new LoyaltyCard("123");
        assertThrows(CheckDigitException.class, () -> card.isFormatCorrect());
    }

    @Test //1.b)
    void insertChar() {
        LoyaltyCard card = new LoyaltyCard("10101010101a");
        assertThrows(CheckDigitException.class, () -> card.isFormatCorrect());
    }


    @Test //2.a)
    void checkDigit() throws CheckDigitException, org.apache.commons.validator.routines.checkdigit.CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("210987654321");
        EAN13CheckDigit eanCheck = new EAN13CheckDigit();
        Assertions.assertEquals(card.checkDigit(), eanCheck.calculate(card.getCardNo()));
    }


}