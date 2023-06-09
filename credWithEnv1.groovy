pipeline {
    environment {
        SOME = 'SOME VALUE'
        CRED1 = credentials('cred1')
        INBETWEEN = 'Something in between'
        CRED2 = credentials('cred2')
        OTHER = "${SOME}"
    }

    agent any

    stages {
        stage('Foo') {
            steps{
                sh "echo $SOME"
                sh "echo $CRED1"
                sh "echo $INBETWEEN"
                sh "echo $CRED2"
                sh "echo $OTHER"
            }
        }
    }
}