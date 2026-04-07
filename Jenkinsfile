pipeline {
    agent any
    stages {
        stage('GIT') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/roualabidi/timesheet-project'
            }
        }

        stage('COMPILATION') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('ANALYSIS') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    sh 'mvn clean verify sonar:sonar'
                }
            }
        }
    }
}
