@CalculDevis
Feature: Calcul automatique du Total HT et Total TTC

  Background:
  Given je saisis url "https://staging.erudaxis.com/"
    When je saisis le login "lafiwafa97@gmail.com"
    And je saisis le mot de passe "Wafa@123"
    And je clique sur le bouton login
    Then je verifie la connexion par le texte "General Statistics"
    When il navigue vers le menu "Administration"
    And il navigue vers "Finances"
    And il navigue vers "Facturations"
    And il clique sur "Devis"
    And il clique sur le bouton "Nouveau devis" 

  @TC5
  Scenario Outline: Calcul dynamique selon Quantité, Prix HT et TVA
    Given l’utilisateur est connecté et accède à Nouveau devis
    When Il saisit la quantité "<quantite>"
    And Il saisit le prix HT "<prixHT>"
    And Il saisit la TVA "<tva>"
    Then Le champ "Total HT" doit afficher "<totalHT>"
    And Le champ "Total TTC" doit afficher "<totalTTC>"

    Examples:
      | quantite | prixHT | tva | totalHT | totalTTC |
      |    2     |   50   | 19  |  100  |  119   |
      |    0     |   80   | 19  |    0  |    0   |

  @TC6
  Scenario Outline: Vérification des erreurs pour des valeurs invalides
    Given l’utilisateur est connecté et accède à Nouveau devis
    When Il saisit la quantité "<quantite>"
    And Il saisit le prix HT "<prixHT>"
    And Il saisit la TVA "<tva>"
    
    Then Un message d'erreur s'affiche avec le texte "<message>"

    Examples:
      | quantite | prixHT | tva  | message                         |
      |   -1     |   50   |  19  | La quantité doit être > à 0               |
      |    2     |  -12   |  19  | Le prix HT doit être ≥ à 0                |
     
