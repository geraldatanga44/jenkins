
podTemplate(containers: [
     containerTemplate(name: 'ubuntu', image: 'ubuntu:latest', command: 'sleep', args: '99d')
]) {
    node(POD_LABEL) {
        stage('Foo Ubuntu') {
            container('ubuntu') {
                stage('check env vars') {
                    sh 'touch file.txt'
                    sh 'cd $WORKSPACE_TMP'
                    sh 'ls -la'
                    withEnv(["SOME_VAR=SOME VAR", "CRED1=${credentials('cred1')}"]) {
                        sh "echo $SOME_VAR"
                        sh "echo $CRED1"
                    }
                }
            }
        }
    }
}
