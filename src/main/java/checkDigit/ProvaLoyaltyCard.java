package checkDigit;

public class ProvaLoyaltyCard {

    public static void main(String[] args) throws CheckDigitException {

        LoyaltyCard card = new LoyaltyCard("2109876543210");
        card.checkDigit();
        System.out.println('9' - '0');
        System.out.println(card.getFullCardNo());
        System.out.println(card.checkValidity());
        System.out.println(card.checkDigit());

    }
}
