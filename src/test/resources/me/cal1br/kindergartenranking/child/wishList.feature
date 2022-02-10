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
    And First wish kindergarten has no spots
    When Ranking is processed
    Then Child is accepted into a kindergarten

  Scenario: No wishlist
    Given Child has no wishlist
    When Ranking is processed
    Then Child isn't accepted anywhere

  Scenario: No spots
    Given Child has wishlist
    And Kindergarten has no spots
    When Ranking is processed
    Then Child isn't accepted anywhere

  Scenario: Child with disability is accepted into first wish
    Given There is a child with disability and a wishlist
    And There aren't enough spots for everyone in a given kindergarten
    When Ranking is processed
    Then Child with disability gets prioritized


# таблица в given, с деца, ! така че да се напълни базата един видю