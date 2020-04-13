package tests;

import org.junit.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class CreateNewIssueTest {

    // to assure that each test uses unique issue name
    private final String issueName = "SampleSummary"+System.currentTimeMillis();
    private final String homepage = "https://qa-test-fad-1.myjetbrains.com/youtrack";

    private LoginPage loginPage = new LoginPage();
    private MyDashboardPage myDashboardPage = new MyDashboardPage();
    private NewIssuePage newIssuePage = new NewIssuePage();
    private IssuesPage issuesPage = new IssuesPage();
    private HeaderMenu headerMenu = new HeaderMenu();

    @Test
    public void loginAndReportIssue() {
        open(homepage);
        loginPage.loginCorrect();
        myDashboardPage.isOpen();
        headerMenu.createNewIssue();
        newIssuePage.insertSummary(issueName);
        newIssuePage.createIssue();
        headerMenu.goToIssues();
        issuesPage.isNewIssueListed(issueName);
    }

}
