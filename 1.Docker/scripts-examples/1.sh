#!/bin/bash
DIRECTORY="$HOME/Desktop"
echo "Archivos modificados en los últimos 7 días en $DIRECTORY:"
find $DIRECTORY -type f -mtime -7