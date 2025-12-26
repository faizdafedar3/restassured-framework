pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'maven-3.9.1'
    }

    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn -version'
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
