package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
* The class which creates and manages the singleton instance of the Extent Report.
* @version 1.0
* @author Hussein ElSherif
*/
public class ReportFactory {
	private ReportFactory() {}

    private static ExtentReports instance ;

    /**
     * This method initializes a lazy singleton instance of the Extent Report incase it isnt already created, then returns it to the caller.
     * @return instance of Extent Report
     */
    public static synchronized ExtentReports getReportInstance() throws IOException {
    	if(instance == null) {
            instance =  new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Reader.getProperty("reportPath")+"report.html");
            htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
            htmlReporter.config().setReportName("Functional Testing"); // Name of the report
            htmlReporter.config().setTheme(Theme.DARK);//theme of report
            instance.attachReporter(htmlReporter);
        }
        return instance;
    }
}
