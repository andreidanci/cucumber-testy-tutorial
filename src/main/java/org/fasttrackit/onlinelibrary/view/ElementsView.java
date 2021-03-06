package org.fasttrackit.onlinelibrary.view;


import com.sdl.selenium.extjs3.form.Checkbox;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

public class ElementsView {



    public  WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
    public  WebLocator labelWithEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.CHILD_NODE);
    public Checkbox stopProcessCheckbox = new Checkbox(stopProcessLabel);
    public  Checkbox labelWithEnterCheckbox = new Checkbox(stopProcessLabel);
    public WebLocator autoOption = new WebLocator().setText("Auto").setClasses("filter-option");
    public WebLocator menuDropDown = new WebLocator().setClasses("dropdown-menu");
    public  WebLocator manualOption = new WebLocator(menuDropDown).setText("Manual");


    public static void main(String[] args) {

        ElementsView test = new ElementsView();
        System.out.println(test.autoOption.getSelector());
        System.out.println(test.manualOption.getSelector());
        System.out.println(test.stopProcessLabel.getSelector());
        System.out.println(test.labelWithEnterLabel.getSelector());
        System.out.println(test.stopProcessCheckbox.getSelector());
        System.out.println(test.labelWithEnterCheckbox.getSelector());



    }





}
