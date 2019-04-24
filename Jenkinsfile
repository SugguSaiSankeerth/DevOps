pipeline 
{
	agent any
	
	stages 
	{
		
		stage('BUILD - .war') 
		{
			steps 
			{
				sh 'mvn package'
			}
		}

		stage('BUILD - Docker Images') 
		{
			steps 
			{
				sh 'docker build -t mvscharan9/spectrum_website:webimg .'
				sh 'docker build -t mvscharan9/spectrum_website:mysqlimg -f mysql.Dockerfile .'
			}
		} 


		stage('TEST')
		{
			parallel
			{
				stage('TEST - Setting up Test') 
				{
					steps 
					{
						sh 'docker-compose up'
					}
				}		

				stage("TEST - Running Test") 
				{
					steps 
					{	
						script 
						{
							sh 'sleep 60'
							sh 'npm install'
							try 
							{
								sh 'npm run api-tests-production'
								currentBuild.result = 'SUCCESS'
								sh 'docker-compose stop'
							}
							catch(Exception ex) 
							{
								currentBuild.result = 'ABORTED'
								sh 'docker-compose stop'
								error('Test Cases Failed')

							}
						}

						
					}
				}
			}
		}

		stage('PUBLISH to DockerHub') 
		{
		    steps 
		    {
	        	withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) 
	        	{
	        		sh 'docker push mvscharan9/spectrum_website:webimg'
	        		sh 'docker push mvscharan9/spectrum_website:mysqlimg'
	      		}
			}
		}

	}

	post 
	{ 
		always 
		{ 
    		sh 'docker-compose stop'
		}

			
 	}
}