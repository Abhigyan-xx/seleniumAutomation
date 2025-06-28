Feature: GST Report PDF Search

  As an Admin user,
  I want to authenticate into the CorpVue Admin Panel,
  So that I can retrieve and view all GST report PDFs associated with a specific OMS user,
  using the PAN-based search functionality.

  Scenario Outline: Login and verify GST report for all the user
    Given I open the CorpVue Admin Panel in a browser
    And I log in using valid admin credentials "<userName>" and "<passWord>"
    When I navigate to the "Report History" tab
    Then I should see the list of all GST reports generated for all users
#    Then I click on the search box
#    Then I enter the pan number to search the history report
#    Then I click on the search Icon to search the pan

    Examples:
      | userName                          | passWord     |
      | abhigyan.shukla@finconic.com     | delhi@12345  |
