node {
	
	stage('BUILD') {
		stage('Create .war') {
			sh 'mvn package'
		}
		
		
		stage('Build Application Docker') {
			sh 'docker build -t project .'
		}
		
		stage('Build Database Docker') {
			sh 'docker build -t projectmysql -f mysql.Dockerfile .'
		}
	}
	
	stage('TEST') {
		
		stage('Compose up') {
			sh 'docker-compose up -d'
		}		

		stage('Running Test') {
			sh 'echo "Hello World !"'
			sh 'sleep 20'
			sh 'npm install'
			try{
				sh 'npm run api-tests-production'
				currentBuild.result = 'SUCCESS'
			}
			catch(Exception ex)
			{
				currentBuild.result = 'FAILURE'
			}
		}
		
		stage('Compose down') {
			sh 'docker-compose down'
		}
	}
}