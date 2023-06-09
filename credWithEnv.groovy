
pipeline {
    environment {
        //env vars and credential retrivals
        SOME_VAR = 'SOME VALUE'
    }

    agent {
        any
    }

    stages {
        stage(name: 'Foo') {
            sh(script: 'echo "SOME_VAR is $SOME_VAR"')
        }
    }
}
