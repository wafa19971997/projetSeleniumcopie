pipeline {
    agent any
    tools {
        maven 'maven'
    }
    environment {
        CUCUMBER_JSON = 'target/cucumber-report.json'
        CUCUMBER_HTML = 'target/cucumber-report.html'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/wafa19971997/projetSeleniumcopie.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
               bat 'mvn clean install -U -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Exécuter les tests Cucumber et générer le rapport
                bat 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
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
        junit 'target/surefire-reports/**/*.xml'
      }
    }
}

