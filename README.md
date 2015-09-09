# deck-cards-lib
---------------------

This package provide a library to deal with French deck of cards which the Casino usually use. So it use 52 cards (13 per suit, Club, Spade, Hearts) plus 2 jokers.
Each of the deck user operation are placed at the DeckCardsInterface.  



* How to use it

This lib can be included as a project library. The generated jar package in in the root of the project


































Assumptions
-----------
- Deck has 52 elements (4 suits and 13 cards of each)
- Each time a card is obtained (any get operation is removed from the deck)
- For these implementation french deck is used.


Libraries used
--------------
- See pom.xml file, is just a simple maven java project with junit (used maven for convinience and simplicity)

Usage
-----
- for reviewing the project you can clone it from github and import it in eclipse as maven project.
- there is a test called DeckTest that allows testing all the operations.
- For convenience there is also a Main class that allows testing the operations from console (menu options)

There is also a jar included in the repository, so it can be tested from the command line using the following command.
Copy the jar file to a directory, and then from that directory type:

C:\CustomInk\deckLibrary\target>java -cp deckLibrary-0.0.1-SNAPSHOT.jar com.test.vp.main.Main

It will appear the menu and select appropiate options.