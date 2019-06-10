package com.libsyn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.libsyn.configuration.BasePage;
import com.libsyn.Locators.Locators.TemplatePageLocator;

public class TemplatePage extends BasePage implements TemplatePageLocator {
	@FindBy(how = How.XPATH, using = BACK_BUTTON)
	private WebElement btn_Back;

	public WebElement getBtn_Back() {
		return btn_Back;
	}

}
