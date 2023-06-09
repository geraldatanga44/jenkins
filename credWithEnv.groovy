
pipeline {
    environment {
        //env vars and credential retrivals
        SOME_VAR = 'SOME VALUE'
    }

    agent none

    stages {
        stage('Foo') {
            steps {
                sh(script: 'echo "SOME_VAR is $SOME_VAR"')
            }
        }
    }
}
