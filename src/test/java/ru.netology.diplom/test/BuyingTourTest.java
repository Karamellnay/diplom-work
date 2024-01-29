package ru.netology.diplom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import ru.netology.diplom.data.DataHelper;
import ru.netology.diplom.page.CreditPage;
import ru.netology.diplom.page.DebitPage;
import ru.netology.diplom.page.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BuyingTourTest {
    LoginPage loginPage;
    DebitPage debitPage;
    CreditPage creditPage;


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
        open("http://localhost:8080");
    }


    @Test
   @DisplayName("Purchasing a tour using a debit card with valid data")
    void purchasingTourUsingDebitCardWithValidData() {
        String cardNumber = DataHelper.generateCardNumber();
        String month = DataHelper.generateMonth();
        String year = DataHelper.generateYear();
        String cvc = DataHelper.generateCVC();
        String name = DataHelper.generateName("en");
        $(byText("Купить")).click();
        $(".input__control[placeholder='0000 0000 0000 0000']").setValue(cardNumber);
        $(".input__control[placeholder='08']").setValue(month);
        $(".input__control[placeholder='22']").setValue(year);
        $(byText("Владелец")).parent()
                .find(By.tagName("input"))
                .setValue(name);
        $(".input__control[type='text'][placeholder='999']").setValue(cvc);
        $(byText("Продолжить")).click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Операция одобрена Банком."));
    }
    @Test
    @DisplayName("Purchasing a tour using a credit card with valid data")
    void purchasingTourUsingCreditCardWithValidData() {
        String cardNumber = DataHelper.generateCardNumber();
        String month = DataHelper.generateMonth();
        String year = DataHelper.generateYear();
        String cvc = DataHelper.generateCVC();
        String name = DataHelper.generateName("en");
        $(byText("Купить в кредит")).click();
        $(".input__control[placeholder='0000 0000 0000 0000']").setValue(cardNumber);
        $(".input__control[placeholder='08']").setValue(month);
        $(".input__control[placeholder='22']").setValue(year);
        $(byText("Владелец")).parent()
                .find(By.tagName("input"))
                .setValue(name);
        $(".input__control[type='text'][placeholder='999']").setValue(cvc);
        $(byText("Продолжить")).click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Операция одобрена Банком."));
    }
    @Test
    @DisplayName("Purchasing a tour using a debit card with valid data")
    void purchasingTourUsingDebitCardWithValidData2() {
        loginPage.debitBuy();
        var cardIhfo = DataHelper.generateRandom();
        var debitPage = DebitPage.validCard(cardIhfo);
    }
}