package util;

import com.sun.source.doctree.TextTree;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BaseUtil {
     Logger logger;

    public void clickAndWait(WebElement element){

        try{
            if(isElementDisplayed(element)){
                element.click();
            }else{
                System.out.println("Element not Displayed");
            }
        }catch (ElementClickInterceptedException | NoSuchElementException e ){
            logger.error("");
        }

    }

    public boolean isElementDisplayed(WebElement element){
        boolean flag =false;
       try {
           if(element.isDisplayed()) flag = true;
       }catch (Exception e){
           e.printStackTrace();
       }
          return flag;
    }

    public void enterText(WebElement element,String text){
        try {
            isElementDisplayed(element);
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
