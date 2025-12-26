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
                    def jdkHome = tool 'jdk21'
                    def mvnHome = tool 'maven-3.9.1'

                    bat """
                    echo =========================
                    echo USING JENKINS TOOLS ONLY
                    echo =========================

                    "${jdkHome}\\bin\\java.exe" -version
                    "${mvnHome}\\bin\\mvn.cmd" -version

                    "${mvnHome}\\bin\\mvn.cmd" clean test
                    """
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
