pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                configFileProvider([configFile(fileId: '9ea7bb72-cb40-47e4-8af0-e7cb98aeb62c', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -B -s $MAVEN_SETTINGS clean package'
                }
            }
        }
        stage('Publish') {
            steps {
                configFileProvider([configFile(fileId: '4712d7e9-ba97-45c2-b20a-2f24c5dc12b7', variable: 'publish')]) {
                    sh 'bash $publish'
                }
            }
        }
    }
}