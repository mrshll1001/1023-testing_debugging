# Whitebox Testing and Debugging

[<- Back home](index)

This exercise is designed to make you more familiar with Whitebox Testing, as well as with Debugging. These two go together quite nicely, as they both mean that you have access to the source code. The practical sheet will continue to use Eclipse as an example, but if you're in another IDE you can search for how to do things where menus are different, etc.

Whitebox Testing differs from Blackbox Testing in that you now have access to the source code of the software you're testing. This changes the purpose and way you approach your tests in some subtle-but-important ways.

- In Blackbox Testing, you care about the results of methods -> In Whitebox Testing you also care about the *internal structures* of the code.
- In Blackbox Testing, you generally test as many values as you can -> In Whitebox Testing you engineer your tests to deliberately trigger certain conditions in the code.

If we take the example code below:

```java
public int weirdMethod(int input)
{
  if(input % 2 == 0)
  {
    return input / 2;
  } else
  {
    return input % 2;
  }
}
```
With this function (which is admittedly weird, but bear with us); Blackbox testing wouldn't really work. The method signature does not indicate that the behaviour of the method inside of it. A good programmer would have provided documentation around this to explain it, but for the purposes of Whitebox Testing, let's say that they don't. The Whitebox Testing approach can be boiled down to two stages:

1. Understand the Source Code. Usually things to look out for are the interesting things like conditions, loops, case statements, etc.
2. Create the Test Class around the condition you want to trigger. Unlike Blackbox Testing where you had one test method per method-to-test, in Whitebox testing you'll have multiple: one for each condition. As you can imagine, this can get rather thorough when code gets more complicated and you need to test multiple conditions.

Let's whip up a test class to test our weird method. We know from looking at the code that there exists a condition which checks if a number is odd or even, so we want to write some Whitebox Tests to cover both of those:

```java
public void testWeirdMethodOdd()
{
  int x = 7;

  fail("Not yet implemented!");
}

public void testWeirdMethodEven()
{
  int x = 6;

  fail("Not yet implemented!");
}
```

Cracking. Now we can see that the code is supposed to return half of input when the input is even, or the remainder of the input divided by 2 if it's odd. We should check those conditions in our Test Class.


```java
public void testWeirdMethodOdd()
{
  int x = 7;

  assertEquals(1, SomeClass.weirdMethod(x));
}

public void testWeirdMethodEven()
{
  int x = 6;

  assertEquals(3, SomeClass.weirdMethod(x));

}
```

Good stuff. Our weird method has been thoroughly tested with Whitebox Testing and we can pat ourselves on the back.

## Task: Write a (basic) Whitebox Test Class
I've written another Class that requires testing, which you can download [here](Collatz.java). This is a whitebox, so feel free to peek at it. This is a very basic implemtation of the Collatz Conjecture. [Here's a video explaining it](https://www.youtube.com/watch?v=5mFpVDpKX70). It's pretty basic to code, but kinda fun in a nerdy way.

Because we're doing Whitebox testing, we can peek at the code. Take a look at the Collatz class. Read it through line by line. Now, make a Test Class for the Collatz class. Remember that in Whitebox testing you know the code, so you want to be deliberately firing off different conditions.

Tips:
- The Collatz class is built around two central control structures (a loop and a condition) - what are different inputs you can give to affect these differently?
- How will you check the results? Remember you're returned a List of 'states' (ie every number in the sequence in order) which means you have access to the List methods.
- You might want to calculate things manually (either in the test method or literally manually) to check results against.
- I'm not expecting any tests to fail but you never know.

## Task: Write a Whitebox Test Class for your own code
Do you remember the `MarkCalculator` class that you wrote for the first CSC1021 coursework? Remember that feeling when you'd finally finished it and never had to look at it again? Lol.

The reason that we're bringing that back up is because, as you might have noticed, producing some code to do Whitebox Testing on can seem a bit forced. Luckily, your previous coursework is already perfect for Whitebox testing because you have a knowledge of the code itself, and it contains lots of conditional structures that only execute sometimes. So for this task, complete the following:

1. Take the `MarkCalculator` class from your first CSC1021 Java coursework and dump it into your `main` package. If you followed the original specification properly, you shouldn't need to change the class at all to use it elsewhere.
  - If for some reason you feel you can't use the MarkCalculator that you wrote feel free to use [this one](MarkCalculator.java) kindly provided by *Student 8* who produced it two years ago.
2. Write a test class for it utilising Whitebox style. Remember the point is to write a series of tests that *ensure all code is executed*. This means examining loops and conditions and trying to write test cases that explicitly trigger each different case. Chances are you did something similar when writing this code originally; except now you know how to do it properly in a shiny new Test Class :-)
  - If you're using Student 8's MarkCalculator, it will not contain logic for the core module, as this wasn't part of the specification back then. This means you won't need to test that.

