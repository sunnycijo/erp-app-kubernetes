# erp-app-kubernetes
#### kubectl commands
###### Prints the version of kubectl
```
kubectl version
```
###### Creates DEPLOYMENT, REPLICASET, PODS
```
kubectl create deployment hello-world-rest-api --image=cijosunny/hello-world-rest-api:0.0.1.SNAPSHOT
kubectl create deployment [name_of_deployment] --image=[docker_hub_repository]/[image_name]:[image_version]
```
###### Creates SERVICE
```
kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
kubectl expose deployment [name_of_deployment] --type=[ClusterIP/NodePort/LoadBalancer/ExternalName] --port=8080
```
More on service types [Service Types](https://kubernetes.io/docs/concepts/services-networking/service/#publishing-services-service-types)

###### Scale DEPLOYMENT
```
kubectl scale deployment hello-world-rest-api --replicas=3 
kubectl scale deployment [name_of_deployment] --replicas=[number_of_replicas] 
```

###### Delete a POD
```
kubectl delete pod hello-world-rest-api-58ff5dd898-6219d
kubectl delete pod [pod_name]
```

###### Auto scale deployment
```
kubectl autoscale deployment hello-world-rest-api --max=10 --cpu-percent=70
kubectl autoscale deployment [name_of_deployment] --max=10 --cpu-percent=70
```

###### Edit deployment
```
#Method 1
kubectl edit deployment hello-world-rest-api
kubectl edit deployment [name_of_deployment]
# do some edit in vi editor in command line and esc>>wq!+enter button

#Method 2
kubectl get deployment my-nginx -o yaml > /tmp/nginx.yaml
vi /tmp/nginx.yaml
# do some edit, and then save the file

kubectl apply -f /tmp/nginx.yaml
deployment.apps/my-nginx configured

rm /tmp/nginx.yaml
```
###### Get all events
```
kubectl get events
```

###### Get all details about PODS
```
kubectl get pods
kubectl get pods -o wide
kubectl explain pods
```

###### Get all details about REPLICASET
```
kubectl get replicaset
kubectl get rs
kubectl get rs -o wide
```

###### Get all details about DEPLOYMENT
```
kubectl get deployment
```

###### Get all details about SERVICE
```
kubectl get service
kubectl get svc
```

###### Do a release to new version
```
kubectl set image deployment hello-world-rest-api hello-world-rest-api=cijosunny/hello-world-rest-api:0.0.2.SNAPSHOT
kubectl set image deployment [name_of_deployment] [name_of_container]=[docker_hub_repository]/[image_name]:[image_version]

#Creates 2 replicasets and will perform ROLLING UPDATE(1 new pod with new image will be deployed, 1 old pod with old image will be terminated)
1 with old image cijosunny/hello-world-rest-api:0.0.1.SNAPSHOT
1 with new image cijosunny/hello-world-rest-api:0.0.2.SNAPSHOT

```

###### Prints health status of master node
```
kubectl get componentstatuses
#Prints health status of  master nodes
	* etcd-0
	* controller-manager
	* scheduler
	* etcd-1
```

###### Export DEPLOYMENT & SERVICE configuration to external file
```
kubectl get deployment hello-world-rest-api -o yaml > deployment.yaml
kubectl get service hello-world-rest-api -o yaml > service.yaml

#make changes in yaml file and
kubectl apply -f deployment.yaml

#Good approach is to combine both deployment.yaml and service.yaml into same file
```

###### Delet DEPLOYMENT,REPLICASET,SERVICE,POD with label associated
```
kubectl delete all -l app=hello-world-rest-api
```
