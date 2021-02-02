### Backend Service
- Dockerfile is built _bootJar_ task based on the provided Dockerfile template file
- Dockerfile is layered according to Spring docs https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-layering-docker-images
- Build an image calling
    ```
    cd ./backend-service
    docker build -t backend-service .
    ```

### HTTP Service
- Image is created using _bootBuildImage_ task (invoked autmatically inside _bootJar_)