package ru.netology.diplom.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static final Faker faker = new Faker();

    private DataHelper() {
    }

    public static String generateCardNumber() {

        return faker.numerify("#### #### #### ####");
    }


    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generateMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String statusCard() {
        return "APPROVED";
    }

    public static String generateCVC() {
        return faker.numerify("###");
    }

    public static CardInfo generateRandom() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear(), generateCVC());
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String name;
        String month;
        String year;
        String cvc;
    }
    @Value
    public static class StatusCard {
        String statusCard;
    }
    public static String generateCardNumber1() {
        return "4444 4444 4444 4441";
    }
    public static String generateCardNumber2() {
        return "4444 4444 4444 4442";
    }

    public static String generateCardNumber3() {
        return "0000 0000 0000 0000";
    }
    public static String generateCardNumber4() {
        return "";
    }
    public static String generateYear1() {
        return "00";
    }
    public static String generateYear2() {
        return "21";
    }
    public static String generateYear3() {
        return "";
    }
    public static String generateCVC1() {

        return "000";
    }
    public static String generateCVC2() {
        return "00";
    }
    public static String generateCVC3() {
        return "";
    }
    public static String generateMonth1() {
        return "00";
    }
    public static String generateMonth3() {
        return "";
    }
    public static String generateMonth2() {
        return "15";
    }
    public static String generateName1() {
        return "@@@";
    }
    public static String generateName2() {
        return "Сидорова Кристина";
    }
    public static String generateName3() {
        return "12345";
    }
    public static String generateName4() {
        return "";
    }
    public static CardInfo generateAccurateCard() {
        return new CardInfo(generateCardNumber1(), generateName("en"), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateNullCard() {
        return new CardInfo(generateCardNumber3(), generateName("en"), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateRejectedCard() {
        return new CardInfo(generateCardNumber2(), generateName("en"), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateNoCard() {
        return new CardInfo(generateCardNumber4(), generateName("en"), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateNullYear() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear1(), generateCVC());
    }
    public static CardInfo generateNoYear() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear2(), generateCVC());
    }
    public static CardInfo generateEmptyYear() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear3(), generateCVC());
    }
    public static CardInfo generateNullCvc() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear(), generateCVC1());
    }
    public static CardInfo generateEmptyCvc() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear(), generateCVC3());
    }
    public static CardInfo generateCvcTwo() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth(), generateYear(), generateCVC2());
    }
    public static CardInfo generateNullMonth() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth1(), generateYear(), generateCVC());
    }
    public static CardInfo generateNoMonth() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth2(), generateYear(), generateCVC());
    }
    public static CardInfo generateEmptyMonth() {
        return new CardInfo(generateCardNumber(), generateName("en"), generateMonth3(), generateYear(), generateCVC());
    }
    public static CardInfo generateSymbolsName() {
        return new CardInfo(generateCardNumber(), generateName1(), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateCyrillicName() {
        return new CardInfo(generateCardNumber(), generateName2(), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateNumbersName() {
        return new CardInfo(generateCardNumber(), generateName3(), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateNoName() {
        return new CardInfo(generateCardNumber(), generateName4(), generateMonth(), generateYear(), generateCVC());
    }
    public static CardInfo generateEmpty() {
        return new CardInfo(generateCardNumber4(), generateName4(), generateMonth3(), generateYear3(), generateCVC3());
    }

}
