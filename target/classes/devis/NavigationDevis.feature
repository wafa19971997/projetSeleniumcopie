Feature: Navigation vers la page Devis

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

  @Erudaxis_NavigationDevis
  
  Scenario: Accès à la section "devis"
    Then la page "Devis" s’affiche avec les éléments de l’interface correspondant