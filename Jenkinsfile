pipeline{
    agent any

    stages {
        stage('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_6_1'){
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Running Tests'){
            steps {
                withMaven(maven: 'maven_3_6_1'){
                    sh 'mvn test'
                }
            }
        }
        stage('Packaging Jar...'){
            steps {
                withMaven(maven: 'maven_3_6_1'){
                    sh 'mvn package'
                }
            }
        }
    }
}
