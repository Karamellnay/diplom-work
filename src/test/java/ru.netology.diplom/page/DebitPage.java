package ru.netology.diplom.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.diplom.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DebitPage {
    private final SelenideElement cardNumber = $(".input__control[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input__control[placeholder='08']");
    private final SelenideElement year = $(".input__control[placeholder='22']");
    private final SelenideElement name = $(byText("Владелец")).parent()
            .find(By.tagName("input"));
    private final SelenideElement cvc = $(".input__control[type='text'][placeholder='999']");
    private final SelenideElement errorNotification = $("input__sub");
    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(exactText(expectedText)).shouldBe(visible);
    }
    public DebitPage validCard(DataHelper.CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getCardNumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        name.setValue(cardInfo.getName());
        cvc.setValue(cardInfo.getCvc());
    }
}
