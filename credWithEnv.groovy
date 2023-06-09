
podTemplate(containers: [
     containerTemplate(name: 'ubuntu', image: 'ubuntu:latest', command: 'sleep', args: '99d')
]) {
    node(POD_LABEL) {
        environment {
            SOME_VAR = 'SOME VALUE'
        }
        stages {
            stage('Foo Ubuntu') {
                container('ubuntu') {
                    stage('check env vars') {
                        sh(script: 'echo "SOME_VAR is $SOME_VAR')
                    }
                }
            }
        }
    }
}
