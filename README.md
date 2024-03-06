

# WEEK 1

## Reflection 1

In adding the edit and delete features to the website, I made sure the code was easy to understand and secure. The form for editing a product looked clear with labels and input fields, though it could be even easier to use with some tweaks. Also, before deleting a product, the system double-checked the ID to avoid accidents. It could do better by giving clearer messages when something goes wrong. Adding comments and explanations would also help others better Overall, these new features improve the product system, and with a few adjustments, we can make the code even better.

## Reflection 2
The new test suite we made to check the number of items in the product list might have some issues that could mess up the code quality.

1. Maintenance Problems: The way we set up the new test suite could make it hard to keep up with changes later on. Breaking it into smaller parts and organizing them better can help avoid this issue.

2. Hard to Understand: If the names of things and what they do aren't clear, it can confuse people trying to work with the code. Making sure everything is named consistently and explained well can make it easier for everyone.

3. Incomplete Testing: Our new tests might miss out on checking some important stuff, leaving room for errors. We need to plan tests carefully and make sure we cover all the bases to be confident in our code.

By fixing these issues, we can make our new test suite cleaner and easier to work with. It'll help us catch bugs and make sure our code works as it should.

# WEEK 2

## Reflection 

1. During the exercise, I identified several code quality issues and addressed them accordingly. First, my test cases encounter difficulties running successfully. Initially, the error message suggests changing the ID, which I do, but then another error message appears, adding to the confusion. Next, I noticed that the variable and function names were not descriptive enough, so I renamed them to improve readability and maintainability. Additionally, my delete test case wasn't working correctly, so I made some changes to the delete function to make it easier to test.
   
2. Looking at my CI/CD workflows in GitHub, I believe the current implementation meets the definition of Continuous Integration and Continuous Deployment. Each time I push changes to the repository, the CI/CD pipeline automatically runs tests and builds the application. This means that code changes are quickly integrated and deployed, making the development cycle more efficient and agile.

# WEEK 3

## Reflection 

1. In my project, I've integrated several SOLID principles to keep things organized and flexible.

First off, there's the Single Responsibility Principle (SRP). It's all about each piece of code or class doing just one thing. I applied this to my models, like Car and Product, by creating a new class called Item. This Item class holds all the common attributes shared between Car and Product, keeping things tidy and focused.

Next up is the Open-Closed Principle (OCP). This one says that software should be open for extension but closed for modification. In my project, I used the ProductRepo, which extends ProductRepository. This setup allows for adding new functionalities without having to change the existing code. It keeps things adaptable without messing with what's already working.

Then there's the Liskov Substitution Principle (LSP). This principle ensures that you can swap out objects of a parent class with objects of a child class without causing any unexpected problems. It's like having interchangeable parts. In my project, swapping instances of Product and Car with those in Item doesn't mess up the code. Everything still runs smoothly.

Lastly, there's the Interface Segregation Principle (ISP). This one is about making sure that implementing classes only have the methods they need. It's like keeping things streamlined. In my project, both CarRepo and ProductRepo stick to this principle. They each have methods specific to either Cars or Products, avoiding any unnecessary clutter.

So, by following these SOLID principles, my project stays organized, flexible, and less prone to unexpected issues.

2. Using SOLID principles has lots of benefits for my project. It helps keep the code flexible and easy to change when requirements shift. For example, following the Open Closed Principle means I can add new features without breaking existing code, like in ProductRepo and CarRepo, which makes it easier to expand and maintain the project.

3. Not applying SOLID principles in the project can lead to messy and confusing code that's hard to work with. For example, if I ignore the Single Responsibility Principle and cram unrelated tasks into one class, it becomes tough to manage and prone to mistakes. Plus, if I don't follow the Interface Segregation Principle, I might end up with overly complicated interfaces that make development harder and slow down progress. So, it's important to stick to SOLID principles to keep the code clean and the project running smoothly.


# WEEK 4

## Reflection 

### 1. This TDD flow is useful enough for you or not
1. Did I understand what I was testing?
   
The tests seem to have a clear understanding of what they are testing. For example, createPayment is tested for creating a payment, updateStatus is tested for updating the status of a payment, and so on. The test methods are appropriately named to reflect the behavior they are testing.

2. Does this test help to pin down a bug?
   
Unit tests written using TDD aim to prevent bugs by ensuring that individual components behave as expected. While these tests may not directly pinpoint bugs, they help in identifying regressions and ensuring that the code behaves as intended when changes are made.

3. Is the test comprehensive enough?
   
The provided tests cover basic functionality, for example creating a payment, updating its status, finding payments by ID, and finding all payments. However, they may not cover all edge cases. So further testing might be needed to ensure comprehensive coverage.

4. Is the test maintainable?
   
The test code should be easy to understand and maintain. The tests are readable and logically structured. However, if the test code becomes overly complex, it may become hard to maintain.

### 2. F.I.R.S.T. principle

F) Fast

Sure, when I run my tests, they should finish pretty quickly. This helps me quickly figure out if my code is working properly without having to wait around too long.

I) Isolated/Independent

Sure, each test I've written doesn't rely on the results of other tests. So no matter what order I run them in, each test stands on its own, checking a specific part of my code without interference.

R) Repeatable

Sure, my tests are consistent. Whenever I run them, I get the same results every time. 

S) Self-Validating

Sure, my tests double-check their own work. They compare the expected outcome with the actual outcome to make sure everything is as it should be. If something goes wrong, the test will let me know.

T) Thorough

For sure, I've covered all the important stuff with my tests.


