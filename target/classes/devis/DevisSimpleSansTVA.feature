Feature: Création dun devis dans lapplication Erudaxis
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

  @Erudaxis_DevisSimpleSansTVA

      Scenario: Création d’un devis simple sans TVA
    When je choisis le destinataire 
    And je saisis la durée de validité "30"
    And je sélectionne la devise "Dinar tunisien (DT)"
    And je sélectionne "TVA non applicable"
    And je choisis les conditions de règlement "30 jours fin de mois"
    And je choisis "Pas d'intérêts de retard"
    And je choisis le mode de paiement "Comptant"
    And je saisis un droit de timbre de "0"
    And je saisis une retenue à la source de "0"
    And je sélectionne létat de devis "Neutre"
    And je sélectionne un article "Inscription" avec quantité "1", prix HT "100", TVA "0", réduction "0"
    Then le total HT doit être "100.000"
    And le total TTC doit être "100.000"
    