Feature: To add New Contacts from Conatacts Section

  Background: 
    Given User enter the userName and password from configuration
    Then user clicks on Login_button
    
    Scenario Outline: Adding of New Conatacts or New Users via New Contacts Sections
    Given user clicks on New Contacts
    When "<FirstName>" is entered and try Saving
    Then Pop up appaers with message "Please enter a surname"
    Then "<Mobile>" "<Email>" "<MessengerNetwork>" is to be filled and prefernces set to No
    Then user need to have birthday selecetd
    And "<LastName>" is entered and Saved

    Examples: 
      | FirstName 	| LastName | Mobile | Email        | MessengerNetwork 							 |
      | Sahadev			| During	 |0000401|any@gmail.com |          Google Talk               |
      | Karna		| Surya	 | 0003001|any@gmail.com |            IRC                        |
  		| Sindhu2  	  |HinduKush	 | 000004| any@gmail.com |           Google Talk           |
      | Arjun				|During	 |0000041|any@gmail.com 	|       Yahoo Messenger            |
      | Kalki				| Lobrock|00005301|any@gmail.com	 |      Yahoo Messenger            |
      | Bhisma			| During |0000031|any@gmail.com |       Google Talk                  |
      | Gandahari		| Lobrock|0003001|any@gmail.com |          IRC        							 |
      | PanchalNaresh| During	 |0000401|any@gmail.com |          Google Talk           |
      | Karna				| Surya	 | 0003001|any@gmail.com |            IRC        						 |
      | Kunti				| Lobrock	 | 000004| any@gmail.com |           Google Talk           |
      | Madahav			| During	 |0000041|any@gmail.com |       Yahoo Messenger            |
      | Bhima				| Lobrock	 |00005301|any@gmail.com |      Yahoo Messenger            |
      | sakuni			| During	 |0000031|any@gmail.com |       Google Talk                |
      | Marakand		| Lobrock	 |0003001|any@gmail.com |          IRC										 |
      | PanchaliNaresh			| During	 |0000401|any@gmail.com |          Google Talk     |
      | Kadambari		| Surya	 | 0003001|any@gmail.com |            IRC      						   |
      | Gatothkach				| Lobrock	 | 000004| any@gmail.com |           Google Talk     |
      | Mohan			| During	 |0000041|any@gmail.com |       Yahoo Messenger              |
      | Parshuram				| Lobrock	 |00005301|any@gmail.com |      Yahoo Messenger        |
      | Dhirtrashtra		| During	 |0000031|any@gmail.com |       Google Talk            |
      | Duryadhan		| Lobrock	 |0003001|any@gmail.com |          IRC                     |