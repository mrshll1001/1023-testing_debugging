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
