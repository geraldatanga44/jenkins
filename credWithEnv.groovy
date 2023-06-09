
podTemplate(containers: [
     containerTemplate(name: 'ubuntu', image: 'ubuntu:latest', command: 'sleep', args: '99d')
]) {
    node(POD_LABEL) {
        stage('Foo Ubuntu') {
            container('ubuntu') {
                stage('check env vars') {
                    sh 'printenv'
                    sh 'ls -la'
                    withEnv(["SOME_VAR=SOME VAR"]) {
                        sh "echo $SOME_VAR"
                    }
                }
            }
        }
    }
}
