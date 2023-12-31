pipeline {
    agent any

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', description: 'Select the branch to build', name: 'BRANCH'
    }

    tools {
        maven 'Maven' // Name configured in Jenkins for Maven
        jdk 'JDK17'  // Name configured in Jenkins for JDK
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: params.BRANCH]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'vchaturv-ios/******', url: 'https://github.com/vchaturv-ios/spring-ai-demo.git']]])
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
