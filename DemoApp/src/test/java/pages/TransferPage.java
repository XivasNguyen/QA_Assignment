package pages;

import core.element.Button;
import core.element.DropDownList;
import core.element.Element;
import core.element.TextBox;

public class TransferPage extends MainPage {
    private final Element      eleTBA            = new Element("//app-transfer//div[@ng-reflect-router-link='admin/transfer-between-account']");
    private final Element      eleTBU            = new Element("//app-transfer//div[@ng-reflect-router-link='admin/transfer-between-users']");
    private final Element      eleTWT            = new Element("//app-transfer//div[@ng-reflect-router-link='admin/outgoing-wire-transfer']");
    private final DropDownList ddlSelectUser     = new DropDownList("//ng-select[contains(@class,'user-select')]");
    private final DropDownList ddlDebitFrom      = new DropDownList("//app-account-select[@formcontrolname='accountFrom']");
    private final DropDownList ddlCreditTo       = new DropDownList("//app-account-select[@formcontrolname='accountTo']");
    private final TextBox      txtTransferAmount = new TextBox("//input[@formcontrolname='outgoingAmount']");
    private final TextBox      txtDescription    = new TextBox("//textarea[@formcontrolname='description']");
    private final Button       btnContinue       = new Button("//button[@type='submit' and normalize-space()='Continue']");
    private final Button       btnConfirm        = new Button("//button[@type='submit' and normalize-space()='Confirm']");
    private final Element      successMessage    = new Element("//div[@class='success-popup']/div[@class='popup-message']");

    public void goToTransferBetweenAccounts() {
        this.navigateToMenu(MENU.TRANSFER);

        this.eleTBA.click();
    }

    public void selectUser(String name) {
        this.ddlSelectUser.selectByValue(name);
    }


    public void selectDebitFrom(String accountID) {
        this.ddlDebitFrom.selectByValue(accountID);
    }

    public void selectCreditTo(String accountID) {
        this.ddlCreditTo.selectByValue(accountID);
    }

    public void enterTransferAmount(String amount) {
        this.txtTransferAmount.sendKeys(amount);
    }

    public void enterDescription(String description) {
        this.txtDescription.sendKeys(description);
    }

    public void clickContinue() {
        this.btnContinue.click();
    }

    public void clickConfirm() {
        this.btnConfirm.click();
    }

    public String getSuccessMessage() {
        return this.successMessage.getText();
    }
}
