
podTemplate(containers: [
     containerTemplate(name: 'ubuntu', image: 'ubuntu:latest', command: 'sleep', args: '99d')
]) {
    node(POD_LABEL) {
        environment {
            SOME_VAR = 'SOME VALUE'
        }

            stage('Foo Ubuntu') {
                container('ubuntu') {
                    stage('check env vars') {
                        sh  'echo SOME_VAR is $SOME_VAR'
                    }
                }
            }
    }
}
