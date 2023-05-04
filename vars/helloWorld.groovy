// def checkout(branch,ssh){
//  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
// userRemoteConfigs: [[credentialsId: 'admingithub', url: '${ssh}']]])
// }
def call(branch,ssh){
  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
            userRemoteConfigs: [[credentialsId: 'admingithub', url: '${ssh}']]])
}

