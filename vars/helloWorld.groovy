// def checkout(branch,ssh){
//  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
// userRemoteConfigs: [[credentialsId: 'admingithub', url: '${ssh}']]])
// }
def call(branch,ssh){
  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
            userRemoteConfigs: [[credentialsId: 'b4f7364e-adde-475e-b024-2d20667e0987', url: '${ssh}']]])
}

