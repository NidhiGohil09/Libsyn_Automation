package test.java;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.libsyn.configuration.BasePage;
import com.libsyn.configuration.configFileReader;
import com.libsyn.pages.Advertiser_DashboardPage;
import com.libsyn.pages.LoginPage;

public class LibsynTest {

	@BeforeSuite
	public void setUpBrowser() {
		BasePage.OpenApplication();
	}

	@Test(priority = 1, description = "This testcase is to verify the login functionality with negative scenario")
	public void loginwithIncorrectData() throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.Loginwith_IncorrectData(configFileReader.getCustomProperty("incorrect_email"),
				configFileReader.getCustomProperty("password"));
	}

	@Test(priority = 2, description = "This testcase is to verify the login functionality with positive scenario")
	public void loginwithCorrectData() throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.Loginwith_correctData(configFileReader.getCustomProperty("email"),
				configFileReader.getCustomProperty("password"));
	}

	@Test(priority = 3, description = "This testcase is to verify the login functionality with negative scenario")
	public void TestAdvertiserDashboard() throws Exception {
		Advertiser_DashboardPage advertiser_Dashboard = new Advertiser_DashboardPage();
		advertiser_Dashboard.verifyDashbordetails();
	}
	
	@AfterSuite
	public void closeBrowser() {
		BasePage.closeBroswer();
	}
}
