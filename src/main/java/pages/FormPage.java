package pages;

import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class FormPage extends TestBase {
    GlobalMethods globalMethods;

    @FindBy(xpath = "//input[@name='imie-i-nazwisko']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@name='e-mail']")
    WebElement mailInput;

    @FindBy(name = "wybierz-temat")
    WebElement topicSelector;

    @FindBy(xpath = "//textarea[@name='tresc']")
    WebElement textInput;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement rodoCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement sendButton;

    @FindBy(xpath = "//i[@class='las la-ban la-lg mr-2']")
    WebElement fillAllFieldsValidation;

    @FindBy(xpath = "//span[@class='invalid-feedback ']")
    WebElement captcha;

    public FormPage() {
        globalMethods = new GlobalMethods();
        PageFactory.initElements(driver, this);
    }

    public void setNameInput(String name) {
        globalMethods.setInput(nameInput, name);
    }

    public void setMailInput(String mail) {
        globalMethods.setInput(mailInput, mail);
    }

    public void setTopicFromList(String topic) {
        Select topicInput = new Select(topicSelector);
        wait.until(visibilityOf(topicSelector));
        topicInput.selectByValue(topic);
    }

    public void setTextInput(String text) {
        globalMethods.setInput(textInput, text);
    }

    public void clickRodoButton() {
        globalMethods.clickButton(rodoCheckBox);
    }
    public void clickSendButton() {
        globalMethods.clickButton(sendButton);
    }

    public boolean FillAllFieldsValidation() {
        return globalMethods.visibilityOfElement(fillAllFieldsValidation);
    }

    public boolean captchaInputNotFilled() {
        return globalMethods.visibilityOfElement(captcha);
    }

    public void fillAllFieldsInForm() {
        setNameInput(testdata.getProperty("name"));
        setMailInput(globalMethods.emailGenerator());
        setTopicFromList(testdata.getProperty("topic"));
        setTextInput(testdata.getProperty("text"));

        clickRodoButton();
        clickSendButton();

    }
}
