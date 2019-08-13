Feature: Create and Get - SuperheroApi

  Scenario: User create an superhero
    Given making a POST request
    When receiving the 200 code
  #  Then response should contain


  Scenario Outline: User gets an superhero
    Given making a GET request for <id> to <endpoint>
    When receiving the <status> code
  #  Then response should contain

    Examples:
      | endpoint          | id  | status |
      | /superheroes/{id} | 132 | 200    |
      | /superheroes/{id} |     | 405    |