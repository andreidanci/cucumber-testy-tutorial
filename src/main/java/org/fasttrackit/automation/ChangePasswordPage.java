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

    //to do save button


    public void setCurrentPasswordField(){


    }


    public void changePassword(String currentPassword, String newPassword, String repeatPassword) {

        currentPasswordField.sendKeys(currentPassword);
        newPasswordField.sendKeys(newPassword);
        repeatPasswordField.sendKeys(repeatPassword);


    }
}
