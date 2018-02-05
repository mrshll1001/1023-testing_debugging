---
layout: default
title: CSC1023 Testing & Debugging
---

# CSC1023 Testing & Debugging
These are are CSC1023 Practical worksheets around Testing and Debugging. These practicals **are not assessed** but Testing and Debugging are becoming increasingly valuable skills in Software Engineering. Testing and Debugging can be a [dedicated job](https://www.cwjobs.co.uk/jobs/software-testing) in its own right, and large suites of complex tools can make the process seem abstract. In actuality, however, you've probably been doing informal Testing and Debugging work throughout Semester 1 already (or at least we hope so). These exercises are designed to show you how to pragmatically engage Testing and Debugging to not only develop your skills here, but to make your overall workflow easier when it comes to the rest of your programming life.


## How Testing is performed on-the-ground (generally)
> In Stage 2 you will be introduced more thoroughly to the Testing Process and different Testing philosophies. Here, we're going to focus on *how you can begin testing code more formally* to improve its quality and your overall skills. The aim is to avoid some of the more common pitfalls that occur when people are introduced to Testing for the first time; terms like **Test Class** and **jUnit assert** can often throw you off by not explaining what these things actually are, where they come from, and what your role is in using them the way that you do.

Generally speaking, Testing is any process that involved formally checking that a piece of code behaves the way that you expect it to. You've probably written something along these lines in your coursework before:

```java
// This is a test, take this out later
if(importantVariable == false)
{
  System.out.println("UH OH THERE'S A PROBLEM")
}
```

Technically, speaking what you've done is a basic form of Testing. You've checked some of the code's logic, and alerted yourself if there's an issue so you can go and fix it. You've predicted what the variable should be (`true`, in this case) and alerted yourself when it's not (via a println here). This works fine when writing incredibly small chunks of code, but there can be problems when Testing code is mixed up with your code's proper logic:

- You might forget to take the Test code out
- It makes your logic hard to follow
- You cannot port the Tests to other code that you use elsewhere
- If you need to check something complex, you need to figure out where in the code to write that `if` statement
- Large or even small teams will not be checking your code, and only care that it performs the action or returns the value they're expecting.

For these reasons (and a whole lot more), we generally separate out the Testing code into their own spaces. Usually in an Object-Oriented language such as Java this will be in its own Class; hence the term `Test Class`. A generic Test Class may look like this:

```java
package com.mrshll.awesome_project.testing; // Test code can live in its own package to stay separate
import awesome_project.ClassThatNeedsTesting; // Remember to import the classes / code / etc that you need to test

public class ProjectTester
{
  public void runTest()
  {
    ClassThatNeedsTesting thingToTest = new ClassThatNeedsTesting(); // Create objects and things like you would normally in production code

    if(thingToTest.importantVariable == false) // Do your test logic.
    {
      System.out.println("UH OH THERE'S A PROBLEM")
    }
  }
}
```

That's all great so far, right? Yep, but we can take it a step further. Usually, other programmers have done a lot of the work of writing good Test Classes for us, and provide us with Testing Libraries to help us write good Tests.

> Remember, a library is just code that other people have written and that we can download and use. An example from your coursework would be the Scanner class from Java -- you didn't do the work of writing the code behind Scanner, but you can import and use the Scanner class to achieve your goal. The same is true of Testing libraries.

The most popular testing library for Java is called **JUnit**. It's actually so popular that a lot of IDEs such as Eclipse integrate it into their own code. JUnit (and other testing libraries!) provide you with classes and methods that you can use to make your own Test Classes a lot more efficient, a lot simpler to write, and a lot easier to understand in plain english. Let's rewrite our Test Class from before in JUnit, with this in mind.

```java
package com.mrshll.awesome_project.testing; // Test code can live in its own package to stay separate
import awesome_project.ClassThatNeedsTesting; // Remember to import the classes / code / etc that you need to test

import static org.junit.Assert.*; // JUnit is a code library, so bits of it are imported here just like a Scanner etc.
import org.junit.Test;

// Our class name should be descriptive of what's being tested. Do not name your test code like this :-P
public class SpecialTest
{

	@Test // This is a prefix which JUnit uses to communicate with Java that this is a special test function and to treat it differently when run.
	public void test()
  {
    ClassThatNeedsTesting thingToTest = new ClassThatNeedsTesting(); // Same as before, just create the thing that needs testing

    assertTrue(thingToTest.importantVariable); // Instead of writing the if statement ourselves, we use JUnit's functions that it gives us, that handle the logic for us

	}

}

```

There might be some things there that you haven't seen before such as `@Test`. Don't worry about these. These are the library communicating with Java and Eclipse regarding how to treat the code. The important part here is that we've managed to collapse our `if` statement into a simple function call. This might sound like nothing, but it makes life easy in complicated tests. In addition to that, the `assert` functions provide special behaviour that inform you properly when tests fail, why they failed, and what the values were when they did fail. When you think about it, the term "assert" really just describes what we were doing before. We knew ourselves that our variable needed to be `true`, so we asserted that it was and gave a warning that when it didn't. A lot of testing is about asserting various conditions are true.

### tl;dr Important bits
This has been a brief overview of how programmers go about Testing things, and why they use specific tools to do so; which can seem like scary terms when not explained in context. Here's a summary of the important bits of this:

1. Testing is just code that checks other code is behaving properly.
2. To check it's behaving properly all we need to do is:
  - Understand what our actual desired result is.
  - Check that this is what is happening when our code is used
  - Inform ourselves when it's not, so we can fix it.
2. This can get visually quite messy, so we separate out "Test code" from production code to keep it clean, and let us re-use the Test code in other projects sometimes.
3. When separated like this, the Test Code can become something called a `Test Class` which has functions in it that test various pieces of our other code.
  - A `Test Class` is just a fancy term for a class *you write yourself* to test other code.
4. Test code can be quite intense, so there exists libraries written by other programmers (like *JUnit*) to help us write our tests by providing methods and classes to make our lives easier.
5. Using these libraries, we can assemble our own tests by *filling in the logic* of what we want to be the case and asserting it.
