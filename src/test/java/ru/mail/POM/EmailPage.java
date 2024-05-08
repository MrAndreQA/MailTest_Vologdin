package ru.mail.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailPage {
    private WebDriver driver;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Написать письмо"
    private By composeLetter = By.xpath("//span[@class='compose-button__wrapper']");
    public void clickToComposeLetter() {
        driver.findElement(composeLetter).click();
    }

    // Форма заполнения письма
    private By formComposeLetter = By.xpath("//div[@class='compose-app__compose']");

    // Поле "Кому"
    private By recipientField = By.xpath("//label[@class='container--zU301']//input[@class='container--H9L5q size_s--3_M-_']");
    public void setRecipient(String recipient) {
        driver.findElement(recipientField).sendKeys(recipient);
    }

    // Поле "Тема письма"
    private By themeOfLetter = By.xpath("//div[@class='container--3QXHv']//input[@class='container--H9L5q size_s--3_M-_']");
    public void setThemeOfLetter(String theme) {
        driver.findElement(themeOfLetter).sendKeys(theme);
    }

    // Поле "Текст письма"
    private By bodyOfLetter = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[4]/div/div/div[2]/div[1]/div[1]");
    public void setBodyOfLetter(String body) {
        driver.findElement(bodyOfLetter).sendKeys(body);
    }

    // Кнопка "Отправить"
    private By sendButton = By.xpath("//button[@data-test-id='send']");
    public void clickSendButton() {
        driver.findElement(sendButton).click();
    }

    // Окно отправленного письма, подтверждение отправки
    private By confirmSending = By.xpath("//div[@class='layer__header']/a");
    public boolean checkSending() {
        return driver.findElement(confirmSending).getText().equals("Письмо отправлено");
    }

    public void sendLetter(String recipient, String theme, String body) {
        clickToComposeLetter();
        setRecipient(recipient);
        setThemeOfLetter(theme);
        setBodyOfLetter(body);
        clickSendButton();
    }
}