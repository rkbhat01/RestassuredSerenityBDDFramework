Feature: Countries validation in response.

Scenario: Verify that Country name is availbale in response.
When User sends Valid Get request to country list it must return valid response with status code 200 
Then I Verfiy <"Republic of India"> is present in response