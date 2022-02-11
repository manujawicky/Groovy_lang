pipeline{
    agent any
    stages {
        stage ('compile') {
            steps {
                    echo "Complied Successfully!!";
            }
        }

        stage ('JUnit') {
            steps {
                    echo "JUnit Passed Successfully!!";
            }
        }

        stage ('Quality-Gate') {
            steps {
                    echo "SonarQube QUality GAte Passed Successfully!!";
                
            }
        }

        stage ('Deploy') {
            steps {
                    echo "Pass!!";
                
            }
        }


    }

    post {
        always {
            echo 'This will always run'
        }

        success {
            echo 'This will only run if successful'
        }

        failure {
            echo 'This will only run if failed'
        }

        unstable {
            echo 'This will run only if the run was marked as unstable'
        }

        changed {
            echo 'THis will run only if the state of pipeline has changed'
            echo 'For example, if the pipeline was previously failing but is now successful'
        }
    }
}