pipeline {
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk17'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/faizdafedar3/restassured-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish TestNG Report') {
            steps {
                publishTestNGResults testResultsPattern: '**/testng-results.xml'
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
                    reportName: 'Rest Assured API Report'
                ])
            }
        }
    }
}
