package Test;

import pages.FormPage;
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
    public void fillAllTheFieldsErrorDisplay() {
        formPage.fillAllFieldsInForm();
        globalMethods.takeScreenShot(1);
        Assert.assertTrue(formPage.FillAllFieldsValidation(), "Coś poszło nie tak i przeszło dalej :(");
    }

    @Test(priority = 2)
    public void captchaFieldIsRequired() {
        Assert.assertTrue(formPage.captchaInputNotFilled(), "uzupełnione? :(");
        globalMethods.takeScreenShot(2);
    }
}
