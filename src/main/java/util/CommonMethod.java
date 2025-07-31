package util;

import org.apache.log4j.Logger;
import org.checkerframework.checker.guieffect.qual.UI;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;

//public class CommonMethod extends TestBase {
public class CommonMethod{
    WebDriverWait waitWebDriver= new WebDriverWait(TestBase.getWebDriver(), Duration.ofMillis(10000));
    WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(),Duration.ofMillis(3000));
    Logger logger = Logger.getLogger(CommonMethod.class);
    private static final TestBase testBase=TestBase.getInstance();
    BaseUtil baseUtil=new BaseUtil();
     public CommonMethod(){
         PageFactory.initElements(TestBase.getWebDriver(), this);
     }

    @FindBy(xpath = "//form//button[contains(text(), 'Login')]")
    WebElement loginBtn;

     @FindBy(xpath = "//button[contains(text(), 'Cancel') and @aria-label='Close']")
     WebElement notiCancelBtn;

    @FindBy(xpath = "//a[contains(text(), ' Add Website')]")
    WebElement addWebSite;

    @FindBy(xpath = "//img[@style='cursor: pointer;']")
    WebElement secretKey;

    @FindBy(xpath = "(//button[contains(text(),'Submit')])[1]")
    WebElement submit;

    @FindBy(xpath = "//a[contains(text(), ' Add Website')]")
    WebElement cancel;

    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    WebElement logout;

    @FindBy(xpath = "//button[@class='btn action-btn']")
    WebElement actionBtn;

//    @FindBy(xpath = "//button[@type='button']//child::i//child::img[@src ='/user/images/edit-icon.svg']")
    @FindBy(xpath="//i//child::img[@src ='/user/images/edit-icon.svg']")
    WebElement editBtn;



    public static Map<String,String> readProperties(){
        Map<String, String> all = new HashMap<>();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
             inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Global.properties");
            properties.load(inputStream);
            Enumeration<Object> keys = properties.keys();

            while (keys.hasMoreElements()){
                String key =(String) keys.nextElement();
                all.put(key , properties.getProperty(key));
            }

        }catch (Exception e){
            e.printStackTrace();
//            return  null;
        }
        return all;
    }

    public void getData(){
        try{
            Map<String, String> test =  readProperties();
            String url = test.get("provider_env_url");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void explicitWait(long time){
        try{
            logger.info("Waiting for "+time);
            Thread.sleep(time);
        }catch (Exception e) {
           logger.error("Getting error while doing explicit wait:: "+e.getMessage());
        }
    }

    public void waitForVisibleElement(WebElement element){
            waitWebDriver.until(ExpectedConditions.visibilityOf(element));
    }

    public void urlContains(String url) {
        waitWebDriver.until(ExpectedConditions.urlContains(url));
    }

    public void titleContains(String title){
        waitWebDriver.until(ExpectedConditions.titleContains(title));
    }

    public  WebElement waitForElementWithFluentWait(By locator, int timeoutMillis, int pollingMillis){
         Wait<WebDriver> fluentWait = new FluentWait<>(TestBase.getWebDriver())
                 .withTimeout(Duration.ofMillis(timeoutMillis))
                 .pollingEvery(Duration.ofMillis(pollingMillis))
                 .ignoring(NoSuchElementException.class)
                 .ignoring(StaleElementReferenceException.class);
         return fluentWait.until(new Function<WebDriver, WebElement>() {
             @Override
             public WebElement apply(WebDriver driver) {
                 return null;
             }
         });
    }

    //button k liye xpath nikal k upr add krna h

    public void clickOnButtons(String button){
        switch (button.toUpperCase()){
            case "LOGIN":
                System.out.println("Attempting");
                waitForVisibleElement(loginBtn);
                System.out.println("Login..Button");
                loginBtn.click();
                logger.info("LOGIN button Clicked");
                break;

            case "NOTI CANCEL":
                System.out.println("Noti Cancel");
                waitForVisibleElement(notiCancelBtn);
                notiCancelBtn.click();
                logger.info("notiCancelBtn button  Clicked");
                break;
            case "ADD WEBSITE":
                waitForVisibleElement(addWebSite);
                addWebSite.click();
                logger.info("ADD WEBSITE button Clicked");
                break;

            case "SECRET KEY":
                waitForVisibleElement(secretKey);
                secretKey.click();
                logger.info("ADD WEBSITE button Clicked");
                break;

            case "SUBMIT":
                waitForVisibleElement(submit);
                submit.click();
                logger.info("SUBMIT button Clicked");
                break;

            case "CANCEL":
                waitForVisibleElement(cancel);
                cancel.click();
                logger.info("CANCEL button Clicked");
                break;

            case "LOGOUT":
                System.out.println("Logout Button ...");
                waitForVisibleElement(logout);
                logout.click();
                logger.info("LOGOUT button Clicked");
                break;

            case "ACTION":
                System.out.println("Action Button....");
                waitForVisibleElement(actionBtn);
                actionBtn.click();
                logger.info("ACTION button Clicked");
                break;
            case "EDIT":
                System.out.println("Edit Button...");
                waitForVisibleElement(editBtn);
                editBtn.click();
                logger.info("EDIT button Clicked");

            default:
                logger.info("Invalid button type: " + button);
        }
    }

    public void waitAndSendKeys(WebElement element, String text){
         waitForVisibleElement(element);
         element.click();
         element.sendKeys(text);
    }

    public static TestBase getTestBase(){
        return new TestBase();
    }

    public String generateRandomString(String str) {
        Random random = new Random();
        str=str+"_"+random.nextInt(0,5);
        return str;
    }

}
