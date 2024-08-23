#!/bin/bash
fecha=$(date +%d-%m-%Y)
hora=$(date +%H:%M)

echo "Ingrese su nombre:"
read nombre
echo "Hola $nombre, son las $hora y la fecha es $fecha"