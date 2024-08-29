## Comandos básicos

### Agregar un Repositorio Helm
```bash
helm repo add <nombre_repo> <URL_repo>
```

### Actualizar Repositorios
```bash
helm repo update
```

### Buscar Chart en Repositorios
```bash
helm search repo <nombre_chart>
```

### Instalar un Chart
```bash
helm install <nombre_release> <nombre_chart>
```

### Listar Releases Instalados
```bash
helm list
```
### Desinstalar un Release

```bash
helm uninstall <nombre_release>
```

### Verificar la Configuración del Chart

```bash
helm show values <nombre_chart>
```

### Actualizar un Release

```bash
helm upgrade <nombre_release> <nombre_chart>
```