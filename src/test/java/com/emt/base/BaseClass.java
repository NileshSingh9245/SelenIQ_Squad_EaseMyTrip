//package com.emt.base;
//
//
//import java.net.URL;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import com.emt.config.ConfigReader;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseClass {
//    public static WebDriver driver;
//
//    public static WebDriver initializeDriver(String browser) {
//        try {
//            ConfigReader.loadConfig("src/test/resources/config/browser.properties");
//            String gridEnabled = ConfigReader.get("grid.enabled");
//            String gridUrl = ConfigReader.get("grid.url");
//            if (gridEnabled != null && gridEnabled.equalsIgnoreCase("true")) {
//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                capabilities.setBrowserName(browser);
//                driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
//            } else {
//                if (browser.equalsIgnoreCase("chrome")) {
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                } else if (browser.equalsIgnoreCase("firefox")) {
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                }
//            }
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
//
