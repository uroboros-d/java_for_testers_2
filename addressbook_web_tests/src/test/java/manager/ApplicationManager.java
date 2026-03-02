package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

    protected WebDriver driver;

    private LoginHelper session;

    private GroupHelper groups;

    public void init() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("https://localhost/addressbook/index.php");
            driver.manage().window().setSize(new Dimension(862, 688));
            session().login("admin", "secret");
        }
    }

    public  LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public  GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createContact(Contact contact) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.cssSelector("input[value='Delete']")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public void openAddNewPage() {
        if (!isElementPresent(By.name("firstname"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void openHomePage() {
        if (! isElementPresent(By.cssSelector("input[value='Delete']"))) {
            driver.findElement(By.linkText("home")).click();
        }
    }
}
