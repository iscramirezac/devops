# Instalar Helm

## Helm Docs

Los datos de instalación se pueden consultar aquí: [https://helm.sh/docs/intro/install/](https://helm.sh/docs/intro/install/)

## Instalación de Helm

Para la instalación de Linux x64 desde los archivos binarios.

```bash
curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh
```

Verificar instalación:
```bash
helm version
```