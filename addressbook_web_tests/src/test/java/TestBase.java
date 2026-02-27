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
