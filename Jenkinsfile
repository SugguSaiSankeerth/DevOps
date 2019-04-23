node {
	
	stage('mvn package to create .war'){
		sh 'mvn package'
	}
		
	stage('Build Application Docker'){
		sh 'docker build -t project .'
	}

	stage('Build Database Docker'){
		sh 'docker build -t projectmysql -f mysql.Dockerfile .'
	}

	stage('Compose up'){
		sh 'docker-compose up'
	}
	
}
