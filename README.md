Project Name: Quickflip

Team Name: Quickflip

Team Members: Cody Schoenick

Welcome to Quickflip! 
Quickflip is an intuitive, user-friendly flashcard app that allows users to create or load their own flashcards, practice their flashcards, and take a multiple choice test based on their flashcards.

To get started, you can create your own flashcards by clicking the "New Flashcards" button. From there, enter your terms and definitions into the respective text fields. After each term (including your last term), you should click the "Next Term" button in order to ensure your flashcards are saved. From here, you will be prompted to save your flashcards, if you choose to save your flashcards, they will be saved in a .txt file where you may choose the destinition and name of the file to be saved. After saving your flashcards, you can either practice learning the terms/definitions by clicking the "Flashcards" button or take a multiple choice test by clicking "Test."

	* Note: in order to be tested on your flashcards, you must have at least 4 terms and 4 definitions.
	

To load your own flashcards, your file must be a .txt file structured like the following: 
	
	Term 1
	Definition 1
	Term 2
	Definition 2
	Term 3
	Definition 3
	Etc...

At anypoint during the program, you can return to the starting page by clicking the Quickflip logo at the top of the page.


To run the program using the jar file, enter the following command in your terminal:
	
	java --enable-preview --module-path (path to JavaFX library) --add-modules javafx.controls,javafx.graphics,javafx.fxml -jar Quickflip.jar

