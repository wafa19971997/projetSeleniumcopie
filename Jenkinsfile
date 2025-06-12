pipeline {
    agent any
    tools {
        maven 'maven' 
    }
    environment {
        // Définir les variables pour les rapports Cucumber
        CUCUMBER_JSON = 'target\\cucumber-report.json'
        CUCUMBER_HTML = 'target\\cucumber-report.html'
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code source depuis le dépôt Git
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/wafa19971997/projetSeleniumcopie.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
                // Installer les dépendances via Maven sans exécuter les tests (Windows)
               bat 'mvn clean install -U -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Exécuter les tests Cucumber et générer les rapports JSON et HTML (Windows)
                bat 'mvn test'
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                // Publier les résultats du rapport Cucumber dans Jenkins
                cucumber fileIncludePattern: '**/cucumber-report.json',
                         jsonReportDirectory: 'target'
            }
        }

        stage('Archive Reports') {
            steps {
                // Archiver les rapports JSON et HTML générés
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}", allowEmptyArchive: false
            }
        }
    }

   post {
  always {
    script {
      if (fileExists('target/cucumber-report.json')) {
        cucumber fileIncludePattern: 'target/cucumber-report.json'
      } else {
        echo "Cucumber report JSON not found."
      }
    }

    junit 'target/surefire-reports/*.xml'
  }
}

}
