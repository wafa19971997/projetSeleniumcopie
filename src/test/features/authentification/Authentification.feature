Feature: je vérifie la connexion à erudaxis 
  en tant qu administrateur je veux acceder a mon compte erudaxis

  @Erudaxis_Authentification
  Scenario: connecter à Studdify  
    Given je saisis url "https://staging.erudaxis.com/"
    When je saisis le login "lafiwafa97@gmail.com"
    And je saisis le mot de passe "Wafa@123"
    And je clique sur le bouton login
    Then je verifie la connexion par le texte "General Statistics"
    