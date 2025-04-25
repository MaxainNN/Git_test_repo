package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.selenium_dev.SeleniumPageSimplified;

/**
 * Тест для формы "Selenium Dev" (упрощенный)
 */
public class SeleniumPageTestSimplified extends BaseTest {

    private SeleniumPageSimplified seleniumPageSimplified;

    @BeforeClass
    public void beforeClass(){
        seleniumPageSimplified = new SeleniumPageSimplified(driver);
    }

    @Test(description = "Заполнение полей 'Text input', 'Text Area', 'Password'.")
    public void step_01() {
        seleniumPageSimplified.openWebFormPage();
        String fullName = "Калугин Максим Сергеевич";
        String companyName = "Лига цифровой экономики";
        String password = "Password";

        seleniumPageSimplified.sendTextInInput(fullName);
        seleniumPageSimplified.sendTextInTextArea(companyName);
        seleniumPageSimplified.sendPassword(password);

        Assert.assertEquals(seleniumPageSimplified.getTextFromInput(), fullName,
                "TextInput не соответствует ожидаемому!");
        Assert.assertEquals(seleniumPageSimplified.getTextFromTextArea(), companyName,
                "TextArea не соответствует ожидаемому!");
        Assert.assertEquals(seleniumPageSimplified.getPassword(), password,
                "Password не соответствует ожидаемому!");
    }

    @Test(description = "Выбрать в Dropdown значения")
    public void step_02() {
        String dropdownOption = "Two";
        String datalistOption = "Seattle";

        seleniumPageSimplified.chooseOptionInSelect(dropdownOption);
        seleniumPageSimplified.chooseOptionInDatalist(datalistOption);
    }

    @Test(description = "Отметить чекбоксы")
    public void step_03() {
        seleniumPageSimplified.setCheckbox1(true);
        seleniumPageSimplified.setCheckbox2(true);

        Assert.assertTrue(seleniumPageSimplified.GetCheckbox1(), "CheckBox 1 не отмечен!");
        Assert.assertTrue(seleniumPageSimplified.GetCheckbox2(), "CheckBox 2 не отмечен!");
    }

    @Test(description = "Отметить радиобаттон")
    public void step_04() {
        seleniumPageSimplified.setDefaultRadio();

        Assert.assertTrue(seleniumPageSimplified.getDefaultRadio(), "Радиобаттон не выбран!");
    }

    @Test(description = "Выбрать дату")
    public void step_05() {
        seleniumPageSimplified.selectDate();
    }

    @Test(description = "Установить цвет")
    public void step_06() {
        seleniumPageSimplified.selectGreenColor();
    }

    // Метод для установки range в максимальное значение

    @Test(description = "Нажать 'Submit'")
    public void step_07() {
        seleniumPageSimplified.submitForm();
        // Проверка отображения текста
    }
}