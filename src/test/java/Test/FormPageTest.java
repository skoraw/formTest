package Test;

import Pages.FormPage;
import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormPageTest extends TestBase {
    GlobalMethods globalMethods;
    FormPage formPage;

    @BeforeTest
    public void setUp() {
        initialization();
        globalMethods = new GlobalMethods();
        formPage = new FormPage();
    }

    @AfterTest
    public void closeBrowser() {
        testEnds();
    }

    @Test(priority = 1)
    public void fillAllFieldsInForm() {
        formPage.setNameInput(testdata.getProperty("name"));
        formPage.setMailInput(globalMethods.emailGenerator());
        formPage.setTopicFromList(testdata.getProperty("topic"));
        formPage.setTextInput(testdata.getProperty("text"));
        formPage.clickRodoButton();
        globalMethods.takeScreenShot(1);
        formPage.clickSendButton();
    }

    @Test (priority = 2)
    public void captchaFieldIsRequired() {
        Assert.assertTrue(formPage.captchaInputNotFilled(), "uzupełnione? :(");
        globalMethods.takeScreenShot(2);
    }

    @Test(priority = 2)
    public void fillAllTheFieldsErrorDisplay() {
        Assert.assertTrue(formPage.FillAllFieldsValidation(), "Coś poszło nie tak i przeszło dalej :(");
    }


}
