package com.automation.tests.base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import util.CommonMethod;

public class CommonStepDefinitions extends CommonMethod {

    @Given("User log in to provider URL and is already present at the website list page.")
    public void user_log_in_to_provider_url_and_is_already_present_at_the_website_list_page() {
        explicitWait(2000);
        getTestBase().login();
    }

    @Then("User will logout.")
    public void user_will_logout() {
        getTestBase().logout();
    }
}
