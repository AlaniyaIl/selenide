package ru.netology;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


 class CardFormTest {

    String generateTest(int days) {
         return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
     }


    @Test
    void positiveTest() {
        String date = generateTest(10);
        open("http://localhost:9999");
        $("[data-test-id= city] input").setValue("Москва");
        $("[data-test-id= date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id= date] input").setValue(date);
        $("[data-test-id= name] input").setValue("Илья");
        $("[data-test-id= phone] input").setValue("+79012345678");
        $("[data-test-id= agreement] ").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! " + "Встреча успешно забронирована на "
                + date), Duration.ofSeconds(15)).shouldBe(visible);
    }


    @Test
     void dropTest() {
        String date = generateTest(10);
        open("http://localhost:9999");
        $("[data-test-id= city] input").setValue("Москва");
        $("[data-test-id= date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id= date] input").setValue(date);
        $("[data-test-id= name] input").setValue("Илья");
        $("[data-test-id= phone] input").setValue("+79012345678");
        $("[data-test-id= agreement] ").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! " + "Встреча успешно забронирована на "
                        + date),Duration.ofSeconds(19)).shouldBe(visible);
    }
}