package manager;

import model.Group;
import org.openqa.selenium.By;

public class GroupHelper {

    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void openGroupsPage() {
        if (! manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createGroup(Group group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        submitGroupDeletion();
        returnToGroupsPage();
    }

    public void modifyGroup(Group modifiedgroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedgroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void fillGroupForm(Group group) {
        click(By.name("group_name"));
        manager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        click(By.name("group_header"));
        manager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        click(By.name("group_footer"));
        manager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
    }

    private void submitGroupDeletion() {
        click(By.name("delete"));
    }

    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void click(By submit) {
        manager.driver.findElement(submit).click();
    }
}
