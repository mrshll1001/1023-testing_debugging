package test;

import main.Dog;
import junit.framework.TestCase;

public class DogTest extends TestCase {

	public void testDog() {
		/* We want to check that our objects are being created properly */
		
		Dog dog = new Dog(2, "Sid", 0.5, 10); // Create the dog variable to test.
		
		assertEquals(Dog.class, dog.getClass()); // We want the dog's class to equal the class we created

		//		assertTrue(dog instanceof Dog.class) This is also a way to do the same thing
		
	}

	public void testGetAge() {
		fail("Not yet implemented");
	}

	public void testSetAge() {
		fail("Not yet implemented");
	}

	public void testGetName() {
		fail("Not yet implemented");
	}

	public void testSetName() {
		fail("Not yet implemented");
	}

	public void testGetBreed() {
		fail("Not yet implemented");
	}

	public void testSetBreed() {
		fail("Not yet implemented");
	}

	public void testGetHeight() {
		fail("Not yet implemented");
	}

	public void testSetHeight() {
		fail("Not yet implemented");
	}

	public void testGetWeight() {
		fail("Not yet implemented");
	}

	public void testSetWeight() {
		fail("Not yet implemented");
	}

	public void testIsHasBone() {
		fail("Not yet implemented");
	}

	public void testSetHasBone() {
		fail("Not yet implemented");
	}

	public void testIsTailWagging() {
		/* There is no setTailWagging method. Dogs only wag tails when they have bones. Obviously. */
		fail("Not yet implemented");
	}

	public void testGetDogYears() {
		/* 1 Dog year is said to be 7 Human years */
		fail("Not yet implemented");
	}

	public void testSpeak() {
		/* Dogs should say "WOOF WOOF" when asked to speak */
		
		fail("Not yet implemented");
	}

}
