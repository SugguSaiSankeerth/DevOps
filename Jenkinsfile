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


		stage('TEST')
		{
			parallel
			{

				stage('TEST - Setting up Test') {
					steps {
						sh 'docker-compose up'
					}
				}		

				stage("TEST - Running Test") {
					steps 
					{
						
						script 
						{
							sh 'sleep 50'
							sh 'npm install'
							try {
								sh 'npm run api-tests-production'
								currentBuild.result = 'SUCCESS'
							}
							catch(Exception ex) {
								currentBuild.result = 'FAILURE'
							}
						}

						sh 'docker-compose down'
					}
				}

			}
		}
	}

	
}