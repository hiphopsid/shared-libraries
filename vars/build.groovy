def call(String image, String branch) {
   // withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'docker_user', passwordVariable: 'docker_pass')]) {
   if (branch == "master") {
    bat """
    docker image build -f Dockerfile -t ${image}:$BUILD_NUMBER .
    """
   }
   else
   {
    println "Please use master branch for docker build instead of " + branch
   }
//      sh "docker build -t ${image} ."
//      sh "docker login -u ${docker_user} -p ${docker_pass}"
//    sh "docker push ${image}"
}
