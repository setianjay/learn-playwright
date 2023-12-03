package com.setianjay;

import com.microsoft.playwright.Locator;
import com.setianjay.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class AssertionTest extends BaseTest {

    @Test
    @DisplayName(value = "Verify URL in Playwright")
    void verifyUrlTest(){
        String url = "https://www.programsbuzz.com/user/login";
        page.navigate(url);

        // get username input and password input with locator by its id
        Locator usernameInput = page.locator("#edit-name");
        Locator passwordInput = page.locator("#edit-pass");

        // fill the input
        usernameInput.fill("naruto");
        passwordInput.fill("naruto");

        // get current url
        String currentUrl = page.url();

        // assert the current url same with the url
        assertEquals(currentUrl, url);
    }
}
