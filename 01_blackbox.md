# Blackbox Testing

[<- Back home](index)

This exercise is designed to get you familiar with Blackbox Testing. Through doing this you'll also be using JUnit and probably inside of Eclipse. If you don't use Eclipse and use another IDE, ask a demonstrator. They probably have a favourite IDE anyway and will be happy to help you get set up.

As you should know from the lecture you definitely attended, Blackbox Testing is a form of Testing wherein you don't know anything about the structure of the code being Tested and thus cannot make changes. In Industry environments there'll likely be an automatic warning system when a test fails, and that code will be sent back to the development stage to fix. This exercise will try its best to give the feel of a Testing process in industry and research, but if you have any questions about why things are being done in a particular way, let us know; we like to be kept on our toes! It will also require you to pretend you cannot see some of the code for a bit.

**Warning: The last part of the practical requires you to work in pairs. If you feel you can't do this (or the rest of your group haven't shown up…) then please let a demonstrator know**

## Step 1: Setting up the Blackbox
We're going to get set-up first. You should be intimately familiar with creating Java projects by now, so create a new one in Eclipse or your IDE of choice. Name the project something reasonably sensible. You don't need a Main class yet, but you should create a Package. In Java, a Package is just a folder to help group code but it's used to organise imports too. Name your package something boring like `main`.

**IMG OF ECLIPSE**

When you're done that, download [this file](#) (`Dog.java`). It's a piece of source code that will be acting as your "Blackbox". For this bit, you'll need to pretend that you can't actually see the source code. In Industry you likely wouldn't be able to see it in your Testing environment.

After downloading this, add it to your project via any means you want. Usually when just adding Java file it's alright to drag and drop the file into the package you created before. This will add the code to the project. Now that our Blackbox is set up, we can get on with the testing portion.

## Step 2: Setting up the Test Class
Since we're being nice we've prepared for you a [Test Class](#) to also drop into your project. Don't worry, it's not finished yet so there's still plenty for you to do ;-). First, it's a good idea to have test code in another package. Create another package under your project called `test` and drop the file you just downloaded (`DogTest.java`) into it.

## Step 3: Running through some Tests
If you open the `DogTest.java` file you'll see something very much like this:

```java
package test;

import main.Dog;
import junit.framework.TestCase;

public class DogTest extends TestCase {

	public void testDog() {
		/* We want to check that our objects are being created properly */

		Dog dog = new Dog(2, "Sid", 0.5, 10); // Create the dog variable to test.

		assertEquals(Dog.class, dog.getClass()); // We want the dog's class to equal the class we created

	}

  public void testGetAge() {
		fail("Not yet implemented");
	}
```
This is 
