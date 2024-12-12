Feature: Consultation des moyennes de toutes les matières

  Scenario: Consultation des moyennes
    Given une matière "Mathématiques" avec les notes 15.0 et 13.0
    And une matière "Physique" avec les notes 10.0 et 12.0
    When je consulte les moyennes de toutes les matières
    Then la moyenne de "Mathématiques" est 14.0
    And la moyenne de "Physique" est 11.0
