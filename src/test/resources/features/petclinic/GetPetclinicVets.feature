Feature: Get Vets for PetClinic

  Scenario Outline: User calls web service to get all available vets, owners, users
    Given making a GET request for <type> to <endpoint>
    When receiving the <status> code
  #  Then response should contain

    Examples:
      | endpoint    | type   | status |
      | /api/{type} | vets   | 200    |
      | /api/{type} | owners | 200    |
      | /api/{type} | pets   | 200    |