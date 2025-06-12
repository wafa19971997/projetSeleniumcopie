

Feature: Création de devis - Champs obligatoires vides
  
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
    
          @TC4
                Scenario: Création de devis avec champs obligatoires vides
    Given l’utilisateur est connecté et accède à Nouveau devis
    When il laisse les champs obligatoires vides et clique sur "Créer le devis"
    Then des messages d’erreur s’affichent

 
