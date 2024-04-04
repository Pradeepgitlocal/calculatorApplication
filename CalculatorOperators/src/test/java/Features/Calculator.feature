

Feature: calculator application

Background: Below are the common steps for every scenario
  Given User Launch Chrome Browser
  When User opens calculator application URL 
	
  Scenario: Successful Addition with Valid Numbers
  And User click on first button and getValue
  And User Click on Add button 
  And User click on second button and getValue
  And User click on Equal button
  And User compare results for Add
  Then Results will be Displayed
  Then Close the Browser

  Scenario: Successful Subtraction with Valid Numbers
  And User click on first button and getValue
  And User Click on Sub button 
  And User click on second button and getValue
  And User click on Equal button
  And User compare results for Sub
  Then Results will be Displayed
  Then Close the Browser
	
  Scenario: Successful Multiplication with Valid Numbers
  And User click on first button and getValue
  And User Click on Multiply button 
  And User click on second button and getValue
  And User click on Equal button
  And User compare results for Multiply
  Then Results will be Displayed
  Then Close the Browser
	
  Scenario: Successful Division with Valid Numbers
  And User click on first button and getValue
  And User Click on Divide button 
  And User click on second button and getValue
  And User click on Equal button
  And User compare results for Divide
  Then Results will be Displayed
  Then Close the Browser
	
