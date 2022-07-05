package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class registerPageObjects extends pageObjects.commonObjects {
  public WebDriver driver;

  @BeforeEach
  public void start(){
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   driver.manage().window().maximize();
  }

  @AfterEach
  public void finish(){
   driver.quit();
  }

  String SITE_URL = "https://test.altorney.com/";
  public void openWebsite() {
    driver.get(SITE_URL);
  }

  By getReviewerBtn = By.className("reviewer-button-wrapper");
  By createAccountBtn = By.xpath("//p/a");

  public void goToRegisterForm() {
   driver.findElement(getReviewerBtn).click();
   driver.findElement(createAccountBtn).click();
   driver.findElement(getReviewerBtn).click();

  }

  By getFirstNameInput  = By.cssSelector("[formcontrolname=\"firstName\"]");
  By getLastNameInput  = By.cssSelector("[formcontrolname=\"lastName\"]");
  By getEmailInput  = By.cssSelector("[formcontrolname=\"email\"]");
  By getPasswordInput  = By.cssSelector("[formcontrolname=\"password\"]");
  By getConfirmPasswordInput  = By.cssSelector("[formcontrolname=\"confirmPassword\"]");
  By getAgreeChb = By.cssSelector("[class=\"p-checkbox-box\"]");
  By getSubmitBtn = By.xpath("//form/button");

    public void fillRegisterForm(String firstname, String lastname,
                                 String email, String password ) {
     driver.findElement(getFirstNameInput).sendKeys(firstname);
     driver.findElement(getLastNameInput).sendKeys(lastname);
     driver.findElement(getEmailInput).sendKeys(email);
     driver.findElement(getPasswordInput).sendKeys(password);
     driver.findElement(getConfirmPasswordInput).sendKeys(password);
     driver.findElement(getAgreeChb).click();
     driver.findElement(getSubmitBtn).click();
  }

   public Assertions assertions;
   By resendEmailBtn = By.className("text-white");
   //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
   public void checkRegisterSuccess(){
     //wait.until(ExpectedConditions.invisibilityOfElementLocated(getFirstNameInput));
     //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     boolean isBtnVisible = driver.findElement(resendEmailBtn).isDisplayed();
     assertions.assertEquals(isBtnVisible,true);
     System.out.println(isBtnVisible);
    }
}
