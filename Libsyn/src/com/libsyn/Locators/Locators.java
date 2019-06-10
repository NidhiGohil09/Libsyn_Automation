package com.libsyn.Locators;

public interface Locators {

	public interface TemplatePageLocator{
		final static String BACK_BUTTON = ".//input[@id='Email']";

	}
	
	public interface LoginPageLocators {
		final static String LOGINPAGE_EMAIL = ".//input[@id='Email']";
		final static String LOGINPAGE_PASSWORD = ".//input[@id='Password']";
		final static String LOGINPAGE_BTN_LOGIN = ".//input[@type='submit']";
		final static String LOGINPAGE_ERROR = "//span[text()='Incorrect Username/Password.']";
		final static String WELCOME_MESSAGE="//p[text()='Welcome to LibSyn']";
	}

	public interface DashboardLocators {
		final static String DASHBOARD_MENU = "//li/a[@href='/advertiser/dashboard']";
		// Dash-board Label
		final static String DASHBOARD_LABEL = "//div[@class='db-heading']//h1";
		// Locators for Current Campaign, Active Campaign
		final static String DASHBOARD_CAMPAIGN_DETAIL = "//ul[@class='db-count-list']/li[1]";
		// Active Total bids from Advertiser, Active Network, Active Podcast
		final static String DASHBOARD_ACTIVE_DETAIL = "//ul[@class='db-count-list']/li[2]";
		// Ad Drop Tracking, Campaign Complete Request
		final static String DASHBOARD_AD_TRACKING_DETAIL = "//ul[@class='db-count-list']/li[3]";
		final static String DASHBOARD_ACTIVE_CAMPAIGN_TILE = "//div[contains(@class,' db-activepd-block')]/h1";
		final static String DASHBOARD_CAMPAIGN_WITH_HIGHBID_TILE = "//div[contains(@class,'db-highest-mt')]/h1";
		final static String DASHBOARD_BID_RECEIVED_FOR_CAMPAIGN_TILE = "//div[contains(@class,'db-bidreceive-block mb30')]/h1";
		final static String DASHABOARD_ACTIVE_DISPUTE_TILE = "//div[not(contains(@class,'mb30')) and contains(@class,' db-bidreceive-block')]/h1";
		final static String DASHBOARD_FUTURE_CAMPAIGN_TILE = "//div[not(contains(@class,'db-highest-mt')) and contains(@class,'db-inner-block ')]/h1";
		//Podcoin image
		final static String DASHBOARD_PODCOIN_IMAGE="//h2[@class='wallet']/span/img[contains(@src,'podcoin-icon')]";
		//Page Titles
		final static String ACTIVE_CAMPAIGNS_PAGE="//h1[contains(@class,'heading')]";
		//final static String 
	}

		
}
