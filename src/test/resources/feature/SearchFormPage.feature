Feature: To check the Accounts Pages Users and selecting them

  Background: 
    Given User enter the userName and password from configuration
    Then user clicks on Login_button
    
  Scenario: To search a contacts in Full Search Form
    Given user clicks on Full Search Form in Contacts
    Then user enter the "Eder" and "Militao" to search
    And user checks the checkbox and capture the mobileNumber"9986"

  Scenario: To seacrh for user in Contacts tabe and check if they are seleceted
    Given user clicks in Contacts
    Then user search for "Lagrtha Lothbrock" in the table and checks the checkBox
    And confirm that Company is "Vikings" and "Lagrtha Lothbrock" is checked
   
  
  Scenario Outline: To Delete the specfic user Added
    When Search for "<FirstName>" "<LastName>" in the table and checks the checkBox
    Then Deleting pop up appears with message "Are you sure you want to delete this Contact: "

    Examples: 
      | FirstName | LastName |
      | XXX 			| ZZZ	 		 |
      
 
