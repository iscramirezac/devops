# Instalar Kubernetes

## Minikube docs

Los datos de instalación se pueden consultar aquí: [https://minikube.sigs.k8s.io/docs/start](https://minikube.sigs.k8s.io/docs/start) y [https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/](https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/)

## Instalación de Minikube

Para la instalación de Linux, x64 en modalidad binaria:

```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64
```

## Operaciones con Minikube

Iniciar Minikube:

```bash
minikube start
```

Detener Minikube:

```bash
minikube stop
```

Pausar Minikube:

```bash
minikube pause
```

Borrar los clúster en Minikube:

```bash
minikube delete --all
```

## Instalación de kubectl

Instalar kubectl, puede necesitar de sudo:
```bash
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
```

Dar permisos a kubectl:
```bash
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

Verificar instalación:
```bash
kubectl version --client
```

