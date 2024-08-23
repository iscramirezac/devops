pipeline {
    agent any

    stages {
        stage('Git Clone Repo') {
            steps {
                checkout scmGit(branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/iscramirezac/devops.git']])
            }
        }
        stage('Build Docker Image Halcyonic') {
            steps {
                script {
                    def nth="hl-v1.$BUILD_NUMBER"
                    env.NEW_TAG_H = nth
                }
                dir('docker-examples') {
                    sh """
                        cp Dockerfile_halcyonic $WORKSPACE/web-sites-examples/halcyonic/
                    """
                }
                dir('web-sites-examples/halcyonic') {
                    sh """
                        docker build -t halcyonic:$NEW_TAG_H -f Dockerfile_halcyonic .
                    """
                }
            }
        }
        stage('Build Docker Image Multiverse') {
            steps {
                script {
                    def ntm="ml-v1.$BUILD_NUMBER"
                    env.NEW_TAG_M = ntm
                }
                dir('docker-examples'){
                    sh """
                        cp Dockerfile_multiverse $WORKSPACE/web-sites-examples/multiverse/
                    """
                }
                dir('web-sites-examples/multiverse'){
                    sh """
                        docker build -t multiverse:$NEW_TAG_M -f Dockerfile_multiverse .
                    """
                }
            }
        }
        stage('Deploying With Compose') {
            steps {
                dir('proyecto-final') {
                    sh """
                        sed -i 's|image: halcyonic:.*|image: halcyonic:${env.NEW_TAG_H}|' docker-compose.yaml
                        sed -i 's|image: multiverse:.*|image: multiverse:${env.NEW_TAG_M}|' docker-compose.yaml
                        docker-compose up -d
                        docker ps
                    """
                }
            }
        }
        stage('Down With Compose') {
            steps {
                dir('proyecto-final') {
                    sh """
                        docker-compose down
                    """
                }
            }
        }
    }
}