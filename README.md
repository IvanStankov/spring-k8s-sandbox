### Subprojects
#### Backend Service
- Dockerfile is created in _bootJar_ task based on the provided Dockerfile.base file
- Dockerfile is layered according to Spring docs https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-layering-docker-images
- Build an image calling (invoked automatically inside _bootJar_)
    ```
    cd ./backend-service
    docker build -t backend-service .
    ```

#### Http Service
- Image is created using _bootBuildImage_ task (invoked automatically inside _bootJar_)


### Running the whole project
#### Required:
- Java 11
- Gradle 6.3
- Docker
- Kubernetes
#### Commands
##### Kubernetes
```
gradle clean build
kubectl apply -f http-service/http-service-manifest.yml ^
              -f backend-service/backend-service-manifest.yml
kubectl delete -f http-service/http-service-manifest.yml ^
              -f backend-service/backend-service-manifest.yml
```
##### Helm
```
helm install sks-app ./helm-chart
helm uninstall sks-app
```