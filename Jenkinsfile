pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git url: 'YOUR_GIT_REPO_URL', branch: 'main'
            }
        }
        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t myjavaapp:1 .'
            }
        }
        stage('Run Container Test') {
            steps {
                sh 'docker run -d -p 8080:8080 myjavaapp:1'
            }
        }
    }
}

