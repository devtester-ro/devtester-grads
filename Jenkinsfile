node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/devtester-ro/devtester-grads.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'M3'

        // Get the JDK also for building Java Apps
        env.JAVA_HOME="${tool 'jdk-8'}"
        env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"

    }
    stage('Build') {
        sh "'${mvnHome}/bin/mvn' clean install -DskipTests"
    }

    stage('Run Application') {
        sh "'${mvnHome}/bin/mvn' spring-boot:run &"
        sleep(30)
    }

    stage('Run Automation') {
        sh "'${mvnHome}/bin/mvn' test"
    }

    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.jar'
    }
}