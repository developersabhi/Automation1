package com.automation.provider.website;

import io.cucumber.java.en.Then;
import util.CommonMethod;
import util.TestBase;

import java.util.Random;

public class WebsiteTest extends CommonMethod {
    Website website=new Website();
    CommonMethod commonMethod = new CommonMethod();

    @Then("click on the  {string} button.")
    public void click_on_the_button(String button) throws InterruptedException {
        System.out.println("button click : "+ button);
        commonMethod.explicitWait(2000);
        website.clickAddWebSiteButton(button);
    }
    @Then("user enter the data {string} for {string} field.")
    public void user_enter_the_data_for_field(String value, String field) {;
        website.enterValue(value,field);

    }

    @Then("enter the data value for search.")
    public void enter_the_data_value_for_search(){
        website.searchValue();
    }

    @Then("user enter the data on the Search.")
    public void user_enter_the_data_on_the_Search() throws InterruptedException {
       website.search();
    }
    @Then("User Verify the Add Website on list")
    public void user_verify_the_add_website_on_list() throws InterruptedException {
        website.verifyAddedSite();
    }

    @Then("User Close the Browser;")
    public void user_close_the_browser() {
//        commonMethod.explicitWait(2000);
        getTestBase().quitBrowser();
    }

    @Then("user enter the data {string} on the Search.")
    public void user_enter_the_data_on_the_search(String string) {
        website.enterValue(string);
    }

    @Then("User click on the {string} button.")
    public void user_click_on_the_button(String string) {
        commonMethod.clickOnButtons(string);
    }
    @Then("User Verify the Edited Website on list.")
    public void user_verify_the_edited_website_on_list() throws InterruptedException {
        website.verifyAddedSite();
        System.out.println("Verify edited");
    }





}
