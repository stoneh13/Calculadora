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
        stage("Parar contenedor") {
            when {
                expression { sh script: '''if [ -z $(sudo docker ps -f name=calculadora2 -q) ]; then true; else false; fi''', returnStatus: true
                  }
              }
            steps {
                sh "sudo docker stop calculadora2"
             }
        }
         stage("Borrar contenedor") {
            when {
                expression { sh script: '''if [ -z $(sudo docker ps -f -a name=calculadora2 -q) ]; then true; else false; fi''', returnStatus: true
                  }
              }
            steps {
                sh "sudo docker rm calculadora2"
             }
        }
    
        stage("Crear Contenedor Docker"){
            steps{
               sh "sudo docker run -d -p 9090:8090 --name calculadora2 localhost:6000/calculadora"
            }
        } 
        stage("Lanzar calculadora5"){
              steps{
                  ansible-playbook playbook.yml
              }
        }
    }
}
