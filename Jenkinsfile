node {
	
	stage('Build') {
		stage 'create .war'
		sh 'mvn package'
		stage 'build application docker'
		sh 'docker build -t project .'
		stage 'build database docker'
		sh 'docker build -t projectmysql -f mysql.Dockerfile .'
	}
	stage('Test') {
		stage 'compose up'
		sh 'docker-compose up -d'
		stage 'test'
		sh 'echo "Hello World !"'
		sh 'sleep 3'
		stage 'compose down'
		sh 'docker-compose down'
	}
}
