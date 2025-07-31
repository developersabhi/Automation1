package com.automation.provider.website;

import com.automation.tests.base.CommonStepDefinitions;
import org.apache.log4j.Logger;
import org.checkerframework.checker.guieffect.qual.UI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;
import util.CommonMethod;
import util.TestBase;

import javax.swing.*;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Website extends CommonMethod {
    static  protected String webSiteName, loginSlugName, database;

    Logger logger = Logger.getLogger(Website.class);
    BaseUtil baseUtil = new BaseUtil();
    CommonMethod commonMethod = new CommonMethod();
    Website(){
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }
    List<String> data=new ArrayList<>();

    @FindBy(xpath = "//input[@placeholder ='Enter Website Name']")
    WebElement websiteName;

    @FindBy(xpath = "//input[@placeholder ='Enter IP']")
    WebElement ip;

    @FindBy(xpath = "//input[@placeholder ='Enter URL']")
    WebElement url;

    @FindBy(xpath = "//input[@placeholder ='Enter Client Name']")
    WebElement clientName;

    @FindBy(xpath = "//input[@placeholder ='Enter request approve/reject webhook url']")
    WebElement approveRejectHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter withdraw webhook url']")
    WebElement withdrawHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter balance webhook url']")
    WebElement balanceHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter agent login URL']")
    WebElement agentLoginHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter manually transaction hook url']")
    WebElement manuallyTransactionHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter user registraction hook url']")
    WebElement userRegistractionHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter user bet status hook url']")
    WebElement userBetStatusHookURL;

    @FindBy(xpath = "//input[@placeholder ='Enter employee login URL']")
    WebElement loginSlug;

    @FindBy(xpath = "//input[@placeholder ='Enter database name']")
    WebElement databaseName;


    @FindBy(xpath = "//input[@placeholder ='Enter secret name']")
    WebElement secretKey;

    @FindBy(xpath = "//input[@type ='search']")
    WebElement search;

    public void search() throws InterruptedException {
        commonMethod.explicitWait(2000);
        logger.info("on the Searching");
        waitForVisibleElement(search);
        search.clear();
//        search.sendKeys(data.get(0));
        search.sendKeys(webSiteName);
        logger.info("SEARCH button Clicked");
        Actions action=new Actions(TestBase.getWebDriver());
        search.sendKeys(Keys.ENTER);
        commonMethod.explicitWait(3000);
    }

    public void enterValue(String value){
        search.sendKeys(value);
        Actions action = new Actions(TestBase.getWebDriver());
        search.sendKeys(Keys.ENTER);
        commonMethod.explicitWait(1000);
    }

    public void enterValue(String value, String field ){
//        WebDriver driver = new ChromeDriver();
        switch (field.toUpperCase()){
            case "WEBSITE NAME":
                waitForVisibleElement(websiteName);
                webSiteName =value+randomString();
                baseUtil.enterText(websiteName, webSiteName);
                data.add(webSiteName);
                break;
            case "IP":
                waitForVisibleElement(ip);
                baseUtil.enterText(ip, value);
                data.add(value);
                break;
            case "URL":
                waitForVisibleElement(url);
                baseUtil.enterText(url, value);
                data.add(value);
                break;
            case "CLIENT NAME":
                waitForVisibleElement(clientName);
                baseUtil.enterText(clientName, value);
                data.add(value);
                break;
            case "APPROVE/REJECT HOOK URL":
                waitForVisibleElement(agentLoginHookURL);
                baseUtil.enterText(approveRejectHookURL, value);
                break;
            case "WITHDRAW HOOK URL":
                waitForVisibleElement(withdrawHookURL);
                baseUtil.enterText(withdrawHookURL, value);
                break;
            case "BALANCE HOOK URL":
                waitForVisibleElement(balanceHookURL);
                baseUtil.enterText(balanceHookURL, value);
                break;
            case "AGENT LOGIN HOOK URL":
                waitForVisibleElement(agentLoginHookURL);
                baseUtil.enterText(agentLoginHookURL, value);
                break;
            case "MANUALLY TRANSACTION HOOK URL":
                waitForVisibleElement(manuallyTransactionHookURL);
                baseUtil.enterText(manuallyTransactionHookURL, value);
                break;
            case "USER REGISTRACTION HOOK URL":
                waitForVisibleElement(userRegistractionHookURL);
                baseUtil.enterText(userRegistractionHookURL, value);
                break;
            case "USER BET STATUS HOOK URL":
                waitForVisibleElement(userBetStatusHookURL);
                baseUtil.enterText(userBetStatusHookURL, value);
                break;
            case "LOGIN SLUG":
                waitForVisibleElement(loginSlug);
                loginSlugName =value+randomString();
                baseUtil.enterText(loginSlug, loginSlugName);
                data.add(loginSlugName);
                break;
            case "DATABASE NAME":
                waitForVisibleElement(databaseName);
                database =value+randomString();
                baseUtil.enterText(databaseName, database);
                break;

            default:
                System.out.println("Not Match Data");

        }
    }

    public String randomString(){
       return UUID.randomUUID().toString().substring(4).replaceAll("[^A-Za-z]", "");
    }


    public void verifyAddedSite() throws InterruptedException {
        commonMethod.explicitWait(2000);
        List<String> UIData=new ArrayList<>();
        String xpath="//tbody/tr/td[#index#]";
        for (int i = 2; i <=6; i++) {
            String byIndex="";
            byIndex=xpath.replaceAll("#index#",String.valueOf(i));
            UIData.add(TestBase.getWebDriver().findElement(By.xpath(byIndex)).getText());
        }
        Collections.sort(UIData);
        Collections.sort(data);
        Assert.assertEquals("Expected data :: "+data+"actual data :: " + UIData + "are not matched"
                , UIData,data);
    }

    public void clickAddWebSiteButton(String btn) {
       clickOnButtons(btn);
    }

    public void searchValue(){
        logger.info("Search Value Method called");
        try {
            if (data.isEmpty()) {
                logger.error("Data list is empty!");
            }
        }catch (Exception e){

            throw new IllegalStateException("Data list is empty in searchValue()");
        }
        logger.info("Searching the created website :: " + webSiteName);
        search.sendKeys(webSiteName);
        System.out.println("Searching for: " + webSiteName);
        search.sendKeys(Keys.ENTER);
        explicitWait(1000);
    }
}
