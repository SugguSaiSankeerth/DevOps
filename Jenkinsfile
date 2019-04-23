node {
	
	stage('Build') {
		stage 'create .war'
		sh 'mvn package'
		stage 'build application docker'
		sh 'docker build -t project .'
		stage 'build database docker'
		sh 'docker build -t projectmysql -f mysql.Dockerfile .'
	}
	stage('Deploy') {
		stage 'compose up'
		sh 'docker-compose up'
	}
}
