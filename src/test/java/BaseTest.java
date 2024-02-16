import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    private WebDriver driver = null;
    protected WebDriverWait wait = null;
    protected Actions actions = null;

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    @BeforeMethod
    @Parameters("baseUrl")
    public void setUpDriver(String url) throws MalformedURLException {
        driver = pickDriver(System.getProperty("browser"));
        threadLocal.set(driver);

        threadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //   String url = "https://qa.koel.app/";
        threadLocal.get().get(url);
        wait = new WebDriverWait(threadLocal.get(), Duration.ofSeconds(10));
        actions = new Actions(threadLocal.get());
    }

    public WebDriver getDriver() {
        return threadLocal.get();
    }

    @AfterMethod
    public void closeBrowser() {
        threadLocal.get().quit();
    }

    public WebDriver pickDriver(String browser) throws MalformedURLException {
        String gridUrl = "http://192.168.40.222:4444/";       // копируем ссылку для удаленного запуска
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid":         // для удаленного запуска
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
            case "lambda":
                return getLambdaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }
    }

    //команда запуска: gradle clean test -Dbrowser=lambda
    public WebDriver getLambdaDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String hub = "@hub.lambdatest.com/wd/hub";
        String userName = "fantazer.apx";
        String accessKey = "jnyTSPqL10H1q2VKgZYmi5VDk83mFridy1vCd63c3256wFhNcu";
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "121.0");
        HashMap<String, Object> lambdaTestOptions = new HashMap<>();
        lambdaTestOptions.put("uresname", userName);
        lambdaTestOptions.put("accessKey", accessKey);
        lambdaTestOptions.put("platformName", "Windows 10");
        lambdaTestOptions.put("project", "Koel");
        capabilities.setCapability("LT:Options", lambdaTestOptions);
        return driver = new RemoteWebDriver(URI.create("https://" + userName + ":" + accessKey + hub).toURL(), capabilities);
    }
}


// java -jar selenium-server-4.17.0.jar standalone - for Terminal

            //  "http://192.168.40.222:4444/" ссылка








