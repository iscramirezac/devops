# Git

## Introducción

Git es un sistema de control de versiones distribuido, ampliamente utilizado para gestionar el código fuente en proyectos de software. Permite a los desarrolladores colaborar, mantener un historial de cambios y revertir a versiones anteriores del código.

## Comando Básicos

### Configuración Inicial

Ingresar tus datos:

```bash
git config --global user.name "Nombre"
git config --global user.email "nombre@nombre.com"
```

### Clonar Repositorios

Para clonar repositorios:

```bash
git clone <url_del_repositorio>
```

### Crear un Repositorio de Git

Para crear un repositorio:

```
git init
```

### Ver estado del Repositorio

Ver que archivos están modificados, rastreados, o nuevos.

```
git status
```

### Agregar archivos al área de Staging

Añadir uno, varios o todos los archivos al área de Staging

```
git add <nombre_del_archivo>
```

Agregar todos los archivos:

```
git add .
```

### Confirmar cambios

Para confirmar los cambios que se han agregado en el área de Staging:

```bash
git commit -m "Mensaje corto con descripción del cambio"
```

### Sincronización con Repositorios Remotos

Descargar cambios:

```bash
git pull origin <rama>
```

Para enviar cambios a repositorio remoto:

```bash
git push origin <rama>
```

## Ramas

### Crear rama

Crear una nueva rama y posicionarse en ella:
```bash
git checkout -b <nombre_de_la_rama>
```

### Listar ramas

Listar las ramas en el repositorio local:
```bash
git branch
```

### Cambiar entre ramas locales

Cambiar a otra rama:
```bash
git checkout <nombre_de_la_rama>
```


### Eliminar una rama local

Eliminar una rama:
```bash
git branch -d <nombre_de_la_rama>
```

## Workflow Básico de Git

1. Clonar el Repositorio
2. Crear una Rama
3. Hacer Cambios
4. Agregar los Cambios al Área de Staging
5. Confirmar los Cambios (commit)
6. Sincronizar Cambios
7. Enviar Cambios al Repositorio Remoto