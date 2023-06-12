

pipeline {
    agent any

    environment {
        FOO = 'pipeline'
        STR = 'echo message: FOO is $FOO and BAR is $BAR'
    }

    stages {
        stage('Local') {
            environment {
                BAR = 'Stage'
            }
            steps {
                sh $STR
            }
        }

        stage('Global') {
            steps {
                sh $STR
            }
        }
    }
}
