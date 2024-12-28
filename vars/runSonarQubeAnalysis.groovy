def call(sonarEnv) 
{ 
  withSonarQubeEnv(sonarEnv) 
  {
    sh './gradlew sonar'
  }
} 
