
@Salles
Feature: Ajouter une nouvelle salle
  En tant que administrateur je veux ajouter une nouvelle salle

  Background: 
    Given je saisis url "https://staging.erudaxis.com/"
    When je saisis le login "lafiwafa97@gmail.com"
    And je saisis le mot de passe "Wafa@123"
    And je clique sur le bouton login
    Then je verifie la connexion par le texte "General Statistics"
    Given je clique sur plan etude
    When je clique sur parametrage
    And je clique sur bloc et salle
    And je clique sur nom des salles

  @Ajouter_Salle
  Scenario: je vérifie l ajout d une nouvelle salle
    And je clique sur bouton ajouter salle
    And je saisis le nom de salle "S1 718"
    And je saisis le la capacité de la salle "30"
    And je selectionne le type de la salle "Cours"
    And je selectionne le bloc de la salle "Bloc A"
    And je clique sur bouton Ajouter
    Then je vérifie l ajout de nouvelle salle avec le message de popup "La salle ajoutée avec succès"
    And je clique sur bouton OK pour confirmer l ajout

  @Modifier_Salle
  Scenario: je vérifie la modification de la salle
    Given je cherche la salle a modifer "S1 718"
    And je clique sur icon stylo
    When je change le nom de salle "S1 402"
    And je change la capacité de la salle "50"
    And je change  le type de la salle "TD"
    And je clique sur bouton Modifier
    Then je vérifie la modification de nouvelle salle avec le message popup "La salle a été modifiée avec succès."
    And je clique sur bouton OK pour con firmer la modification

  @SuppresionSalle
  Scenario: je vérifie la suppression d une salle
    Given je cherchere la salle "S1 402"
    When je clique sur bouton supprimer
    And je clique bouton OUI Supprimer de popup
    Then je vérifie la suppression de la salle avec le message popup "La salle a été supprimée avec succès."
