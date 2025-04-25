package pages.selenium_dev;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

/**
 * Класс с Page для страницы "Selenium.dev"
 */
public class SeleniumPage extends BasePage {

    public SeleniumPage(WebDriver driver) {
        super(driver);
    }

    private static final String SELENIUM_PAGE_URL = "https://www.selenium.dev/selenium/web/web-form.html";
    public static final By TEXT_INPUT_XPATH = By.xpath("//input[@name='my-text']");
    public static final By TEXT_AREA_XPATH = By.xpath("//textarea[@name='my-textarea']");
    public static final By PASSWORD_XPATH = By.xpath("//input[@name='my-password']");
    private static final By SELECT_XPATH = By.xpath("//select[@name='my-select']");
    private static final String OPTIONS_XPATH = "//option[text()='%s']";
    private static final By DATALIST_PATH = By.xpath("//input[@list='my-options']");
    private static final String DATALIST_OPTION = "//option[@value='%s']";
    private static final String CHECKBOX_PATH = "//input[@id='my-check-%s']";
    private static final String RADIO_PATH = "//input[@id='my-radio-%s']";
    private static final By SUBMIT_BUTTON = By.xpath("//button[text()='Submit']");
    private static final By SUBMIT_MESSAGE = By.xpath("//h1[text()='Form submitted']");
    private static final By SUBMIT_MESSAGE_1 = By.xpath("//p[text()='Received!']");
    private static final By DATE_PATH = By.xpath("//input[@name='my-date']");
    private static final By COLOR_PATH = By.xpath("//input[@name='my-colors']");
    private static final By SLIDER_PATH = By.xpath("//input[@name='my-range']");

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * Открыть страницу "Selenium Web Form"
     */
    public void openSeleniumPage() {
        openUrl(SELENIUM_PAGE_URL);
    }

    /**
     * Выбрать опцию в Dropdown
     * @param option опция в выпадающем списке
     * @return true если значение в option отображается в выпадающем списке
     */
    public boolean selectDropdownOption(String option) {
        click(SELECT_XPATH);
        click(By.xpath(String.format(OPTIONS_XPATH, option)));
        String some = js.executeScript("return arguments[0].options[arguments[0].selectedIndex].text",
                findElement(SELECT_XPATH)).toString();
        return some.equals(option);
    }

    /**
     * Выбрать опцию в Datalist
     * @param option опция в выпадающем списке
     * @return true если значение в option отображается в выпадающем списке
     */
    public boolean selectDatalistOption(String option) {
        sendKeys(DATALIST_PATH, option);
        String some = js.executeScript("return arguments[0].value",
                findElement(DATALIST_PATH)).toString();
        return some.equals(option);
    }

    /**
     * Проверка состояния чекбокса
     * @param number порядковый номер чекбокса
     * @return true если чекбокс отмечен
     */
    public boolean checkboxState(String number){
        return findElement(By.xpath(String.format(CHECKBOX_PATH, number))).isSelected();
    }

    /**
     * Установить чекбокс
     * @param number порядковый номер чекбокса
     * @param state сосотяние чекбокса
     */
    public void setCheckbox(String number, boolean state){
        if (checkboxState(number) != state){
            click(By.xpath(String.format(CHECKBOX_PATH, number)));
        }
    }

    /**
     * Проверка состояния радиобаттона
     * @param number порядковый номер чекбокса
     * @return true если рабиобаттон отмечен
     */
    public boolean radioState(String number){
        return findElement(By.xpath(String.format(RADIO_PATH, number))).isSelected();
    }

    /**
     * Установить радиобаттон
     * @param number порядковый номер радиобаттон
     */
    public void setRadio(String number){
        if (!radioState(number)){
            click(By.xpath(String.format(RADIO_PATH, number)));
        }
    }

    /**
     * Установить текст и проверить отображаение
     * @param text текст
     * @param locator путь до элемента , тип - By
     * @return true , если текст отображается
     */
    public boolean setAndDisplayText(String text, By locator) {
        sendKeys(locator, text);
        String some = js.executeScript("return arguments[0].value",
                findElement(locator)).toString();
        return some.equals(text);
    }

    /**
     * Установить дату и проверить отображение
     * @param date дата
     * @return true если дата отображается
     */
    public boolean setDate(String date){
        sendKeys(DATE_PATH, date);
        findElement(DATE_PATH).sendKeys(Keys.ENTER);
        String some = js.executeScript("return arguments[0].value",
                findElement(DATE_PATH)).toString();
        return some.equals(date);
    }

    /**
     * Установить цвет и проверить отображение
     * @param color цвет
     * @return true если цвет отображается
     */
    public boolean setColor(String color){
        sendKeys(COLOR_PATH, color);
        String some = js.executeScript("return arguments[0].value",
                findElement(COLOR_PATH)).toString();
        return some.equals(color);
    }

    /**
     * Установить элемент "Example Range" в максимальное значение и проверить
     * @param value значение (по умолчанию слайдер наполовину заполнен)
     * Для того , чтобы установить макисмальное значение , нужно в value передать - 10
     * @return true если элемент установлен в максимальное значение
     */
    public boolean setSlider(int value){
        for (int i=5; i<value; i++){
            findElement(SLIDER_PATH).sendKeys(Keys.RIGHT);
        }

        String some = js.executeScript("return arguments[0].value", findElement(SLIDER_PATH)).toString();
        return some.equals(String.valueOf(value));
    }

    /**
     * Нажать на кнопку "Submit" и проверить отображение сообщений
     * @return true если сообщения отображаются
     */
    public boolean submit(){
        click(SUBMIT_BUTTON);
        return isElementDisplay(SUBMIT_MESSAGE) && isElementDisplay(SUBMIT_MESSAGE_1);
    }
}