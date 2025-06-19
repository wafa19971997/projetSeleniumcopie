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
                sh 'mvn clean install -U -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonar') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}", allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            script {
                if (fileExists("${CUCUMBER_JSON}")) {
                    cucumber fileIncludePattern: "${CUCUMBER_JSON}"
                } else {
                    echo "Cucumber report JSON not found."
                }
            }

            // Attention : Cucumber ne génère pas de .xml par défaut
            // Utiliser uniquement si tu as des rapports JUnit
            junit 'target/surefire-reports/**/*.xml'
        }
    }
}
