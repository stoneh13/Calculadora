pipeline{
    agent any
    stages{
        stage("Compilar"){
            steps{
                sh './gradlew compileJava'
            }
        }
        stage("Test"){
            steps{
                sh './gradlew test'
            }
        }
        stage("Build gradle"){
            steps{
                sh './gradlew build'
            }
        }
        stage("Construir Docker"){
            steps{
               sh  "sudo docker build -t localhost:6000/calculadora . "
            }
        }
        stage("Push Docker"){
            steps{
               sh "sudo docker push localhost:6000/calculadora"
            }
        }
        stage("borrar contenedor") {
            when {
                expression { sh script: '''if [ -z $(docker ps -f name=calculadora -q) ]; then true; else false; fi''', returnStatus: true
                  }
              }
            steps {
                sh "sudo docker stop calculadora2"
                sh "sudo docker rm calculadora2"
             }
        }    
        stage("Crear Contenedor Docker"){
            steps{
               sh "sudo docker run -d -p 9090:8090 --name calculadora2 localhost:6000/calculadora"
            }
        } 
    }
}