## Quick Breather: Debugging
> Pro tip: You know when you know there's a bug and you sit staring at your code to find it? The fancy term for that is *Code Inspection* and those words sound much more professional in a report than "I sat and stared at the code for a while".

By now we've done a lot of Testing but not a lot of Debugging. As you know from lectures, Debugging is the process of actually going and locating the faults that you found during Testing, and then fixing them. Pretty simple. Your lecture will have covered some of the basic approaches such as Brute Force and Cause Elimination. This part of the practical is going to focus on introducing you to a few common tools in order to help you pragmatically debug things on-the-ground. These tools are useful when used by themselves, but are most effective when incorporated into a larger debugging process:


- **Breakpoints** are places where you get your IDE (e.g. Eclipse, NetBeans) to 'pause' and show you the state of the program. This can be useful to inspect the value of variables. It's useful because your other option is to write a lot of print statements everywhere which takes a lot of time.
- **Pair Debugging** is when you sit down and walk someone through the logic of your code, line by line. You might have seen a demonstrator do this before (usually it means we don't know what the problem is either yet). Merely the act of talking through the logic of your code out loud, in a language others are meant to understand, can help you find the bug. Most of the time the programmer doing the talking will suddenly stop and get embarrassed as they realise what the error was. Most little problems and logical whoopsies can be found using a combination of this with some Breakpoints. If you don't have a friend, then this technique can be performed solo with otherwise inanimate objects on your desk, and is called things such as "Cardboard Programmer" or (more famously) [Rubber Duck Debugging](https://rubberduckdebugging.com/).

Right now we're going to focus on using Breakpoints in Eclipse, although most IDEs will use the same methods to add them. To create a Breakpoint in the code, you should first find a line you want to pause at. It could be in the middle of a method, or at an if statement. In the IDE, there's a margin to the left of the code that you can Double-Click or Right Click and select *Toggle Breakpoint*

!["New Breakpoint"](/img/new_breakpoint.png)

Now that we have breakpoint, we can use it. To debug some code, you need to run it so you need to debug a class which has a `main` method in Java. You can do this by right-clicking it in the package browser in Eclipse and selecting *Debug as -> Java Application*

!["Debug As"](/img/debug_as.png)

Eclipse will then ask you to change perspective. Don't worry, it's not asking you to take a long deep look at yourself; it just wants to move some tabs around to make debugging a bit easier on you. Accept and your screen will shift to look like this:

!["Debug perspective"](/img/debug_perspective.png)

The most important things to consider are: the *Variables* tab, which shows you the current state of the system including values of variables (you can actually force-change them as well if you want)…


!["Variables"](/img/debug_variables.png)

and the commands *Step Into* and *Step Over*.

!["Step Commands"](/img/debug_steppers.png)

**Step Into** will execute the next line of code, and if this contains a method call, will enter the method. This allows you to dissect how the values are passed into and out of methods. **Step Over** will execute the code but show you the level deeper. If you step over a method call, the method is executed but the debugger will move to the next line. Consider the following code:

```java

public static void main(String[] args)
{
  int x = 13;
  int y = 14;

  foo(x);
  foo(y);
}

public static void foo(int input)
{
  input = input * 100;
}
```

If we want to debug the main method, we run the debugger and put a break point in it somewhere. Let's say we put it at the line `foo(x)`. When the code executes and hits the break point it pauses and shows you the line in the debugger.

 - If we select *Step Into* the debugger will take us execute `foo(x)` and take us step-by-step through the `foo` method as it does so.
 - Else, if we select *Step Over* the debugger will execute `foo(x)` in the background as "normal" and move to the line `foo(y)`.

Neat!

## Task: Debug and fix some code
This final task will see you utilising Debugging and Whitebox Testing in order to fix a few errors. The details are as follows:

1. Revisit `DogTest.java`. Remember how there was (at least) one error left over after testing? You can now open `Dog.java` and play with it. The error should be fixable using Code Inspection, but you still need the practice with Breakpoints here. Which method failed? Place a breakpoint there, and inspect the value of variables. Modify the class, make a comment next to the modification in the code, and retest it.
2. You should also have errors present in the code you received from the peer learning exercise last practical. Study the code you were given and create a Whitebox Test Class that tries to execute all portions of the code. When you encounter an error in the testing (again there should be at least one) utilise the Eclipse debugger to inspect every method.
