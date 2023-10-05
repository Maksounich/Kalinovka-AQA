pipeline {
        agent any

        stages{
            stage ('Compile Stage') {

                 steps {
                    maven(maven : 'mvn 3.9.5') {
                    sh 'mvn clean compile'
                    }
                }
            }

            stage ('Testing Stage') {

                             steps {
                                maven(maven : 'mvn 3.9.5') {
                                sh 'mvn test'
                                }
                            }
                        }
        }
}