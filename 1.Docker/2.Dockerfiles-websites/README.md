# Docker Sheet

## Módulo 1: Verificación de la Instalación de Docker

### 1\. Verificar si Docker está instalado
```bash
docker --version
```
Este comando muestra la versión de Docker instalada en el sistema.

### 2\. Verificar si Docker Engine está en ejecución

```bash
docker info
```
Este comando muestra información detallada sobre la configuración de Docker Engine y su estado actual.

### 3\. Verificar si se puede ejecutar contenedores


```bash
docker run hello-world
```
Este comando ejecuta un contenedor de prueba llamado `hello-world` para verificar que Docker pueda descargar imágenes y ejecutar contenedores correctamente.

### 4\. Verificar si Docker daemon está en ejecución

```bash
sudo systemctl status docker
```
Este comando muestra el estado del servicio Docker daemon en sistemas basados en systemd, como Ubuntu.

### 5\. Verificar si Docker daemon está en ejecución (en sistemas no basados en systemd)

```bash
sudo service docker status
```
Este comando muestra el estado del servicio Docker daemon en sistemas que no utilizan systemd, como CentOS 6.

## Módulo 2: Ciclo de Vida de Contenedor

### 1\. Crear un contenedor

```bash
docker run -d --name nombre_contenedor nombre_imagen
```

Este comando crea y ejecuta un contenedor en segundo plano (`-d`) con un nombre especificado (`--name`) a partir de una imagen.

### 2\. Detener un contenedor

```bash
docker stop nombre_contenedor
```
Este comando detiene un contenedor en ejecución.

### 3\. Iniciar un contenedor detenido

```bash
docker start nombre_contenedor
```
Este comando inicia un contenedor detenido.

### 4\. Eliminar un contenedor

```bash
docker rm nombre_contenedor
```
Este comando elimina un contenedor.

## Módulo 3: Imágenes de Docker

### 1\. Listar imágenes

```bash
docker images
```
Este comando lista todas las imágenes Docker en el sistema.

### 2\. Eliminar una imagen

```bash
docker rmi nombre_imagen
```
Este comando elimina una imagen Docker especificada.

### 3\. Descargar una imagen

```bash
docker pull nombre_imagen
```
Este comando descarga una imagen Docker desde un registro público o privado.

## Módulo 4: Creación de imágenes Docker

### 1\. Construir una imagen a partir de un Dockerfile

```bash
docker build -t nombre_imagen .
```
Este comando construye una nueva imagen Docker utilizando el Dockerfile en el directorio actual y le asigna un nombre (`-t`).

### 2\. Etiquetar una imagen

```bash
docker tag nombre_imagen nueva_etiqueta
```
Este comando etiqueta una imagen Docker existente con una nueva etiqueta.

### 3\. Subir una imagen a un registro

```bash
docker push nombre_imagen
```
Este comando sube una imagen Docker a un registro público o privado.

## Módulo 5: Redes en Docker

### 1\. Crear una red

```bash
docker network create nombre_red
```
Este comando crea una nueva red en Docker.

### 2\. Listar redes

```bash
docker network ls
```
Este comando lista todas las redes Docker en el sistema.

### 3\. Conectar un contenedor a una red

```bash
docker network connect nombre_red nombre_contenedor
```
Este comando conecta un contenedor existente a una red especificada.

## Módulo 6: Persistencia de Datos

### 1\. Crear un volumen

```bash
docker volume create nombre_volumen
```
Este comando crea un nuevo volumen Docker.

### 2\. Listar volúmenes

```bash
docker volume ls
```

Este comando lista todos los volúmenes Docker en el sistema.

### 3\. Montar un volumen en un contenedor

```bash
docker run -v nombre_volumen:/ruta/en/el/contenedor nombre_imagen
```
Este comando monta un volumen en un contenedor durante su ejecución.

## Módulo 7: Docker Compose

### 1\. Iniciar servicios definidos en el archivo docker-compose.yml

```bash
docker-compose up -d
```

Este comando inicia todos los servicios definidos en el archivo `docker-compose.yml` en segundo plano (`-d`).

### 2\. Detener y eliminar servicios

```bash
docker-compose down
```
Este comando detiene y elimina todos los servicios definidos en el archivo `docker-compose.yml`.

### 3\. Ver estado de los servicios

```bash
docker-compose ps
```
Este comando muestra el estado de los servicios definidos en el archivo `docker-compose.yml`.

## Módulo 8: Problemas Comunes

### 1\. Espacio en disco ocupado

```bash
docker system df
```
Este comando muestra el espacio utilizado por los diferentes componentes de Docker.

### 2\. Error de puerto en uso

```bash
sudo lsof -i -P -n | grep LISTEN
```
Este comando muestra los puertos en uso en el sistema y los procesos que los están utilizando.

### 3\. Error de permisos

```bash
sudo chown usuario:grupo /ruta/a/volumen_o_directorio
```
Este comando cambia el propietario y el grupo de un volumen o directorio para resolver problemas de permisos.