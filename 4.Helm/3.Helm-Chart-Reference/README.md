# Estructura de Helm Chart

### Árbol de estructura

```bash
mychart/
├── Chart.yaml          # Metadata del Chart
├── values.yaml         # Valores predeterminados
├── templates/          # Directorio de templates
│   ├── deployment.yaml # Template de Kubernetes Deployment
│   ├── service.yaml    # Template de Kubernetes Service
│   └── NOTES.txt       # Notas de instalación
└── README.md           # Documentación del Chart
```

### Ejemplo de values.yaml

```bash
image:
  repository: nginx
  tag: "1.21.6"
  pullPolicy: IfNotPresent

replicaCount: 2

resources:
  limits:
    cpu: 100m
    memory: 128Mi
  requests:
    cpu: 50m
    memory: 64Mi

service:
  type: ClusterIP
  port: 80

app:
  name: myapp
  label: app
```

### Ejemplo de template/deployment

```bash
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Values.app.name }}-deployment
  labels:
    {{ .Values.app.label }}: {{ .Values.app.name }}
spec:
  replicas: {{ .Values.replicaCount }}
  selector:
    matchLabels:
      {{ .Values.app.label }}: {{ .Values.app.name }}
  template:
    metadata:
      labels:
        {{ .Values.app.label }}: {{ .Values.app.name }}
    spec:
      containers:
        - name: {{ .Values.app.name }}
          image: "{{ .Values.image.repository }}:{{ .Values.image.tag }}"
          imagePullPolicy: {{ .Values.image.pullPolicy }}
          ports:
            - containerPort: {{ .Values.service.port }}
          resources:
            limits:
              cpu: {{ .Values.resources.limits.cpu }}
              memory: {{ .Values.resources.limits.memory }}
            requests:
              cpu: {{ .Values.resources.requests.cpu }}
              memory: {{ .Values.resources.requests.memory }}
```

### Ejemplo de template/service

```bash
apiVersion: v1
kind: Service
metadata:
  name: {{ .Values.app.name }}-service
spec:
  type: {{ .Values.service.type }}
  selector:
    {{ .Values.app.label }}: {{ .Values.app.name }}
  ports:
    - port: {{ .Values.service.port }}
      targetPort: {{ .Values.service.port }}
```

### Instalación de Helm Chart

```bash
helm install my_release ./my_chart
```