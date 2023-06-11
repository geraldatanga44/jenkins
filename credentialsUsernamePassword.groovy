pipeline {
    environment {
        /*
            Uses a jenkins credential called cred1 and creates environment variable:
            "$FOO" will contain string "USR:PSW"
            "FOO_USR" will contain username
            "Foo_PSW" will contain password
        */
        FOO = credentials('cred1')
    }

    agent any

    stages {
        stage('Foo') {
            steps {
                sh 'echo "FOO is $FOO"'
                sh 'echo "FOO_USER is $FOO_USR"'
                sh 'echo "FOO_PSW is $FOO_PSW"'

                //write to fill
                dir("combined") {
                    sh 'echo $FOO > foo.txt'
                }

                sh 'echo $FOO_PSW > foo_psw.txt'
                sh 'echo $FOO_USR > foo_usr.txt'

                archiveArtifacts "**/*.txt"
            }
        }
    }
}