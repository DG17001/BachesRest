pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -f pom.xml clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('SCM') {
            steps {
                checkout scm
            }
        }
        stage('SonarQube Analysis') {
            steps {
                def mvn = tool 'Default Maven';
                withSonarQubeEnv() {
                    sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=bachesDemo"
                }
            }
        }
    }
}
