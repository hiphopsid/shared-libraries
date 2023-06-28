import java.nio.file.Files
import java.nio.file.Paths

def call(String name, String ssh){
  checkout([$class: 'GitSCM', branches: [[name: name ]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
            userRemoteConfigs: [[credentialsId: 'jenkins', url: ssh ]]])
}


def readVariables(String fileName)
{
  println("Reading Variables...")
  if(fileName.contains(".properties"))
  {
    props = readProperties file: "${fileName}"
  }

  else if(fileName.contains(".yaml"))
  {
    props = readYaml file: "${fileName}"
  }
  else if (fileName.contains(".env")) 
  {
    def fileLines = Files.readAllLines(Paths.get(fileName))
    println 'fileName lines are' + fileLines
    fileLines.each { line ->
      // Skip empty lines or lines starting with #
      if (line.trim().isEmpty() || line.startsWith("#")) {
        return
      }

      def parts = line.split("=")
      if (parts.size() == 2) {
        def key = parts[0].trim()
        def value = parts[1].trim()
        props[key] = value
      }
    }
  } 
  else
  {
    error("File for storing SDP properties must end in .properties or .yaml. The filename is: " + "${fileName}")
  }
  println 'Properties pased in are: ' + props
  return props
}

// def buildImage(image) {
//   echo "${image}"
// }

// def buildImage(String image, String application_name) {
//    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'docker_user', passwordVariable: 'docker_pass')]) {
//     bat """
//     docker image build -f Dockerfile -t my-app-image .
//     docker login -u ${docker_user} -p ${docker_pass}"
//     docker push hiphopsid/${application_name}
//     """
//      echo "${image}"
// //      sh "docker build -t ${image} ."
// //      sh "docker login -u ${docker_user} -p ${docker_pass}"
// //    sh "docker push ${image}"
// }
// }
// def deployment(){
//      withKubeConfig(credentialsId: 'new-kubeconfig', namespace: '') {
//       bat 'kubectl apply -f Deployment-beta.yaml -n dev'
//     }
// }


