/*
 * This is an example test project created in Eclipse to test NotePad which is a sample 
 * project located in AndroidSDK/samples/android-11/NotePad
 * 
 * 
 * You can run these test cases either on the emulator or on device. Right click
 * the test project and select Run As --> Run As Android JUnit Test
 * 
 * @author Renas Reda, renas.reda@gmail.com
 * 
 */

package com.jayway.test;

import com.example.android.notepad.NotesList;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import java.util.Random;


public class NotePadTest extends ActivityInstrumentationTestCase2<NotesList>{

	private Solo solo;

	public NotePadTest() {
		super(NotesList.class);
	}

	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}
/*Jag tänkte så här: 
 * Add, modify och delete är main flow och borde vara det som ska testas.
 * Jag brukar vilja ha testfall som man kan använda seperat men även köra de i en testsvit 
 * så jag försökte återskappa de testfall som fanns här men se till att de går att använda var för sig också
 * Jag har endast arbetat runt 40 timmar i Eclipse och liknande program så kan erkänna att det var en verklig utmaning att få allt att funka.
 * */
	public void testAddNote() throws Exception {
		boolean actual = solo.searchText("Note 1");
	
		solo.clickOnMenuItem("Add note");
		//Assert that NoteEditor activity is opened
		solo.assertCurrentActivity("Expected NoteEditor activity", "NoteEditor"); 
		//validate so that there is not a note called Note 1 already (at least I think this should not be possible?)
		if (actual == true)
			assertEquals("There is already a note called Note 1", false, true);
		//In text field 0, enter Note 1
		solo.enterText(0, "Note 1");
		solo.goBack(); 
		boolean expected = true;
		actual = solo.searchText("Note 1");
		
		assertEquals("Note 1 kunde inte hittas", expected, actual); 
		if (false == actual)
			solo.takeScreenshot();
	}
	
	public void testEditNote() throws Exception {
		// Click on the first list line
		solo.clickInList(0); 
		// Change title
		solo.clickOnMenuItem("Edit title");
	
		//In first text field (0), add test
		//here we just randomize a number that we update a note with, if I just add test it could be that there is more than one test
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(100);
		solo.enterText(0, " test" + randomInt);  
		
		solo.goBack();
		boolean expected = true;
		boolean actual = solo.waitForText("(?i).*? test" + randomInt); 
		//Assert that Note 1 test is found
		assertEquals("Note 1 test + random is not found", expected, actual); 

	}
	
	public void testRemoveNote() throws Exception {
		//copy the title to a String so that we can check that the note is deleted later
		TextView text = solo.getText(0);
		String title =  text.getText().toString();
		solo.clickInList(0);
		//Delete note on place 0 
		solo.clickOnMenuItem("Delete");
		
		boolean expected = false;   
		boolean actual = solo.searchText("(?i).*? " + title + "(?i).*?");//vet ej om det är så här man gör detta och kunde inte hitta något alternativ 
		//Assert that title is not found
		assertEquals(title +" is found", expected, actual);
	}
}
