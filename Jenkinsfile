pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'maven-3.9.1'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/faizdafedar3/restassured-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat '''
                    echo =========================
                    echo BUILD & TEST STARTED
                    echo =========================

                    java -version
                    mvn -version

                    mvn clean test
                '''
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
