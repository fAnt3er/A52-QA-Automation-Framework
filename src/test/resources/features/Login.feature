Feature: Navigation Test

  Scenario: Navigation with valid email

    Given I open Login page
    Given I click on registration button
    When I enter email "Yevhenii.Ustenko@testpro.io"
    And I submit
    Then I sees confirmation message
