// def checkout(branch,ssh){
//  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
// userRemoteConfigs: [[credentialsId: 'admingithub', url: '${ssh}']]])
// }
def call(m){
 script{
  sh '''echo "hello ${m} world"'''
 }
}
