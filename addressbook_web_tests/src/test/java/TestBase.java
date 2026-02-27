import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init();
    }

    protected void createContact(Contact contact) {
        ApplicationManager.driver.findElement(By.name("firstname")).click();
        ApplicationManager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        ApplicationManager.driver.findElement(By.name("lastname")).click();
        ApplicationManager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        ApplicationManager.driver.findElement(By.name("address")).click();
        ApplicationManager.driver.findElement(By.name("address")).sendKeys(contact.address());
        ApplicationManager.driver.findElement(By.name("submit")).click();
        ApplicationManager.driver.findElement(By.linkText("home page")).click();
    }

    protected void removeContact() {
        ApplicationManager.driver.findElement(By.name("selected[]")).click();
        ApplicationManager.driver.findElement(By.cssSelector("input[value='Delete']")).click();
        ApplicationManager.driver.findElement(By.linkText("home page")).click();
    }

    protected void openAddNewPage() {
        if (!app.isElementPresent(By.name("firstname"))) {
            ApplicationManager.driver.findElement(By.linkText("add new")).click();
        }
    }

    protected boolean isContactPresent() {
        return app.isElementPresent(By.name("selected[]"));
    }

    protected void openHomePage() {
        if (! app.isElementPresent(By.cssSelector("input[value='Delete']"))) {
            ApplicationManager.driver.findElement(By.linkText("home")).click();
        }
    }
}
