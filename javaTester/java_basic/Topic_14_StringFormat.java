package java_basic;

public class Topic_14_StringFormat {

	// 14 pages = 14 biến locator
	public static String MY_PRODUCT_REVIEW_LINK = "//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK = "//a[text()='Reward points']";
	public static String CUSTOMER_INFO_LINK = "//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "//div[contains(@class,'block-account')]//a[text()='Addresses']";
	// 1 BIẾN cho cả 14 page hoặc n page (format giống nhau - chỉ khác nhau bởi tên page)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//a[text()='%s']";
	public static final String DYNAMIC_LINK_BY_PAGE_NAME2 = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "My product reviews");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Reward points");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Customer info");

		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME2, "block-account", "Addresses");

	}

	public static void clickToLink(String locator) {
		System.out.println("Click to: " + locator);
	}

	// // 1 tham số động
	// public static void clickToLink(String dynamicLocator, String pageName) {
	// String locator = String.format(dynamicLocator, pageName);
	// System.out.println("Click to: " + locator);
	// }
	//
	// // 2 tham số động
	// public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
	// String locator = String.format(dynamicLocator, areaName, pageName);
	// System.out.println("Click to: " + locator);
	// }

	// 1-n tham số động
	// viết 1 hàm dùng chung cho các page khấc nhau khi có chung xpath
	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to:" + locator);
	}
}
