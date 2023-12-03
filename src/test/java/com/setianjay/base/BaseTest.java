package com.setianjay.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;

    protected Page page;

    private final BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50.0);

    @BeforeEach
    void setup(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(launchOptions);
        page = browser.newPage();
    }

    @AfterEach
    void shutdown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
