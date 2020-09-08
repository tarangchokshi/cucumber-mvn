Feature: Test login functionality
Scenario: Check valid login functionality

Given Open URL
When user logged in using username and password
Then homepage should display
