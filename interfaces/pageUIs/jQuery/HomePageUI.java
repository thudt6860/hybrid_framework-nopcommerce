package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGING_PAGE_BY_NUMBER = "XPATH=//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String PAGING_PAGE_BY_NUMBER_ACTIVE = "XPATH=//li[@class ='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "XPATH=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "CSS=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_BY_INDEX = "XPATH=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "XPATH=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_PAGE = "XPATH=//tbody/tr/td[@data-key='country']";

	// Index của cái cột mà mình cần enter/click/ select vào
	public static final String COLUMN_INDEX_BY_NAME = "XPATH=//tr/th[text()='%s']/preceding-sibling::th";

	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String INPUT_NUMBER_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[%s]//input[@type='number']";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "XPATH=//tbody/tr[%s]/td[%s]//select";
	public static final String ICON_NAME_BY_ROW_NUMBER = "XPATH=//tbody/tr[%s]//button[@title='%s']";
	public static final String LOAD_BUTTON = "CSS=button#load";
}
