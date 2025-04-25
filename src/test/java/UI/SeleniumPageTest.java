package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.selenium_dev.SeleniumPage;

/**
 * Тест для формы "Selenium Dev"
 */
public class SeleniumPageTest extends BaseTest {

    private SeleniumPage seleniumPage;

    @BeforeClass
    public void beforeClass(){
        seleniumPage = new SeleniumPage(driver);
    }

    @Test(description = "Заполнение полей 'Text input', 'Text Area', 'Password'.")
    public void step_01(){
        seleniumPage.openSeleniumPage();
        Assert.assertTrue(seleniumPage.setAndDisplayText("Kalugin Maxim Sergeevich",
                seleniumPage.TEXT_INPUT_XPATH));
        Assert.assertTrue(seleniumPage.setAndDisplayText("Ligue of Digital Economy",
                seleniumPage.TEXT_AREA_XPATH));
        Assert.assertTrue(seleniumPage.setAndDisplayText("Password",
                seleniumPage.PASSWORD_XPATH));
    }

    @Test(description = "Выбрать в Dropdown значения")
    public void step_02(){
        Assert.assertTrue(seleniumPage.selectDropdownOption("Two"));
        Assert.assertTrue(seleniumPage.selectDatalistOption("Seattle"));
    }

    @Test(description = "Отметить чекбоксы , радиобаттоны")
    public void step_03(){
        seleniumPage.setCheckbox("1", true);
        seleniumPage.setCheckbox("2", true);
        Assert.assertTrue(seleniumPage.checkboxState("1"));
        Assert.assertTrue(seleniumPage.checkboxState("2"));
        seleniumPage.setRadio("2");
        Assert.assertTrue(seleniumPage.radioState("2"));
        Assert.assertFalse(seleniumPage.radioState("1"));
    }

    @Test(description = "Выбрать дату")
    public void step_04(){
        Assert.assertTrue(seleniumPage.setDate("09/23/2024"));
    }

    @Test(description = "Установить цвет")
    public void step_05(){
        Assert.assertTrue(seleniumPage.setColor("#ffffff"));
    }

    @Test(description = "Перевести range в максимальное состояние")
    public void step_06(){
        Assert.assertTrue(seleniumPage.setSlider(10));
    }

    @Test(description = "Нажать 'Submit'")
    public void step_07(){
        Assert.assertTrue(seleniumPage.submit());
    }
}