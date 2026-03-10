package manager;

import model.Contact;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(Contact contact) {
        openAddNewPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
    }

    public void removeContact() {
        openHomePage();
        selectContact();
        submitContactDeletion();
        returnToHomePage();
    }

    private void submitContactDeletion() {
        click(By.cssSelector("input[value='Delete']"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    public void openAddNewPage() {
        if (!manager.isElementPresent(By.name("firstname"))) {
            click(By.linkText("add new"));
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void openHomePage() {
        if (! manager.isElementPresent(By.cssSelector("input[name='searchstring']"))) {
            click(By.linkText("home"));
        }
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openHomePage();
        click(By.id("MassCB"));
        submitContactDeletion();
        returnToHomePage();
    }

    public List<Contact> getList() {
        var contacts = new ArrayList<Contact>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var cells = tr.findElements(By.tagName("td"));
            var id = cells.get(0).findElement(By.tagName("input")).getAttribute("id");
            var lastname = cells.get(1).getText();
            var firstname = cells.get(2).getText();
            var address = cells.get(3).getText();
            contacts.add(new Contact().
                    withId(id).
                    withLastname(lastname).
                    withFirstname(firstname)
                    .withAddress(address));
        }
        return contacts;
    }
}