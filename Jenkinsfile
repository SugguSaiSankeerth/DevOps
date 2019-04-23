pipeline {
	agent any
	stages {
		stage('mvs package to create .war'){
			steps {
				sh 'mvn package'
			}
		}
		stage('Build Application Docker'){
			steps {
				sh 'docker build -t project .'
			}
		}
		stage('Build Database Docker'){
			steps {
				sh 'docker build -t projectmysql -f mysql.Dockerfile .'
			}
		}
		stage('Compose up'){
			steps {
				sh 'docker-compose up'
			}
		}
	}
}