package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardFormTest {
    @Test
    void formCorrect() {
        open("http://localhost:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id = name] input").setValue("Игорь Николаев");
        form.$("[data-test-id = phone] input").setValue("+78005553535");
        form.$("[data-test-id = agreement]").click();
        form.$(By.className("button")).click();
        $("[data-test-id = order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}