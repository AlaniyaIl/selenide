package ru.netology;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


 class CardFormTest {

    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    @Test
    void positiveFormTest() {
        String date = generateDate(1);
        open("http://localhost:9999");
        $("[data-test-id= city] input").setValue("Москва");
        $("[data-test-id= date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id= date] input").setValue(date);
        $("[data-test-id= name] input").setValue("Илья");
        $("[data-test-id= phone] input").setValue("+79012345678");
        $("[data-test-id= agreement] ").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! " + "Встреча успешно забронирована на " + date), Duration.ofSeconds(15)).shouldBe(visible);
    }


    @Test
     void dropDownTest() {
        String date = generateDate(1);
        open("http://localhost:9999");
        $("[data-test-id= city] input").setValue("Москва");
        $("[data-test-id= date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id= date] input").setValue(date);
        $("[data-test-id= name] input").setValue("Илья");
        $("[data-test-id= phone] input").setValue("+79012345678");
        $("[data-test-id= agreement] ").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! " + "Встреча успешно забронирована на " + date), Duration.ofSeconds(15)).shouldBe(visible);
    }
}