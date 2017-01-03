Feature: Hello World
  Controller allow switch between simple pages

  Scenario: Switch between jsp page with clicks
    Given index jsp page with latam background and show a link for click
    When click in link
    Then show other jsp page with same background
