import os
import time

directory = os.path.expanduser("~/Desktop")

current_time = time.time()

print(f"Archivos modificados en los últimos 7 días en {directory}:")

for root, dirs, files in os.walk(directory):
    for file in files:
        file_path = os.path.join(root, file)
        file_mtime = os.path.getmtime(file_path)
        if current_time - file_mtime < 7 * 86400:
            print(file_path)
