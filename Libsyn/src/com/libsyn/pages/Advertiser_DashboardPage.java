package com.libsyn.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.libsyn.Locators.Locators.DashboardLocators;
import com.libsyn.configuration.configFileReader;

public class Advertiser_DashboardPage extends LoginPage implements DashboardLocators {

	@FindBy(how = How.XPATH, using = DASHBOARD_ACTIVE_DETAIL)
	private WebElement active_campaigns;

	@FindBy(how = How.XPATH, using = DASHBOARD_AD_TRACKING_DETAIL)
	private WebElement bids_from_networkadmin;

	@FindBy(how = How.XPATH, using = DASHBOARD_CAMPAIGN_DETAIL)
	private WebElement campaign_completerequest;

	@FindBy(how = How.XPATH, using = DASHBOARD_LABEL)
	private WebElement dashboard_label;

	@FindBy(how = How.XPATH, using = DASHBOARD_MENU)
	private WebElement menu_dashboard;

	@FindBy(how = How.XPATH, using = DASHBOARD_ACTIVE_CAMPAIGN_TILE)
	private WebElement active_campaign_tile;

	@FindBy(how = How.XPATH, using = DASHBOARD_CAMPAIGN_WITH_HIGHBID_TILE)
	private WebElement campaign_with_highbid_tile;

	@FindBy(how = How.XPATH, using = DASHBOARD_BID_RECEIVED_FOR_CAMPAIGN_TILE)
	private WebElement bids_received_tile;

	@FindBy(how = How.XPATH, using = DASHABOARD_ACTIVE_DISPUTE_TILE)
	private WebElement active_dispute_tile;

	@FindBy(how = How.XPATH, using = DASHBOARD_FUTURE_CAMPAIGN_TILE)
	private WebElement future_camapign_title;

	@FindBy(how = How.XPATH, using = DASHBOARD_PODCOIN_IMAGE)
	private WebElement podcoin_icon;

	public WebElement getMenu_dashboard() {
		return menu_dashboard;
	}

	public WebElement getDashboard_label() {
		return dashboard_label;
	}

	public WebElement getActive_campaigns() {
		return active_campaigns;
	}

	public WebElement getBids_from_networkadmin() {
		return bids_from_networkadmin;
	}

	public WebElement getCampaign_completerequest() {
		return campaign_completerequest;
	}

	public WebElement getActive_campaign_tile() {
		return active_campaign_tile;
	}

	public WebElement getCampaign_with_highbid_tile() {
		return campaign_with_highbid_tile;
	}

	public WebElement getBids_received_tile() {
		return bids_received_tile;
	}

	public WebElement getActive_dispute_tile() {
		return active_dispute_tile;
	}

	public WebElement getFuture_camapign_title() {
		return future_camapign_title;
	}

	// Method to verify dashboard details

	public WebElement getPodcoin_icon() {
		return podcoin_icon;
	}

	//Method to verify dashboard tiles and 
	public void verifyDashbordetails() throws Exception {
		if (driver.getCurrentUrl().contains("/login")) {
			try {
				super.Loginwith_correctData(configFileReader.getCustomProperty("email"),
						configFileReader.getCustomProperty("password"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			//getMenu_dashboard().click();
			waitForElementToAppear(getDashboard_label());

			if (getDashboard_label().isDisplayed()) {
				Reporter.log("User is on Dashboard");
			}
			// Verifying the total counts
			verifyElemet(getActive_campaign_tile(), "Avtive Campaign count on dashboard");
			verifyElemet(getBids_from_networkadmin(), "Count for Total bids");
			verifyElemet(getCampaign_completerequest(), "Count for campaign complete request");

			// Verifying tiles
			verifyElemet(getActive_campaign_tile(), "Active campaign tile");
			verifyElemet(getActive_dispute_tile(), "Active dispute tile");
			verifyElemet(getBids_received_tile(), "Bids received tile");
			verifyElemet(getCampaign_with_highbid_tile(), "Campaign with highest bid tile");
			verifyElemet(getFuture_camapign_title(), "Future Campaign tile");
			verifyElemet(getPodcoin_icon(), "Podcoin icon");
		}

	}
	
	//Method to verify dashboard navigations
	public void verifynavigations()
	{
		waitForElementToAppear(getActive_campaign_tile());
		getActive_campaign_tile().click();
		
		
	}
	
	
	

}
