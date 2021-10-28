Feature: Booking.com search verification
  Scenario: Check displayed rating
    Given Go to "https://www.booking.com/index.html?aid=1376321"
    When Enter Krasnodar Marriott Hotel and click search button
    Then Check that Krasnodar Marriott Hotel is displayed and have 5 stars rating