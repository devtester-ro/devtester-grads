node {
    def mvnHome
    stage('Preparation') {
        // Get some code from a GitHub repository
        git 'https://github.com/devtester-ro/devtester-grads.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'M3'

        // Set JDK env variable and add it to path
        env.JAVA_HOME = "${tool 'jdk-8'}"
        env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"

    }
    stage('Build') {
        sh "'${mvnHome}/bin/mvn' clean install -DskipTests"
    }

    stage('Run Application') {
        sh "'${mvnHome}/bin/mvn' spring-boot:run &"
        sleep(30) //seconds not milliseconds like IntelliJ states
    }

    stage('Run Automation') {
        try {
            sh "'${mvnHome}/bin/mvn' test"
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "\\output\\", reportFiles: 'DevTester-grads.html', reportName: 'HTML Test Report', reportTitles: ''])
        } catch (all) {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "\\output\\", reportFiles: 'DevTester-grads.html', reportName: 'HTML Test Report', reportTitles: ''])
        }
    }
}