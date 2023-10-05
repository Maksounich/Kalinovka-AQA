pipeline {
    agent any

    tools {
        maven "mvn 3.9.5"
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn clean -D suite=suiteAPI test"
            }
        }
    }
    post {
                always {
                    archiveArtifacts artifacts: 'target/allure-results/*.json', fingerprint: true
                }
    }
}