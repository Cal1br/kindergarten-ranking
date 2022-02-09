Feature: Child is accepted into kindergarten by ranking.
  Background:
    Given There is a child
    And There is a kindergarten

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
    When Ranking is processed
    Then Child isn't accepted anywhere

  Scenario: No spots
    Given Child has wishlist
    And Kindergarten has no spots
    When Ranking is processed
    Then Child isn't accepted anywhere


# таблица в given, с деца, ! така че да се напълни базата един видю