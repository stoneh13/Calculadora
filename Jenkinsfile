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
        stage("Construir Docker"){
            steps{
                sh "docker build -t localhost:6000/calculadora . "
            }
        }
        stage("Push Docker"){
            steps{
                sh "docker push localhost:6000/calculadora"
            }
        } 
        stage("Crear Contenedor Docker"){
            steps{
                sh "docker run -d -p 9090:8090 --name calculadora2 localhost:6000/calculadora"
            }
        } 
    }
}
