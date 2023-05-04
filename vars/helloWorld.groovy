def call(branch,ssh){
  checkout([$class: 'GitSCM', branches: [[name: branch ]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
            userRemoteConfigs: [[credentialsId: 'b4f7364e-adde-475e-b024-2d20667e0987', url: ssh ]]])
}

def buildImage(image) {
   withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
   sh 'docker build -t image .'
   sh 'docker push image'
}

