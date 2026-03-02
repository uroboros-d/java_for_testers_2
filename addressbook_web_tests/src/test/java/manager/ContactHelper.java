package manager;

import model.Contact;
import org.openqa.selenium.By;

public class ContactHelper {

    private final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void createContact(Contact contact) {
        openAddNewPage();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.cssSelector("input[value='Delete']")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void openAddNewPage() {
        if (!manager.isElementPresent(By.name("firstname"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void openHomePage() {
        if (! manager.isElementPresent(By.cssSelector("input[value='Delete']"))) {
            manager.driver.findElement(By.linkText("home")).click();
        }
    }
}
