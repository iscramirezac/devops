pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh """
                    whoami
                    ls -larth
                    echo $WORKSPACE
                    echo $BUILD_NUMBER
                    echo $WORKSPACE
                """
                echo "${env.JENKINS_URL}"
                sh """
                    docker version
                """
            }
        }
    }
}