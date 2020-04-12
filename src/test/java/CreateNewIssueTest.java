import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreateNewIssueTest {

    // to assure that each test uses unique issue name
    private final String issueName = "SampleSummary"+System.currentTimeMillis();

    LoginPage loginPage = new LoginPage();
    MyDashboardPage myDashboardPage = new MyDashboardPage();
    NewIssuePage newIssuePage = new NewIssuePage();
    IssuesPage issuesPage = new IssuesPage();

    @Test
    public void loginAndReportIssue() {
        open("https://qa-test-fad-1.myjetbrains.com/youtrack");
        loginPage.loginCorrect();
        myDashboardPage.createNewIssue();
        newIssuePage.insertSummary(issueName);
        newIssuePage.createIssue();
        newIssuePage.goToIssues();
        issuesPage.isNewIssueListed(issueName);
    }

}
