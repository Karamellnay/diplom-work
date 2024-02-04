package ru.netology.diplom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import ru.netology.diplom.data.DataHelper;
import ru.netology.diplom.data.SQLHelper;
import ru.netology.diplom.page.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BuyingTourTest {
    LoginPage loginPage;
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @BeforeEach
    void setup() {
        loginPage = open("http://localhost:8080", LoginPage.class);
    }
    @Test
    @DisplayName("Tour using a debit card with accurate card")
    void tourUsingDebitCardWithAccurateCard37() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateRandom();
        debitPage.validCard(validCard);
        debitPage.answerBank("Ошибка! Банк отказал в проведении операции.");
    }
    @Test
    @DisplayName("Tour using a credit card with accurate card")
    void tourUsingCreditCardWithAccurateCard38() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateRandom();
        creditPage.validCardCredit(validCardCredit);
        creditPage.answerBankCredit("Ошибка! Банк отказал в проведении операции.");
    }
    @Test
    @DisplayName("Tour using a debit card with valid data")
    void tourUsingDebitCardWithValidData1() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateAccurateCard();
        debitPage.validCard(validCard);
        debitPage.answerBank("Операция одобрена Банком.");
        var statusCard = SQLHelper.getStatusCard();
        String expectedStatus = "APPROVED";
        Assertions.assertEquals(expectedStatus, statusCard);
    }
    @Test
    @DisplayName("Tour using a credit card with valid data")
    void tourUsingCreditCardWithValidData2() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateAccurateCard();
        creditPage.validCardCredit(validCardCredit);
        creditPage.answerBankCredit("Операция одобрена Банком.");
        var statusCard = SQLHelper.getStatusCardCredit();
        String expectedStatus = "APPROVED";
        Assertions.assertEquals(expectedStatus, statusCard);
    }
    @Test
    @DisplayName("Tour using a debit card with null card")
    void tourUsingDebitCardWithNullCard9() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNullCard();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with null Card")
    void tourUsingCreditCardWithNullCard22() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNullCard();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with rejected card")
    void tourUsingDebitCardWithRejectedCard29() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateRejectedCard();
        debitPage.validCard(validCard);
        debitPage.answerBank("Ошибка! Банк отказал в проведении операции.");
        var statusCard = SQLHelper.getStatusCard();
        String expectedStatus = "DECLINED";
        Assertions.assertEquals(expectedStatus, statusCard);
    }
    @Test
    @DisplayName("Tour using a credit card with rejected Card")
    void tourUsingCreditCardWithRejectedCard30() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateRejectedCard();
        creditPage.validCardCredit(validCardCredit);
        creditPage.answerBankCredit("Ошибка! Банк отказал в проведении операции.");
        var statusCard = SQLHelper.getStatusCardCredit();
        String expectedStatus = "DECLINED";
        Assertions.assertEquals(expectedStatus, statusCard);
    }
    @Test
    @DisplayName("Tour using a debit card with null year")
    void tourUsingDebitCardWithNullYear35() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNullYear();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Истёк срок действия карты");
    }
    @Test
    @DisplayName("Tour using a credit card with null year")
    void tourUsingCreditCardWithNullYear36() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNullYear();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Истёк срок действия карты");
    }
    @Test
    @DisplayName("Tour using a debit card with null cvc")
    void tourUsingDebitCardWithNullCvc33() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNullCvc();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with null cvc")
    void tourUsingCreditCardWithNullCvc34() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNullCvc();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with cvc")
    void tourUsingDebitCardWithCvc31() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateCvcTwo();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with cvc")
    void tourUsingCreditCardWithCvc32() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateCvcTwo();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with null month")
    void tourUsingDebitCardWithNullMonth10() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNullMonth();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверно указан срок действия карты");
    }
    @Test
    @DisplayName("Tour using a credit card with null month")
    void tourUsingCreditCardWithNullMonth23() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNullMonth();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверно указан срок действия карты");
    }
    @Test
    @DisplayName("Tour using a debit card with name")
    void tourUsingDebitCardWithName8() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateSymbolsName();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with name")
    void tourUsingCreditCardWithName21() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateSymbolsName();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with cyrillic name")
    void tourUsingDebitCardWithCyrillicName6() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateCyrillicName();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with cyrillic name")
    void tourUsingCreditCardWithCyrillicName19() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateCyrillicName();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with no month")
    void tourUsingDebitCardWithNoMonth5() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNoMonth();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверно указан срок действия карты");
    }
    @Test
    @DisplayName("Tour using a credit card with no month")
    void tourUsingCreditCardWithNoMonth18() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNoMonth();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверно указан срок действия карты");
    }
    @Test
    @DisplayName("Tour using a debit card with no year")
    void tourUsingDebitCardWithNoYear4() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNoYear();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Истёк срок действия карты");
    }
    @Test
    @DisplayName("Tour using a credit card with no year")
    void tourUsingCreditCardWithNoYear17() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNoYear();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Истёк срок действия карты");
    }
    @Test
    @DisplayName("Tour using a debit card with numbers name")
    void tourUsingDebitCardWithNumbersName7() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNumbersName();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with numbers name")
    void tourUsingCreditCardWithNumbersName20() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNumbersName();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with no card")
    void tourUsingDebitCardWithNoCard11() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNoCard();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with no Card")
    void tourUsingCreditCardWithNoCard24() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNoCard();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with no name")
    void tourUsingDebitCardWithNoName12() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateNoName();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Поле обязательно для заполнения");
    }
    @Test
    @DisplayName("Tour using a credit card with no name")
    void tourUsingCreditCardWithNoName25() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateNoName();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Поле обязательно для заполнения");
    }
    @Test
    @DisplayName("Tour using a debit card with empty month")
    void tourUsingDebitCardWithEmptyMonth13() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateEmptyMonth();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with empty month")
    void tourUsingCreditCardWithEmptyMonth26() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateEmptyMonth();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with empty year")
    void tourUsingDebitCardWithEmptyYear14() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateEmptyYear();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with empty year")
    void tourUsingCreditCardWithEmptyYear27() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateEmptyYear();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with empty cvc")
    void tourUsingDebitCardWithEmptyCvc15() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateEmptyCvc();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");

    }
    @Test
    @DisplayName("Tour using a credit card with empty cvc")
    void tourUsingCreditCardWithEmptyCvc28() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateEmptyCvc();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a debit card with empty")
    void tourUsingDebitCardWithEmpty3() {
        var debitPage = loginPage.debitBuy();
        var validCard = DataHelper.generateEmpty();
        debitPage.validCard(validCard);
        debitPage.verifyErrorNotification("Неверный формат");
    }
    @Test
    @DisplayName("Tour using a credit card with empty")
    void tourUsingCreditCardWithEmpty16() {
        var creditPage = loginPage.creditBuy();
        var validCardCredit = DataHelper.generateEmpty();
        creditPage.validCardCredit(validCardCredit);
        creditPage.verifyErrorNotification("Неверный формат");
    }
}