

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
