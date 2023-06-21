def buildImage(String image, String application_name) {
   // withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'docker_user', passwordVariable: 'docker_pass')]) {
    bat """
    docker image build -f Dockerfile -t my-app-image .
    // docker login -u ${docker_user} -p ${docker_pass}"
    // docker push hiphopsid/${application_name}
    """
     echo "${image}"
//      sh "docker build -t ${image} ."
//      sh "docker login -u ${docker_user} -p ${docker_pass}"
//    sh "docker push ${image}"
}
