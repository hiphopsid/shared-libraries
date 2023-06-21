def call(String image) {
   // withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'docker_user', passwordVariable: 'docker_pass')]) {
    bat """
    docker image build -f Dockerfile -t ${image}:$BUILD_NUMBER .
    """
//      sh "docker build -t ${image} ."
//      sh "docker login -u ${docker_user} -p ${docker_pass}"
//    sh "docker push ${image}"
}
