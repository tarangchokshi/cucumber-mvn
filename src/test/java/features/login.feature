Feature: Test login functionality
@multiple
Scenario Outline: Check valid login functionality

Given Open URL
When user logged in using username as "<username>" and password as "<password>"
Then homepage should display

Examples:
|username|password|
|admin|admin123	|
