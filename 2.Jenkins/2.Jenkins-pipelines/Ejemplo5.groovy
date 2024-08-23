pipeline {
    agent any

    stages {
        stage('Git Clone Repo') {
            steps {
                checkout scmGit(branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/iscramirezac/devops.git']])
                sh "ls -larth"
            }
        }
    }
}