package reportConfig;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "/extentV2/ExtentReportV2Screenshot.html", true);
		}
		return extent;
	}

}
