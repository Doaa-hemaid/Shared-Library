def call(openshiftServer, openshiftProject, dockerImage, credentialId) {
    withCredentials([usernamePassword(credentialsId: credentialId, usernameVariable: 'OPENSHIFT_USER', passwordVariable: 'OPENSHIFT_PASSWORD')]) {
        sh """
            # Log in to OpenShift with username and password
            oc login ${openshiftServer} --username=${OPENSHIFT_USER} --password=${OPENSHIFT_PASSWORD} --insecure-skip-tls-verify
            
            # Switch to the target project
            oc project ${openshiftProject}

            # Create a deployment
            oc create deployment my-app --image=${dockerImage}
        """
    }
}
