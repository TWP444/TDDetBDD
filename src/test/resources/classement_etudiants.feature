Feature: Classement des étudiants

  Scenario: Classement des étudiants par moyenne générale
    Given un étudiant "Alice" avec une moyenne générale de 15.0
    And un étudiant "Bob" avec une moyenne générale de 13.0
    And un étudiant "Charlie" avec une moyenne générale de 17.0
    When je consulte le classement des étudiants
    Then le premier étudiant est "Charlie" avec une moyenne de 17.0
    And le deuxième étudiant est "Alice" avec une moyenne de 15.0
    And le troisième étudiant est "Bob" avec une moyenne de 13.0
