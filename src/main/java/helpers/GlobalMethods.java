package helpers;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GlobalMethods extends TestBase {
    public GlobalMethods() {
    }

    public void setInput(WebElement inputElement, String text) {
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    public void clickButton(WebElement buttonElement) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonElement)).click();
    }

    public boolean visibilityOfElement(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public void takeScreenShot(int testNumber) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + testNumber + "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public String emailGenerator(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username" + randomInt + "@cloudS.com";
    }
}
