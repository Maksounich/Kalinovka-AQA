pipeline {
        agent any

        stages {
            stage ('Compile Stage') {

                 steps {
                    withMaven(maven : 'mvn 3.9.5') {
                         sh 'mvn clean compile'
                    }
                }
            }
        }
}