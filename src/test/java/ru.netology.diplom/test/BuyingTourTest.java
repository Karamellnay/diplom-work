package ru.netology.diplom.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
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
    @DisplayName("Purchasing a tour using a debit card with valid data")
    void purchasingTourUsingDebitCardWithValidData() {
        var debitPage = loginPage.debitBuy();
        debitPage.validCard();
        var validCard = DataHelper.generateRandom();
        $(byText("Продолжить")).click();
        var statusCard = SQLHelper.getStatusCard();
    }
}