package reportConfig;

// public class ExtentTestManagerV2 {
// static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
// static ExtentReports extent = ExtentManagerV2.getReporter();
//
// public static synchronized ExtentTest getTest() {
// return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
// }
//
// public static synchronized void endTest() {
// extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
// }
//
// public static synchronized ExtentTest startTest(String testName, String desc) {
// ExtentTest test = extent.startTest(testName, desc);
// extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
// return test;
// }}
