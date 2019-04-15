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
        stage("Crear Contenedor Docker"){
            steps{
               sh "sudo docker run -d -p 9090:8090 --name calculadora2 localhost:6000/calculadora"
            }
        } 
    }
}
