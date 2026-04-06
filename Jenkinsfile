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
                sh '''
                mvn sonar:sonar \
                  -Dsonar.projectKey=timesheet \
                  -Dsonar.host.url=http://localhost:9000 \
                  -Dsonar.login=VOTRE_TOKEN
                '''
            }
        }
    }
}
