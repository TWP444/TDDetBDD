Feature: Calcul de la moyenne d'une matière

  Scenario: Saisie des notes et calcul de la moyenne d'une matière
    Given une matière "Mathématiques" avec le code "MAT101"
    When je saisis les notes 15.0, 12.0 et 18.0
    Then la moyenne de la matière "Mathématiques" est 15.0
