package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/provider/features/addWebSite.feature"},
        glue = {
                "com.automation.provider.website",
                "com.automation.tests.base"
        }
//        ,
//        dryRun = false
//        tags = "",
//        plugin = {},
//        monochrome = true
)
public class RunAll {
}
