Feature: Weather Forecast Home Page

@Verify_Homepage
Scenario:  Open Weather Application and check the 5 days Forecast

Given I launch the application
When I enter "Stirling"
Then I should see the Weather Forcast for 5 days
And close the application


