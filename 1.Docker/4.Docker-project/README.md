## Introducción
Un proxy inverso Nginx HTTPS es un servicio de proxy intermediario que toma una solicitud del cliente, la pasa a uno o más servidores y, posteriormente, devuelve la respuesta del servidor al cliente. Si bien la mayoría de las aplicaciones comunes pueden ejecutarse como servidor web por sí mismas, el servidor web Nginx puede proporcionar una serie de funciones avanzadas, como balanceo de carga, capacidades TLS/SSL y aceleración de las que carecen la mayoría de las aplicaciones especializadas.

La configuración de un proxy inverso HTTPS de Nginx tiene ventajas significativas: 
- Equilibrio de carga: un proxy inverso de Nginx puede realizar un equilibrio de carga, lo que ayuda a distribuir las solicitudes de los clientes de manera uniforme entre los servidores back-end. También mejora la redundancia. Si un servidor deja de funcionar, el proxy inverso redirige las solicitudes a un servidor diferente de acuerdo con la política de enrutamiento. 
- Mayor seguridad: un proxy inverso de Nginx también actúa como una línea de defensa para sus servidores backend. La configuración de un proxy inverso garantiza que la identidad de sus servidores backend permanezca desconocida. 
- Mejor rendimiento: Nginx funciona mejor al entregar archivos de contenido estático y analizar URL. 
- Fácil registro y auditoría: dado que solo hay un único punto de acceso cuando se implementa un proxy inverso Nginx, el registro y la auditoría se vuelven mucho más simples. 
- Conexión cifrada Al cifrar la conexión entre el cliente y el proxy inverso Nginx con TLS, los usuarios se benefician de una conexión HTTPS cifrada y segura, que protege sus datos.

## Diagrama del Proyecto
El proyecto consta del siguiente diagrama:
![Alt text](<Diagram.png>)

## Consideraciones
Cada sitio es un contenedor:

- Servidor Nginx Reverse Proxy
	- Configuración de Reverse proxy y proxy_pass
- Servidor Nginx + HTML
	- Tiene que tener instalado Nginx y tener un sitio web génerico o plantilla de HTML
	- El sitio deberá estar publicado en el puerto 80
- Servidor Apache2 + HTML
	- Tiene que tener instalado Apache2 y tener un sitoi web génerico o plantilla de HTML
	- El sitio deberá estar publicado en el puerto 80

## Pruebas

Desde cualquier cliente (Navegador web, Curl, etc), se harán peticiones para los sitios:
- sitio1.example.com
- sitio2.example.com

El reverse proxy dirigirá las peticiones a los Servidores correspondientes.

Nota: No será necesario tener un servidor DNS activo, solo con agregar la ip del reverse proxy a los /etc/hosts.
