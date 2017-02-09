package org.fasttrackit.Automation;


import com.sdl.selenium.extjs3.form.Checkbox;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.util.TestBase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ElementsTest extends TestBase {


    private LoginView loginView = new LoginView();


    @Test
    public void checkboxesTest() {
        openLoginPage();

        loginView.login("eu@fast.com", "eu.pass");

        Checkbox stopProcessCheckbox = new Checkbox().setElPath("/html/body/form[1]/div[3]/label/input");
        stopProcessCheckbox.click();

        Checkbox labelWithEnterCheckbox = new Checkbox().setElPath("/html/body/form[1]/div[4]/label/input");
        labelWithEnterCheckbox.click();

        WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
        WebLocator labelWithEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.CHILD_NODE);


        Utils.sleep(2000);
        stopProcessLabel.click();
        labelWithEnterLabel.click();

        Utils.sleep(2000);
        stopProcessLabel.click();
        labelWithEnterLabel.click();

        assertThat("Stop the process is not selected!", stopProcessCheckbox.isSelected(), is(true));


    }



}
