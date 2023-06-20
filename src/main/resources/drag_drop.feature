Feature: eturkistan drag and drop feature
  Scenario Outline: drag and drop column title
    Given I launch SDBO
    When I login with usename "ab.nurum@gmail.com" and password "123456"
    And I click on SDBO Resource section
    And I save "<init position>" title name
    When I drag item "<init position>" to item "<final position>"
    Then I verify "<final position>" title same as saved title name

    Examples:
      | init position | final position |
      |             1 |              3 |
      |             2 |              5 |