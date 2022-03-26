package ru.netology.delivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryFormTest {

    @Test
    public void shouldSendOrderForm() {
        RegistrationInfoManager rim = new RegistrationInfoManager();
        rim.generateInfo();

        open("http://localhost:9999/");
        SelenideElement form = $("form");
        form.$("[data-test-id='city'] input").setValue(rim.getInfo().getCity());
        form.$("[data-test-id='date'] input").doubleClick();
        form.$("[data-test-id='date'] input").sendKeys(Keys.DELETE);
        form.$("[data-test-id='date'] input").setValue(rim.getInfo().getDate());
        form.$("[data-test-id='name'] input").setValue(rim.getInfo().getName());
        form.$("[data-test-id='phone'] input").setValue(rim.getInfo().getPhone());
        form.$("[data-test-id='agreement']").click();
        form.$(".button").click();
        $("[data-test-id='success-notification']").shouldHave(Condition.text("Встреча успешно запланирована на " + rim.getInfo().getDate()));
        $("[data-test-id='success-notification'] .icon-button").click();

        rim.changeDate();
        form.$("[data-test-id='date'] input").doubleClick();
        form.$("[data-test-id='date'] input").sendKeys(Keys.DELETE);
        form.$("[data-test-id='date'] input").setValue(rim.getInfo().getDate());
        form.$(".button").click();
        $("[data-test-id='replan-notification']").shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $("[data-test-id='replan-notification'] .button").click();
        $("[data-test-id='success-notification']").shouldHave(Condition.text("Встреча успешно запланирована на " + rim.getInfo().getDate()));
    }

    @Test
    public void shouldGenerate() {
        RegistrationInfoManager rim = new RegistrationInfoManager();
        rim.generateInfo();
        String city = rim.getInfo().getCity();
        String date = rim.getInfo().getDate();
        String name = rim.getInfo().getName();
        String phone = rim.getInfo().getPhone();
        System.out.println("Done");
    }
}