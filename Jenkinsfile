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
            }
        }

        stage('Unit and Integration Tests') {
            steps {
                echo "Running unit tests using JUnit"
                echo "Running integration tests using TestNG"
            }

            post{
                success{
                    mail to: "jishnu.divit@gmail.com",
                    subject: "Test status email",
                    body: "Test passed"
                }
            }
        }

        stage('Code Analysis') {
            steps {
                echo "Analyzing code quality using SonarQube"
            }
        }

        stage('Security Scan') {
            steps {
                echo "Performing a security scan using OWASP ZAP"s
            }

            post{
                success{
                    mail to: "jishnu.divit@gmail.com",
                    subject: "security scan stage ${currentBuild.result}",
                    body: "Security scan stage completed"
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo "Deploying the application to ${env.TESTING_ENVIRONMENT} environment"s
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo "Running integration tests on the staging environment"
            }
        }

        stage('Deploy to Production') {
            steps {
                echo "Deploying the application to the ${env.PRODUCTION_ENVIRONMENT} environment"
            }
        }
    }
}
