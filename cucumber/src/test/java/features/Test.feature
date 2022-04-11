Feature: feature to print 300 characters



Scenario: check whether 300 charaters is printed successfully or not
Given user is on GitHub home page
When user is search REACT in search bar
Then click on advanced search
Then change some options in advanced search
Then click on mvoloskv
And print first 300 characters from readme