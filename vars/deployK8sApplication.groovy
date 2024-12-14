def call(String namespace, String dockerImage, String k8sCredentials, String minikubeIp) {
    withCredentials([string(credentialsId: k8sCredentials, variable: 'api_token')]) {
        // Define the common kubectl command prefix
        def kubectlCommand = "kubectl --token $api_token --server https://${minikubeIp}:8443 --insecure-skip-tls-verify=true"

        sh """
            ${kubectlCommand} apply -f myapp.yaml
            ${kubectlCommand} get deployments -n ${namespace}
            ${kubectlCommand} get services -n ${namespace}
            
        """
    }
}
