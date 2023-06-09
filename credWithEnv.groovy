pipeline {
    environment {
        SOME_VAR = 'SOME VALUE'
        CRED1 = credentials('cred1')
        INBETWEEN = 'Something in between'
        CRED2 = credentials('cred2')
        OTHER_VAR = "${SOME_VAR}"
    }

    agent {
        any
    }

    stages {
        stage(name: 'Foo') {
            step {
                sh(script: 'echo "SOME_ABR is $SOME_VAR"')
                sh(script: 'echo "INBETWEEN is $INBETWEEN"')
                sh(script: 'echo "OTHER_VAR is $OTHER_VAR"')
            }
        }
    }
}
