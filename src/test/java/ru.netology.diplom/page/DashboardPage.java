package ru.netology.diplom.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final SelenideElement validAnswer = $(".notification__content");
    private final SelenideElement invalidAnswer = $(".notification__content");


    public DashboardPage() {
        validAnswer.shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Операция одобрена Банком."));
    }
    public DashboardPage() {
        invalidAnswer.shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Ошибка! Банк отказал в проведении операции."));
    }

}
