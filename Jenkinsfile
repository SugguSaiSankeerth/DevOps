pipeline 
{
	agent any
	
	stages 
	{
		
		stage('BUILD') 
		{
			steps 
			{
				sh 'mvn package'
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
			sh 'echo "Pipeline Finished"'
		}

		success
		{	
			sh 'chmod +x aws_script/sample.sh'
    		sh 'aws_script/./sample.sh'
    		sh 'sleep 15'
			sh 'curl --location --request POST "http://localhost:4440/api/21/job/a6521c89-c162-4c3a-99c0-7f13cb08e391/run" \
	  --header "Accept: application/json" \
	  --header "X-Rundeck-Auth-Token: qIC6nrPc8Z0lObKmzcfA0OmKu8rmP4fI" \
	  --header "Content-Type: application/json" \
	  --data ""'
		}	
 	}
}