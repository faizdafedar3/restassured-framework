pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/faizdafedar3/restassured-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    def mvnHome = tool 'maven-3.9.1'

                    bat """
                    echo =========================
                    echo RUNNING MAVEN TESTS
                    echo =========================

                    "${mvnHome}\\bin\\mvn.cmd" -version
                    "${mvnHome}\\bin\\mvn.cmd" clean test
                    """
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/*.xml'
        }
    }
}
