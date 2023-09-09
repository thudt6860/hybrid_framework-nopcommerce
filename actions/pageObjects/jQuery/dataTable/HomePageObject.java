package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		senkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_PAGE_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_PAGE_BY_NUMBER_ACTIVE, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		// Cách làm: duyệt hết 24 trang paging để lấy ra tất cả các row của từng page lưu vào list
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size =" + totalPage);
		List<String> allRowValueAllPage = new ArrayList<>(); // list lưu all row ở all page (giá trị lưu vào List có thể trùng nhau)
		// Nếu không muốn lấy giá trị trùng thì dùng List Set<String>
		// Set<String> allRowValueUniqueAllPage = new HashSet<>();

		// Duyệt qua tất cả các page number (paging)
		for (int index = 1; index < totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index)); // phải ép kiểu int của index sang string để phù hợp với type của hàm
			sleepInSecond(1);

			// Get text của all row mỗi page đưa vào Array List
			// List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_PAGE);
			for (WebElement eachRow : allRowElementEachPage) { // Duyệt trong 1 paging để lấy all row của mỗi page lưu vào biến allRowValueAllPage
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// In tất cả giá trị row ra- tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println("------------------------");
			System.out.println(value);
		}
		return allRowValueAllPage;

	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String ValueToEnter) {
		// Lấy ra column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		// senkey vào dòng nào
		// xpath =//tbody/tr[%s]/td[%s]/input
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, ValueToEnter, rowNumber, String.valueOf(columnIndex));

	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String ValueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, ValueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);

	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckBoxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void unCheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		unCheckToDefaultCheckBox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void inputNumberByColumnNameAtRowNumber(String columnName, String rowNumber, String ValueToInput) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.INPUT_NUMBER_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.INPUT_NUMBER_BY_COLUMN_INDEX_AND_ROW_INDEX, ValueToInput, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);

	}

}
