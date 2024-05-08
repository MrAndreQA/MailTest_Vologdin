package ru.mail.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public static final String BASE_URL = "https://mail.ru/";

    // Кнопка "Войти" на главной странице
    private By loginButton = By.xpath("//div[@id=\"mailbox\"]/div[1]/button");
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Поле "Имя аккаунта"
    private By userNameField = By.xpath("//input[@placeholder='Имя аккаунта']");
    public void setUserName(String userName){
        WebElement iframeElement = driver.findElement(By.xpath("//div[@class='ag-popup__frame__layout ag-popup__frame__layout-desktop']/iframe"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(userNameField).sendKeys(userName);
    }

    // Кнопка "Войти" в Форме логина
    private By entryButton = By.xpath("//button[@data-test-id='next-button']");
    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    // Поле "Пароль"
    private By passwordField = By.xpath("//div/form[@data-test-id = 'login-form-type-default']//*/input[@name='password']");
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Кнопка "Войти" в Форме пароля
    private By submitButton = By.xpath("//button[@data-test-id='submit-button']");
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void login(String userName, String password) {
        clickLoginButton();
        setUserName(userName);
        clickEntryButton();
        setPassword(password);
        clickSubmitButton();
    }
}