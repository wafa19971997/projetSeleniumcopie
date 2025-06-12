

Feature: creation dun devis cas correcte 
  
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

      @DevisCasCorrecteTC3
          Scenario: en tant que administrateur je veux cree un devis en remplissant seulement les champs obligatoires
          
      Given l’utilisateur est connecté et accède uu formulaire nouveau devis
      When il clique su le champs "Destinataire" 
      And choisir un destinataire
      And il clique sur le champ "Type d'article" 
      And choisir un article 
      When il clique sur le bouton Créer le devis
      Then le formulaire est validé je verifie la presence de pop up "Ajouter devis réussie"
      
    