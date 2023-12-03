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

    @Test
    @DisplayName(value = "Verify Placeholder Text in Playwright")
    void verifyPlaceholderTextTest(){
        String url = "https://www.facebook.com/?locale=id_ID";
        String expectedUsernameInputPlaceholder = "Email atau Nomor Telepon";
        String expectedPasswordInputPlaceholder = "Kata Sandi";

        // navigate url
        page.navigate(url);

        // get username input and password input with locator by its id
        Locator usernameInput = page.locator("#email");
        Locator passwordInput = page.locator("#pass");

        // fill the username input and password input with the given value
        usernameInput.fill("hari11setiaji@gmail.com");
        passwordInput.fill("passwordngasal12345678");

        // get value on placeholder for each input
        String actualUsernamePlaceholder = usernameInput.getAttribute("placeholder");
        String actualPasswordPlaceholder = passwordInput.getAttribute("placeholder");

        // assert the value we get is the same as the value we expect
        assertEquals(actualUsernamePlaceholder, expectedUsernameInputPlaceholder);
        assertEquals(actualPasswordPlaceholder, expectedPasswordInputPlaceholder);
    }
}
