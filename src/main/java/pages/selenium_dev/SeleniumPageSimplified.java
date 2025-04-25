package pages.selenium_dev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

/**
 * Класс с Page для страницы "Selenium.dev" (упрощенный)
 */
public class SeleniumPageSimplified extends BasePage {

    public SeleniumPageSimplified(WebDriver driver) {
        super(driver);
    }

    private static final String URL_WEB_FORM = "https://www.selenium.dev/selenium/web/web-form.html";
    private static final By TEXT_INPUT = By.xpath("//input[@id='my-text-id']");
    private static final By TEXT_AREA = By.xpath("//textarea[@name='my-textarea']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@name='my-password']");
    private static final By DROPDOWN_SELECT = By.xpath("//select[@name='my-select']");
    private static final By DROPDOWN_DATALIST = By.name("my-datalist");
    private static final By CHECKBOX_1 = By.xpath("//input[@id='my-check-1']");
    private static final By CHECKBOX_2 = By.xpath("//input[@id='my-check-2']");
    private static final By RADIO_DEFAULT = By.xpath("//input[@id='my-radio-2']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-outline-primary mt-3']");
    private static final By SUCCESS_MESSAGE = By.xpath("//h1[@class = 'display-6']");
    private static final By DATE_PICKER = By.xpath("//input[@name='my-date']");
    private static final By COLOR_PICKER = By.xpath("//input[@name='my-colors']");
    private static final By EXAMPLE_RANGE = By.xpath("//input[@name='my-range']");

    /**
     * Открыть главную страницу
     */
    public void openWebFormPage() {
        openUrl(URL_WEB_FORM);
    }

    /**
     * Внести текст в Input элемент
     * @param text текст
     */
    public void sendTextInInput(String text) {
        sendKeys(TEXT_INPUT, text);
    }

    /**
     * Внести текст в Text Area элемент
     * @param text текст
     */
    public void sendTextInTextArea(String text) {
        sendKeys(TEXT_AREA, text);
    }

    /**
     * Внести пароль в Input элемент
     * @param password пароль
     */
    public void sendPassword(String password) {
        sendKeys(PASSWORD_INPUT, password);
    }

    /**
     * Получить значение из Input элемента
     * @return значение атрибута value
     */
    public String getTextFromInput() {
        return findElement(TEXT_INPUT).getAttribute("value");
    }

    /**
     * Получить значение пароля из Input элемента
     * @return значение атрибута value
     */
    public String getPassword() {
        return findElement(PASSWORD_INPUT).getAttribute("value");
    }

    /**
     * Получить значение из Text Area элемента
     * @return значение атрибута value
     */
    public String getTextFromTextArea() {
        return findElement(TEXT_AREA).getAttribute("value");
    }

    /**
     * Выбрать значение в выпадающем списке
     * @param option значение в выпадающем списке
     */
    public void chooseOptionInSelect(String option) {
        Select dropdown = new Select(findElement(DROPDOWN_SELECT));
        dropdown.selectByVisibleText(option);
    }

    /**
     * Выбрать значение в datalist элементе
     * @param option значение в элементе
     */
    public void chooseOptionInDatalist(String option) {
        WebElement datalist = findElement(DROPDOWN_DATALIST);
        datalist.sendKeys(option);
    }

    /**
     * Установить чекбокс 1
     * @param state состояние чекбокса
     */
    public void setCheckbox1(boolean state) {
        WebElement checkbox = findElement(CHECKBOX_1);
        if (checkbox.isSelected() != state) {
            checkbox.click();
        }
    }

    /**
     * Установить чекбокс 2
     * @param state состояние чекбокса
     */
    public void setCheckbox2(boolean state) {
        WebElement checkbox = findElement(CHECKBOX_2);
        if (checkbox.isSelected() != state) {
            checkbox.click();
        }
    }

    /**
     * Проверка - чекбокс 1 отмечен
     * @return true если отмечен
     */
    public boolean GetCheckbox1() {
        return findElement(CHECKBOX_1).isSelected();
    }

    /**
     * Проверка - чекбокс 2 отмечен
     * @return true если отмечен
     */
    public boolean GetCheckbox2() {
        return findElement(CHECKBOX_2).isSelected();
    }

    /**
     * Установить радиобаттон
     */
    public void setDefaultRadio() {
        click(RADIO_DEFAULT);
    }

    /**
     * Проверка - радиобаттон отмечен
     * @return true если отмечен
     */
    public boolean getDefaultRadio() {
        return findElement(RADIO_DEFAULT).isSelected();
    }

    /**
     * Нажать на кнопку "Submit"
     */
    public void submitForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON));
        submitButton.click();
    }

    /**
     * Установить дату
     */
    public void selectDate() {
        String date = "2024-09-23";
        sendKeys(DATE_PICKER, date);
    }

    /**
     * Установить цвет
     */
    public void selectGreenColor() {
        String greenColor = "#00FF00";
        sendKeys(COLOR_PICKER, greenColor);
    }
}