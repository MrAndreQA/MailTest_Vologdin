package ru.mail.test;

import org.junit.*;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.POM.EmailPage;
import ru.mail.POM.HomePage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static ru.mail.POM.HomePage.BASE_URL;
import static ru.mail.test.TestData.*;

public class SendEmailTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sendEmailTest() {
        HomePage homePage = new HomePage(driver);
        EmailPage emailPage = new EmailPage(driver);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.login(USER_NAME, PASSWORD);
        emailPage.sendLetter(RECIPIENT, THEME, BODY);
        // Проверка отправки письма (после нажатия кнопки "Отправить", в окне отображается текст "Письмо отправлено")
        boolean actual = emailPage.checkSending();
        assertTrue(actual);
    }
}