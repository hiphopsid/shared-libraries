// def checkout(branch,ssh){
//  checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg:  [], \
// userRemoteConfigs: [[credentialsId: 'admingithub', url: '${ssh}']]])
// }
def helloWorld(m==null){
 script{
 sh '''echo "hello world"'''
 }
}
