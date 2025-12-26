pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'jdk17'
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
                script {
                    def javaHome = tool 'jdk17'
                    withEnv([
                        "JAVA_HOME=${javaHome}",
                        "PATH=${javaHome}\\bin;${env.PATH}"
                    ]) {
                        bat 'echo JAVA_HOME=%JAVA_HOME%'
                        bat 'java -version'
                        bat 'mvn -version'
                        bat 'mvn clean test'
                    }
                }
            }
        }

        stage('Publish TestNG Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }
}
