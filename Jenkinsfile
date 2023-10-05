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
            post {

                            success { allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                            ])
                        }
        }
    }
}
}