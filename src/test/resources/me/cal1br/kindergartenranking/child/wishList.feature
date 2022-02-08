Feature: Child is accepted into kindergarten by ranking.

  Scenario: Child is accepted normally
    Given Child has wishlist
    When Ranking is processed
    Then Child is accepted into a kindergarten

  Scenario: Second wish
    Given Child has wishlist
    When Ranking is processed
    Then Child is accepted into second kindergarten

  Scenario: No wishlist
    Given Child has no wishlist
    When Rankin is processed
    Then Child isn't accepted anywhere

  Scenario: No spots
    Given Child has wishlist
    And Kindergarten has no spots
    When Ranking is processed
    Then Child isn't accepted anywhere