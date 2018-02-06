pipeline {
    agent {
        docker {
            image 'maven:3'
             args '-v /root/.m2:/root/.m2'
         }
     }
     stages {
         stage('Build') {
             steps {
                     sh 'mvn -B clean package -Dmaven.test.skip=true'
             }
         }
         stage('Test') {
                              steps {
                                  sh 'mvn test'
                              }
                       }
         stage('Publish') {
             steps {
                 configFileProvider([configFile(fileId: '4712d7e9-ba97-45c2-b20a-2f24c5dc12b7', variable: 'publish')])
                 {
                  sshagent(credentials: ['a65d8fb8-0920-4060-a29d-2c46c3c2f994']){
                     sh 'chmod 775 $publish'
                     sh '$publish'
                 }
             }
             }
         }
     }
 }