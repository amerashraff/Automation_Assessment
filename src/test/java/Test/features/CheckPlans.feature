Feature: Check Plans function
  Scenario Outline: Check plan's title and price and currency
    Given Open the browser and navigate to stcTV site
    And Check the language to be english
    When Select the "<Country>"
    Then The plans title should be "<PlanOne>" and "<PlanTwo>" and "<PlanThree>"
    And The plans price should be "<PlanOnePrice>" and "<PlanTwoPrice>" and "<PlanThreePrice>"
    Then The plans currency should be "<Currency>"
    And Close the browser

    Examples:
    | Country | PlanOne | PlanTwo | PlanThree | PlanOnePrice | PlanTwoPrice | PlanThreePrice | Currency |
    | Egypt   | LITE    | CLASSIC | PREMIUM   |    0.25      |     0.5      |      1         |   USD    |
    | Jordan  | LITE    | CLASSIC | PREMIUM   |    2.7       |     5.2      |      8         |   USD    |
    | UAE     | LITE    | CLASSIC | PREMIUM   |    5.4       |     10.9     |      16.3      |   USD    |