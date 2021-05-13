package checkDigit;

import org.apache.commons.validator.routines.checkdigit.EAN13CheckDigit;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LoyaltyCardTest {

    @Test //1.a)
    void isFormatCorrectNull() {
        LoyaltyCard card = new LoyaltyCard("");
        assertThrows(CheckDigitException.class, () -> card.isFormatCorrect());
    }

    @Test //1.a)
    void isFormatCorrectNo() {
        LoyaltyCard card = new LoyaltyCard("123");
        assertThrows(CheckDigitException.class, () -> card.isFormatCorrect());
    }

    @Test //1.b)
    void isFormatCorrectChar() {
        LoyaltyCard card = new LoyaltyCard("10101010101a");
        assertThrows(CheckDigitException.class, () -> card.isFormatCorrect());
    }

    @Test //2.)
    void checkValidityTrue() throws CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("9780141026626");
        Assertions.assertEquals(true, card.checkValidity());
    }

    @Test //2.)
    void checkValidityFalse() throws CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("9780141026620");
        Assertions.assertEquals(false, card.checkValidity());
    }

    @Test //3.)
    void checkDigitCompare() throws CheckDigitException, org.apache.commons.validator.routines.checkdigit.CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("210987654321");
        EAN13CheckDigit eanCheck = new EAN13CheckDigit();
        Assertions.assertEquals(card.checkDigit(), eanCheck.calculate(card.getCardNo()));
    }

    @Test //4.)
    void getCardNo12() {
        LoyaltyCard card = new LoyaltyCard("210987654321");
        Assertions.assertEquals("210987654321", card.getCardNo());
    }

    @Test //4.)
    void getCardNo13() {
        LoyaltyCard card = new LoyaltyCard("2109876543210");
        Assertions.assertEquals("210987654321", card.getCardNo());
    }

    @Test //5.)
    void getFullCardNo12() throws CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("210987654321");
        Assertions.assertEquals("2109876543210", card.getFullCardNo());
    }

    @Test //5.)
    void getFullCardNo13() throws CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("2109876543210");
        Assertions.assertEquals("2109876543210", card.getFullCardNo());
    }

    @Test
    void isFormatCorrect() throws CheckDigitException {
        LoyaltyCard card = new LoyaltyCard("2109876543210");
    }
}