Feature: Default

	Background:
		#@FLTAPS-997
		Given the user is on the login page
		Then the user logged with "salesmanager120" "UserUser123"


	@FLTAPS-1135
	Scenario: as a salesmanager sould add event

		When user should click under "Fleet" "Vehicles"
		Then user should select any car or row
		Then user should display add event button