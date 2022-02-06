Feature: Editing information about a child
  Scenario: Administrator edits information about a child
    Given an administrator has selected a child
    When an administrator edits information about a child
    And click on save
    Then there is a message for success.
