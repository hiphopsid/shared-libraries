def call(){
     withKubeConfig(credentialsId: 'new-kubeconfig', namespace: '') {
      bat 'kubectl apply -f Deployment-beta.yaml -n dev'
    }
}
