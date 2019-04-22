pipeline {
	agent any
	stages {
		stage('Build Application Docker'){
			steps {
				sh 'docker build -t mvscharan9/spectrum_website .'
			}
		}
		stage('Build Database Docker'){
			steps {
				sh 'docker build -t mvscharan9/spectrum_website mysql.Dockerfile .'
			}
		}
		stage('Push to hub'){
			steps {
				sh 'docker push mvscharan9/spectrum_website'
			}
		}
	}
}