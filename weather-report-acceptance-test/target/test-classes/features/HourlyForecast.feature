@HOURLY_FORECAST 
Feature: Verifying hourly forecast for a day 

Scenario Outline: Launch the Application get 3 hourly forecast for a given day 
	Given I launch the application 
	When Enter city Name as "GLASGOW" 
	Then Get Forecast for "<ValidCity>" 
	And Select the "Tue" 
	Then I should see the details as "<hour>","<Max_temperature>","<min_temperature>","<speed>","<direction>","<rainfall>","<pressure>" 
	And close the application 
	Examples: 
	
		|hour|  Max_temperature|min_temperature|speed |direction  | rainfall|pressure|
		|1300|           16       |      13       | 3kph |direction-1| 1mm     |1015mb  |
 		|1600|           16      |      14       | 3kph |direction-1| 0mm     |1014mb  |
  		|1900|           13       |      12      | 1kph |direction-1-3| 0mm     |1013mb  | 
