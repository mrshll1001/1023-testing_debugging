# Blackbox Testing

[<- Back home](index)

This exercise is designed to get you familiar with Blackbox Testing. Through doing this you'll also be using JUnit and probably inside of Eclipse. If you don't use Eclipse and use another IDE, ask a demonstrator. They probably have a favourite IDE anyway and will be happy to help you get set up.

As you should know from the lecture you definitely attended, Blackbox Testing is a form of Testing wherein you don't know anything about the structure of the code being Tested and thus cannot make changes. In Industry environments there'll likely be an automatic warning system when a test fails, and that code will be sent back to the development stage to fix. This exercise will try its best to give the feel of a Testing process in industry and research, but if you have any questions about why things are being done in a particular way, let us know; we like to be kept on our toes! It will also require you to pretend you cannot see some of the code for a bit.

**Warning: The last part of the practical requires you to work in pairs. If you feel you can't do this (or the rest of your group haven't shown up…) then please let a demonstrator know**

## Step 1: Setting up the Blackbox
We're going to get set-up first. You should be intimately familiar with creating Java projects by now, so create a new one in Eclipse or your IDE of choice. Name the project something reasonably sensible. You don't need a Main class yet, but you should create a Package. In Java, a Package is just a folder to help group code but it's used to organise imports too. Name your package `main`.

!["New -> Package"](/img/package.png "New Package")

When you're done that, download [this file](Dog.java) (`Dog.java`). It's a piece of source code that will be acting as your "Blackbox". For this bit, you'll need to pretend that you can't actually see the source code. In Industry you likely wouldn't be able to see it in your Testing environment.

After downloading this, add it to your project via any means you want. Usually when just adding Java file it's alright to drag and drop the file into the package you created before. This will add the code to the project. Now that our Blackbox is set up, we can get on with the testing portion.

## Step 2: Setting up the Test Class
Since we're being nice we've prepared for you a [Test Class](DogTest.java) to also drop into your project. Don't worry, it's not finished yet so there's still plenty for you to do ;-). First, it's a good idea to have test code in another package. Create another package under your project called `test` and drop the file you just downloaded (`DogTest.java`) into it.

## Step 3: Running through some Tests
If you open the `DogTest.java` file you'll see something very much like this:

```java
package test;

import main.Dog;
import junit.framework.TestCase;

public class DogTest extends TestCase
{

	public void testDog()
  {
		/* We want to check that our objects are being created properly */

		Dog dog = new Dog(2, "Sid", 0.5, 10); // Create the dog variable to test.

		assertEquals(Dog.class, dog.getClass()); // We want the variable class to equal the class we created

	}

  public void testGetAge()
  {
		fail("Not yet implemented");
	}
}
```

This is the JUnit test code that we talked about earlier, but this time there's a whole class of it. Just for laughs, hit the "Play" button in Eclipse whilst in the `DogTest` file. You should see something like this come up:

**IMG of Eclipse**



You'll notice that the `testDog` method passes (little green tick) and the rest of the methods fail. This is because most of the methods contain a `fail("Not yet implemented")` line. Our task here is to complete the testing. We'll walk through one together.

Here we'll be testing the `getAge` method to ensure that it returns the appropriate age. In Testing terms, that means *we want the result of this method to be equal to the value we give it originally*. We can tell from the Dog constructor that it takes an age…

**img of eclipse**

… so we can be pretty certain that if we create a Dog with the age of `5` in the constructor that it should contain the value we need. LEt's use Sid again

```java
public void testGetAge() {
  Dog dog = new Dog(5, "Sid", 0.5, 10); // Create the dog variable to test.

  fail("Not yet implemented");
}
```

Now that we have our object set up to test, we need to actually test the method. We want to make sure that `dog.getAge()` returns the correct value, which is equal to 5…

```java
public void testGetAge() {
  int age = 5
  Dog dog = new Dog(age, "Sid", 0.5, 10); // Create the dog variable to test.

  assertEquals(age, dog.getAge()); // Assert that the condition is true
}
```

That's all there is to it! Remember that the `assert` methods let you describe the *pass condition*. If it isn't equal, the test fails. If you hit play again, JUnit and Eclipse should inform you that this test has passed now. Buuuut the rest of them won't have. You can see where this is going.

## Task: Write the rest of the test cases out.
Now it's your turn. Write out the rest of the test cases so that each method inside of `DogTest` has an assert statement and no `fail("Not yet implemented")`. You can remove the `fail` methods, these are there to stop you forgetting to write the test in the future.

- Remember to think about the pass conditions. That is what you'll put into the `assert` method.
- There's more to `assert` than `assertEquals`. Type `assert` into Eclipse then hit Ctrl + Space. Look at all the different assert methods. Some are quite handy.
- I've deliberately introduced an error into one of the methods, so at the end of the task you will still fail the tests. We'll fix this bug later on.

> Remember these are pretty easy examples, using Getters and Setters. This is just to get the process across. In reality, Testing is needed for more complicated code and methods that require some more computation; meaning errors are more likely.

## Task: Creating a Test Class from Scratch (kinda)
You're familiar now with writing out the content of the test methods but you haven't yet begun creating your own Test classes. Download [this Java file](HeapSort.java) and stick it in your project. Remember it's Blackbox testing so no peeking at it.

The file is the implementation of Heap Sort that I ripped off of Github and modified to not need Scanners. You're going to create a test class for it, and test a single public method. Since Eclipse has JUnit built in, it can do some heavy lifting for you here. Right click on your `test` package and select *New -> JUnit Test Case*. In the next screen, you can name your Test Class whatever you want (usually related to the class under testing, with the word "Test" after it e.g. `DogTest`).

**The Important bit here is that you select *Class Under Test* at the bottom and select Heap Sort**. This will let you auto-generate some method stubs for testing. In the real world you'd want to test every method, but here we only care about the `sort()` method. Click Finish when you're done.

You'll see your auto-generated test class open up. It's up to you now to fill in the Test method to test the `sort()` method.

Tips:
- The HeapSort class takes an array of integers in its constructor to sort.
- The `sort()` method also returns a new array of (supposedly) sorted integers.

## Task: Peer learning!
For this task you're going to test each other's code. You can either: Pair up and work in a pair; work in groups and divide the group in two. Either works. Then do the following:

1. Each half (of the pair or group) writes a **simple** class in Java that does a thing. It can be anything as long as the following conditions are met:
  - It has a constructor which takes some variables.
  - It has 3 class variables and getters / setters for them
  - It has 4 other public methods that require testing which are not getters or setters. Try to make them do some calculations or something interesting.
  - One of these methods has an error in it.
  - You should also write a very brief documentation file in Office explaining the class. Give (brief) details on the variables, the method names, the method parameters and the *expected result* of the methods.
2. When done, swap your class and documentation with the other person / half of the group. Don't send over the whole project, just the `.java` file (in the *src* folder inside the Eclipse Workspace)
3. Now you have the other class file, create a test class with appropriate tests for it using the documentation provided by the other half.
4. Speak with the other person (or people) about where you think the error was. Was there more than one error? Was the error caused by the class being tested, or was there an error in testing?
