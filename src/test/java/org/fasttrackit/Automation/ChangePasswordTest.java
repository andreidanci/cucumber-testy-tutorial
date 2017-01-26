package org.fasttrackit.Automation;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.ChangePasswordPage;
import org.fasttrackit.automation.LoginPage;
import org.fasttrackit.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;

    private ChangePasswordPage changePasswordPage;

    public ChangePasswordTest() {

        loginPage = PageFactory.initElements(driver,LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver,ChangePasswordPage.class);
    }

    @Test
    public void changePasswordWithInvalidCurrentPassword() {

        openBrowser();

        loginPage.login("eu@fast.com", "eu.pass");

        WebElement preferenceButton = driver.findElement(By.xpath("//button[@data-target='#preferences-win']"));
        preferenceButton.click();

        Utils.sleep(2000);

        changePasswordPage.changePassword("rong.pass", "new.pass", "new.pass");


    }




}
