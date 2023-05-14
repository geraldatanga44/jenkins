pipeline{
    agent{
        kubernetes {
            yaml '''
            apiVersion: v1
            kind: Pod
            spec:
            containers:
            - name: maven
                image: maven:alpine
                command:
                - cat
                tty: true
            - name: node
                image: node:16-alpine3.12
                command:
                - cat
                tty: true
            '''
        }
    }
    stages{
        stage("Run Maven"){
            steps{
                echo "========executing A========"
                steps {
                    container('maven') {
                        sh 'mvn -version'
                    }
                    container('node'){
                        sh 'npm version'
                    }
                }
            }
            post{
                always{
                    echo "========always========"
                }
                success{
                    echo "========A executed successfully========"
                }
                failure{
                    echo "========A execution failed========"
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}