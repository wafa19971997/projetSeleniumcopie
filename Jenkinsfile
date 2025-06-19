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

            stage('Install Chrome & ChromeDriver') {
            steps {
                sh '''
            apt-get update
            apt-get install -y wget gnupg2 apt-transport-https unzip curl software-properties-common

            # Ajouter le dépôt de Google Chrome
            wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
            echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list

            apt-get update
            apt-get install -y google-chrome-stable

            # Extraire la version exacte de Chrome
            CHROME_VERSION=$(google-chrome --version | grep -oP '\\d+\\.\\d+\\.\\d+\\.\\d+')

            # Télécharger ChromeDriver correspondant
            wget -q https://storage.googleapis.com/chrome-for-testing-public/$CHROME_VERSION/linux64/chromedriver-linux64.zip
            unzip chromedriver-linux64.zip
            mv chromedriver-linux64/chromedriver /usr/local/bin/
            chmod +x /usr/local/bin/chromedriver

            google-chrome --version
            chromedriver --version
        '''
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
            //junit 'target/surefire-reports/**/*.xml'
        }
    }
}
