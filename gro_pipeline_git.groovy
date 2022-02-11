pipeline{
    agent any
    stages {
        stage ('Git-checkout') {
            steps {
                    echo "Checking out from git repo";
                    git 'https://github.com/simplilearn-github/Pipeline_Script.git'
            }
        }

        stage ('Build') {
            steps {
                    echo "Building the checked-out project!";
            }
        }

        stage ('Unit_Test') {
            steps {
                    echo "Runnning JUnit Tests";
                
            }
        }

        stage ('Quality-Gate') {
            steps {
                    echo "Verify Quality Gates";
                
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
            echo 'This will run only if the state of pipeline has changed'
            echo 'For example, if the pipeline was previously failing but is now successful'
        }
    }
}