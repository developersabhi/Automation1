@GetID_AddWebSite

  Feature: GetID --> Add new WebSite
    Here will test the Add new WebSite on the provider Functionality.
    For this we will login with provider credentials and will test the different scenarios including behaviour and functional test of the WebSite List.
    For Testing we will use the test data.

    @WebSiteList_Add
    Scenario:Scenario_1: Add Website and verify the added website.
      Given User log in to provider URL and is already present at the website list page.
      Then click on the  "Noti Cancel" button.
      Then click on the  "Add Website" button.
      Then user enter the data "Game" for "Website Name" field.
      Then user enter the data "102.120.52.25" for "IP" field.
      Then user enter the data "https://GameRunner.com" for "URL" field.
      Then user enter the data "Edu master" for "Client name" field.
      Then user enter the data "https://tp.yesno.in/get-id/approve-reject" for "Approve/Reject Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/approve-reject" for "Withdraw Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/user-balance" for "Balance Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/agent-login" for "Agent Login Hook URL" field.
      Then user enter the data "https://tp.yesno.in/get-id/agent-login" for "Manually Transaction Hook URL" field.
      Then user enter the data "https://tp.yesno42.in/get-id/agent-login" for "User Registraction Hook URL" field.
      Then user enter the data "https://tp.yesno2475.in/get-id/user-bet-status" for "User Bet Status Hook URL" field.
      Then user enter the data "slug" for "Login Slug" field.
      Then user enter the data "db" for "Database Name" field.
      Then click on the  "SECRET KEY" button.
      Then click on the  "Submit" button.
      Then user enter the data on the Search.
      Then User Verify the Add Website on list
      And User will logout.
#      And User Close the Browser;

    @WebsiteList_Edit
    Scenario:Scenario_2: Edit website and verify the edited website.
      Given User log in to provider URL and is already present at the website list page.
      Then click on the  "Noti Cancel" button.
      Then enter the data value for search.
      Then User click on the "Action" button.
      Then User click on the "Edit" button.
      Then user enter the data "Game" for "Website Name" field.
      Then user enter the data "102.120.52.25" for "IP" field.
      Then user enter the data "https://GameRunner.com" for "URL" field.
      Then user enter the data "Edu master" for "Client name" field.
      Then user enter the data "https://tp.yesno.in/get-id/approve-reject" for "Approve/Reject Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/approve-reject" for "Withdraw Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/user-balance" for "Balance Hook URL" field.
      Then user enter the data "https://tp.yesno2.in/get-id/agent-login" for "Agent Login Hook URL" field.
      Then user enter the data "https://tp.yesno.in/get-id/agent-login" for "Manually Transaction Hook URL" field.
      Then user enter the data "https://tp.yesno42.in/get-id/agent-login" for "User Registraction Hook URL" field.
      Then user enter the data "https://tp.yesno2475.in/get-id/user-bet-status" for "User Bet Status Hook URL" field.
      Then user enter the data "slug" for "Login Slug" field.
      Then user enter the data "db" for "Database Name" field.
      Then click on the  "SECRET KEY" button.
      Then click on the  "Submit" button.
      Then user enter the data on the Search.
      Then User Verify the Edited Website on list.
      And User will logout.
      And User Close the Browser;