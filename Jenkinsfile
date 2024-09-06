pipeline {
    agent any

    environment {
        DIRECTORY_PATH = "${env.WORKSPACE}"
        TESTING_ENVIRONMENT = 'staging'
        PRODUCTION_ENVIRONMENT = 'Jishnu'
    }

    stages {
        stage('Build') {
            steps {
                echo "Fetching the source code from ${env.DIRECTORY_PATH}"
                echo "Compiling the code and generating necessary artifacts"
                // Actual build commands would go here, e.g., `sh 'mvn clean install'`
            }
        }

        stage('Unit and Integration Tests') {
            steps {
                echo "Running unit tests using JUnit"
                echo "Running integration tests using TestNG"
                // Commands for running tests, e.g., `sh 'mvn test'`
            }
        }

        stage('Code Analysis') {
            steps {
                echo "Analyzing code quality using SonarQube"
                // Command to run SonarQube analysis, e.g., `sh 'sonar-scanner'`
            }
        }

        stage('Security Scan') {
            steps {
                echo "Performing a security scan using OWASP ZAP"
                // Command to run security scan, e.g., `sh 'zap-cli start'`
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo "Deploying the application to ${env.TESTING_ENVIRONMENT} environment"
                // Command to deploy to staging, e.g., `sh 'aws deploy ...'`
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo "Running integration tests on the staging environment"
                // Commands for running tests on staging
            }
        }

        stage('Deploy to Production') {
            steps {
                echo "Deploying the application to the ${env.PRODUCTION_ENVIRONMENT} environment"
                // Command to deploy to production, e.g., `sh 'aws deploy ...'`
            }
        }
    }

    post {
        success {
            emailext (
                subject: "Jenkins Build Success: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: "Build succeeded! Check the logs for details.",
                to: 'jishnu.divit@gmail.com',
                attachLog: true
            )
        }
        failure {
            emailext (
                subject: "Jenkins Build Failure: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: "Build failed. Check the logs for more details.",
                to: 'jishnu.divit@gmail.com',
                attachLog: true
            )
        }
    }
}
