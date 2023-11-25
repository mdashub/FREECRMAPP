Feature: To add New Contacts from Conatacts Section

  Background: 
    Given User enter the userName and password from configuration
    Then user clicks on Login_button
    
    Scenario Outline: Adding of New Conatacts or New Users via New Contacts Sections
    Given user clicks on New Contacts
    When "<FirstName>" is entered and try Saving
    Then Pop up appaers with message "Please enter a surname"
    Then "<Mobile>" "<Email>" "<MessengerNetwork>" is to be filled and prefernces set to No
    Then user tries to select birthday "<date>" "<month>" "<year>" is to be filled
    And "<LastName>" is entered and Saved

    Examples: 
      | FirstName 	| LastName | Mobile | Email        |      MessengerNetwork 			 |date  |month|year |
			| KarnSamraj  | During	 |0000401|any@gmail.com  |          Google Talk        | 24	  | Oct |2010 |	
			| PanduSamraj | During	 |0000401|any@gmail.com  |          Google Talk        | 6	  | Feb |1999 |	
			| KandharSam  | During	 |0000401|any@gmail.com  |          Google Talk        | 1	  | Jan |1980 |	
			| Alkananda   | During	 |0000401|any@gmail.com  |          Google Talk        | 17	  | Aug |1987 |	
				 
        
      
    
   
