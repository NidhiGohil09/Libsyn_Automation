package com.libsyn.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.libsyn.Locators.Locators.LoginPageLocators;
import com.libsyn.configuration.BasePage;;

public class LoginPage extends TemplatePage implements LoginPageLocators {
	public LoginPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = LOGINPAGE_EMAIL)
	private WebElement txt_email;

	@FindBy(how = How.XPATH, using = LOGINPAGE_PASSWORD)
	private WebElement txt_pass;

	@FindBy(how = How.XPATH, using = LOGINPAGE_BTN_LOGIN)
	private WebElement btn_submit;

	@FindBy(how = How.XPATH, using = LOGINPAGE_ERROR)
	private WebElement login_error;

	@FindBy(how = How.XPATH, using = WELCOME_MESSAGE)
	private WebElement welcome_message;

	public WebElement getTxt_email() {
		return txt_email;
	}

	public WebElement getTxt_pass() {
		return txt_pass;
	}

	public WebElement getBtn_submit() {
		return btn_submit;
	}

	public WebElement getLogin_error() {
		return login_error;
	}

	public WebElement getWelcom_message() {
		return welcome_message;
	}

	public void Loginwith_IncorrectData(String email, String password) throws IOException {
		getTxt_email().sendKeys(email);
		getTxt_pass().sendKeys(password);
		getBtn_submit().click();
		waitForElementToAppear(getLogin_error());
		if (getLogin_error().isDisplayed()) {
			Reporter.log("User is not allowed to login with incorrect credential");
		}
	}

	public void Loginwith_correctData(String email, String password) throws IOException {
		getTxt_email().clear();
		getTxt_pass().clear();
		getTxt_email().sendKeys(email);
		getTxt_pass().sendKeys(password);
		getBtn_submit().click();
		waitForPageToLoad();
		if (getWelcom_message().isDisplayed()) {
			Reporter.log("User is successfully logged in and navigated to dashboard");
		}
	}

}
