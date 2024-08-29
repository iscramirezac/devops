# Comandos Básicos

### Ejecución de un playbook
```bash
ansible-playbook playbook.yml
```

### Verificación de Configuración
```bash
ansible-inventory --list -y
```

### Ejecución de Tareas en Hosts
```bash
ansible <hostname o grupo> -m command -a "uptime"
```

### Gestión de Playbooks
```bash
Copiar código
ansible-playbook playbook.yml --syntax-check
```

### Ejecución modo Verbose

```bash
ansible-playbook playbook.yml -v
```