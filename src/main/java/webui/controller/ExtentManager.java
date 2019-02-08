package webui.controller;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ExtentManager class is used to generate HTML reports which can be found in 'outputs'.
 * It will be implemented later on.
 */
public class ExtentManager {
    private static SimpleDateFormat readTime = new SimpleDateFormat("d-MMM-yyyy");
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;


    @BeforeClass
    public static void beforeGlobal() {
        htmlReporter = new ExtentHtmlReporter((System.getProperty("user.dir") + "/src/main/outputs/"
                + readTime.format(new Date())
                + "-Report.html"));
        htmlReporter.config().setReportName("Daily Report for " + readTime.format(new Date()));
        htmlReporter.setAppendExisting(true);
        report = new ExtentReports();

        report.attachReporter(htmlReporter);

    }

    @AfterClass
    public static void afterGlobal() {
        report.flush();
    }
}
