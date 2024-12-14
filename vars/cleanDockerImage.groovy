def cleanDockerImage(String dockerImage) {
    sh """
            docker rmi ${dockerImage} || true
      """

}
