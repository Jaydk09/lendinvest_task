package base;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;

import java.util.logging.Logger;


public class TestBase {
    public TestBase(){
        selenideConfig();
    }

    protected void selenideConfig() {
        Configuration.pageLoadTimeout = 10000;
        Configuration.pollingInterval = 100;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.fastSetValue = true;
//        Configuration.holdBrowserOpen = true;
        Configuration.webdriverLogsEnabled = true;
//        Configuration.browser = "edge";  // chrome is default
//        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.browserSize = "1980x1000";
        Configuration.driverManagerEnabled = true;
        Configuration.browserCapabilities.setCapability("networkConnectionEnabled", true);
        Configuration.baseUrl = "https://ebay.co.uk";
    }
}
