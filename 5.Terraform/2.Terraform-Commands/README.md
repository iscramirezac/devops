## Estructura
```bash
.
├── main.tf
├── variables.tf
├── outputs.tf
├── terraform.tfvars
├── provider.tf
├── modules/
│   └── example_module/
│       ├── main.tf
│       ├── variables.tf
│       └── outputs.tf
├── environments/
│   ├── dev/
│   │   └── terraform.tfvars
│   └── prod/
│       └── terraform.tfvars
└── .terraform/
    └── ... (archivos internos generados por terraform init)

```

## Comandos Básicos de Terraform

### Inicializar un Proyecto
```bash
terraform init
```

### Planificar Cambios
```bash
terraform plan
```

### Aplicar Cambios
```bash
terraform apply
```

### Ver Estado Actual
```bash
terraform show
```

### Eliminar Infraestructura
```bash
terraform destroy
```




