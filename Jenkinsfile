pipeline {
  agent any
 
 // tools {nodejs "node_16_13_1"}
 
  stages {
    stage('Compile Stage') {
      tools {
        jdk "jdk1.8.0_202"
      }
      steps {
          withMaven (maven: 'maven_3_8_4'){
              bat 'mvn compile'
            }
        }
    }
    stage('Testing Stage') {
      tools {
        jdk "jdk1.8.0_202"
      }
      steps {
          withMaven (maven: 'maven_3_8_4'){
              bat 'mvn test'
            }
        }
    }
  }
}