package com.setianjay;

import com.microsoft.playwright.FrameLocator;
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

    @Test
    @DisplayName(value = "Verify Attribute Value and Content Value in Playwright")
    void verifyAttributeValueTest(){
        String url = "http://autopract.com/selenium/dropdown1/";
        String expectedContent = "Cricket";
        String expectedValue = "item2";

        // navigate url
        page.navigate(url);

        // get locator select with class name is custom-select
        Locator selectDropdown = page.locator("select.custom-select");
        /*
        * get cricket option with nth, nth start from 0 for the first position. Because
        * cricket on the second position, nth position is 1.
        * */
        Locator cricketOption = selectDropdown.locator("option >> nth=1");

        // get text content inside cricket option (result: Cricket)
        String actualContent = cricketOption.textContent();
        // get value attribute in cricket options (result: item2)
        String actualValue = cricketOption.getAttribute("value");

        /*
        * assert the value we get in value attribute and content is the same as the
        * value attribute and content we expect
        * */
        assertEquals(actualContent, expectedContent);
        assertEquals(actualValue, expectedValue);
    }

    @Test
    @DisplayName(value = "Verify Tooltip Content in Playwright")
    void verifyTooltipContentTest(){
        String url = "https://jqueryui.com/tooltip/";
        String expectedTooltipContent = "We ask for your age only for statistical purposes.";

        // navigate url we want to test
        page.navigate(url);

        // if the content is inside an iframe, we have to get the iframe first using FrameLocator like below
        FrameLocator frameWrap = page.frameLocator("iframe.demo-frame");

        // get ageInput inside an iframe by id
        Locator ageInput = frameWrap.locator("#age");

        // hover the ageInput
        ageInput.hover();

        /*
         * get tooltip inside an iframe by class name. In this case, the class name will only appear when the age input
         * is hover
         * */
        Locator tooltip = frameWrap.locator(".ui-tooltip-content");

        // get tooltip content
        String tooltipContent = tooltip.textContent();

        // assert the tooltip content we get is the same as the expected tooltip content we expect
        assertEquals(tooltipContent, expectedTooltipContent);
    }
}
