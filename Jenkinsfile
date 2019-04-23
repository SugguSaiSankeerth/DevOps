pipeline {
	agent any
	stages {
		stage('BUILD - .war') {
			steps {
				sh 'mvn package'
			}
		}

		stage('BUILD - Docker Images') {
			steps {
				sh 'docker build -t project .'
				sh 'docker build -t projectmysql -f mysql.Dockerfile .'
			}
		} 

		stage('TEST - Setting up Test') {
			steps {
				sh 'docker-compose up -d'
			}
		}		

		stage("TEST - Running Test") {
			steps 
			{
				
				script 
				{
					sh 'until docker-compose exec webapi -c "select 1" > /dev/null 2>&1; do sleep 2; done'
					sh 'npm install'
					try {
						sh 'npm run api-tests-production'
						currentBuild.result = 'SUCCESS'
					}
					catch(Exception ex) {
						currentBuild.result = 'FAILURE'
					}
				}
			}
		}

		stage('TEST - Finishing Test') {
			steps {
				sh 'docker-compose down'
			}
		}
	}	
}