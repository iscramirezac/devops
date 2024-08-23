# Instalar Jenkins

## Crea tú propia imagen de Jenkins con docker y docker-compose incluídos

Crea un archivo que se llame Jenkins_Dockerfile y pon este contenido:
```bash
FROM jenkins/jenkins:2.452.1-jdk17
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli
RUN curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean docker-workflow"
```

Crea una imagen de docker a partir del previo Dockerfile:
```bash
docker build -t myjenkins:v2.452.1-1 -f Jenkins_Dockerfile .
```

Crear una network para que se puedan comunicar los contenedores de Jenkins:
```bash
docker network create jenkins
```

Levantar un contenedor el cual tiene cargado una instancia de Docker in Docker(docker:dind):

```bash
docker run \
  --name jenkins-docker \
  --detach \
  --privileged \
  --network jenkins \
  --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume jenkins-docker-certs:/certs/client \
  --volume jenkins-data:/var/jenkins_home \
  --publish 2376:2376 \
  docker:dind \
  --storage-driver overlay2
```
Levantar un contenedor del servidor máster de Jenkins:
```bash
docker run \
  --name jenkins \
  --restart=on-failure \
  --detach \
  --network jenkins \
  --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client \
  --env DOCKER_TLS_VERIFY=1 \
  --publish 8080:8080 \
  --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  myjenkins:v2.452.1-1
```
Obtener la password inicial desde el contenedor de jenkins máster:
```bash
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```
Un ejemplo de un output de la initialAdminPassword:
```bash
2bf16818b1474f6fb867cfae52c57e73
```