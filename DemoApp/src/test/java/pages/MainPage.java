package pages;

import utils.Utilities;
import core.Logger;
import core.element.Element;

import java.time.Duration;

enum MENU {
    REQUEST("Requests"), ACCOUNT("Accounts"), PROFILE("Profiles"), TRANSFER("Transfers"),
    MESSAGE("Messages"), NEW("News"), SYSTEM("System log"), SETTING("Settings"), REPORT("Reports");

    private final String menuName;

    MENU(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

}

public class MainPage {

    private Element getSideMenu(String menuName) {
        return new Element(String.format("//app-admin-aside-menu//*[text()='%s']", menuName));
    }

    private final Element eleActiveMenu = new Element("//app-admin-aside-menu//div[@class='aside__row active']/label");
    private final Element icoLoading    = new Element("//ngx-spinner//div[@class='loading-text']");

    public void navigateToMenu(MENU menu) {
        if (this.icoLoading.isDisplayed()) {
            this.icoLoading.waitForNotDisplays(5);
        }
        this.eleActiveMenu.waitForDisplayed();
        String currentMenu = this.eleActiveMenu.getText();
        Element sideMenu = this.getSideMenu(menu.getMenuName());

        if (sideMenu.getText().equalsIgnoreCase(currentMenu)) {
            Logger.info(String.format("The current active menu has already selected: %s", currentMenu));
            return;
        }
        Utilities.sleep(Duration.ofSeconds(2));
        sideMenu.click();
    }
}
