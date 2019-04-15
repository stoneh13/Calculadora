pipeline{
    agent any
    stages{
        stage("compilar"){
            steps{
                sh './gradlew compileJava'
            }
        }
        stage("test"){
            steps{
           sh './gradlew test'
            }
        }
    }
}
