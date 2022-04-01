Feature: CreateAccount

  Scenario Outline: Register an account
    Given I have started "<browser>" browser
    Given I have written an email "<email>"
    Given I have written a username "<user>"
    Given I have written a password "<password>"
    Given I check the box
    When I click the Sign Up button
    Then my account registers <status> with "<result>"

    Examples:
      | browser | email                    | user           | password   | status  | result                                                                             |
      | chrome  | mail                     | dateTime       | 1Password! | success | Check your email                                                                   |
      | firefox | mail                     | longUsername   | 1Password! | fail    | Enter a value less than 100 characters long                                        |
      | edge    | viktors-email@mailme.com | ViktorsAccount | 1Password! | fail    | Another user with this username already exists. Maybe it's your evil twin. Spooky. |
      | chrome  |                          | dateTime       | 1Password! | fail    | Please enter a value                                                               |