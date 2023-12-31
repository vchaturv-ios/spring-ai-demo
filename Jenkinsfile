pipeline {
    agent any

    tools {
        maven 'Maven' // Name configured in Jenkins for Maven
        jdk 'JDK17'  // Name configured in Jenkins for JDK
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Package') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Assuming the JAR file is in the target directory
                    sh 'java -jar target/springaidemo-0.0.1-SNAPSHOT.jar &'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
