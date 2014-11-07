# README #

Repository contains sample project to show how simple WebDriver test can be executed at Bamboo. 
It was created as response to question [https://answers.atlassian.com/questions/10397000/answers/10398792](https://answers.atlassian.com/questions/10397000/answers/10398792)

##Bamboo configuration##
1. Add new Repository
1. Add [Maven capability](https://confluence.atlassian.com/display/BAMBOO/Defining+a+new+executable+capability)
1. Add new Plan with 1 stage
1. Add Job
     1. Add source code checkout task
     1. Add Maven 3 task