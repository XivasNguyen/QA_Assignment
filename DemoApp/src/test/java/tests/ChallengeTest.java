package tests;

import core.Validation;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransferPage;
import reporter.Reporter;
import utils.DataHelper;

import java.util.Map;


public class ChallengeTest extends TestBase {

    TransferPage transferPage = new TransferPage();

    @Test
    void User_Can_Transfer_Between_Accounts()  {
        Map<String, String> data = DataHelper.loadDataFromClassName();
        Reporter.logTestStep("Step #1: Login to web application with provided credentials");

        new LoginPage().login(props.getProperty("cred.username"), props.getProperty("cred.password"));

        Reporter.logTestStep("Step #2: Navigate to the `Transfers` side menu");

        Reporter.logTestStep("Step #3: Click on the `Transfer Between Accounts` placeholder");
        transferPage.goToTransferBetweenAccounts();

        Reporter.logTestStep("Step #4: Select `Mary Johnson` of the `Select the user` dropdown");
        transferPage.selectUser(data.get("user"));

        Reporter.logTestStep("Step #5: Select any available debit account of the `Debit from` dropdown");
        transferPage.selectDebitFrom(data.get("debitFrom"));

        Reporter.logTestStep("Step #6: Select any available credit account of the `Credit to` dropdown");
        transferPage.selectCreditTo(data.get("creditTo"));

        Reporter.logTestStep("Step #7: Input amount into `Amount to transfer` text field");
        String amount = data.get("amount");
        transferPage.enterTransferAmount(amount);

        Reporter.logTestStep("Step #8: Input the description");
        transferPage.enterDescription(String.format(data.get("description"), amount));

        Reporter.logTestStep("Step #9: Click on Continue");
        transferPage.clickContinue();

        Reporter.logTestStep("Step #10: Click on Confirm");
        transferPage.clickConfirm();

        Reporter.logTestStep("VP: The success message is present");
        Validation.textContains(transferPage.getSuccessMessage(), data.get("successMessage"));
    }

}
