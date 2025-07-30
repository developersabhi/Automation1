package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class TestBase  {
    private static TestBase instance;
    static protected WebDriver driver =null;
    CommonMethod commonMethod=new CommonMethod();;
    Map<String,String> globalProp=null;
    TestBase(){
        init();
        globalProp= CommonMethod.readProperties();
    }

  public void  init() {
        try {
            if (driver == null) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notification");
                driver = new ChromeDriver(options);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getWebDriver(){
      return driver;
    }

    public void setWebDriver(WebDriver driver){
        this.driver =driver;
    }

    public void login(){
        BaseUtil baseUtil = new BaseUtil();
        getWebDriver().get(globalProp.get("provider_env_url"));
        commonMethod.waitForVisibleElement(driver.
                findElement(By.xpath(globalProp.get("username_locater"))));
        baseUtil.enterText(driver.findElement(By.xpath(globalProp.get("username_locater"))),
                globalProp.get("username"));
        commonMethod.waitForVisibleElement(driver.
                findElement(By.xpath(globalProp.get("password_locater"))));
        baseUtil.enterText(driver.
                findElement(By.xpath(globalProp.get("password_locater"))), globalProp.get("password"));
        System.out.println("password fields....");
        commonMethod.clickOnButtons("LOGIN");
        System.out.println("Login click......");
    }

    public void logout() {
        commonMethod.waitForVisibleElement(driver
                .findElement(By.xpath(globalProp.get("logout_btn_locater"))));
        commonMethod.clickOnButtons("Logout");
        System.out.println("Logout click......");
    }

    public static TestBase getInstance(){
        if(instance==null){
            instance=new TestBase();
        }
        return instance;
    }

    public  void quitBrowser(){
            driver.quit();
    }
}
