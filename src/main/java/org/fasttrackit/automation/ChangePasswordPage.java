package org.fasttrackit.automation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {

    @FindBy(name = "password")
    private WebElement currentPasswordField;

    @FindBy (name = "newPassword")
    private WebElement newPasswordField;

    @FindBy(name = "newPasswordRepeat")
    private WebElement repeatPasswordField;

    @FindBy(xpath = "//*[@id='preferences-win']//button[normalize-space(text())='Save']")
    private WebElement saveButton;

    @FindBy(className = "status-msg")
    private WebElement statusMsg;

    public void setCurrentPasswordField(){


    }


    public void changePassword(String currentPassword, String newPassword, String repeatPassword) {

        currentPasswordField.sendKeys(currentPassword);
        newPasswordField.sendKeys(newPassword);
        repeatPasswordField.sendKeys(repeatPassword);
        saveButton.click();

    }



    public String getStatusMsg(){

        String  msg = statusMsg.getText();
        System.out.println(msg);
        return msg;



    }

}
