import os
import platform
import shutil

print("Show this dir")
current_dir = os.getcwd()
print(current_dir)

print("\nList of files")
files = sorted(os.listdir(current_dir), key=lambda x: os.path.getmtime(os.path.join(current_dir, x)))
for file in files:
    file_path = os.path.join(current_dir, file)
    file_size = os.path.getsize(file_path)
    file_mtime = os.path.getmtime(file_path)
    print(f"{file_size:10} bytes  {file_mtime:10.0f}  {file}")

print("\nSize this dir")
total, used, free = shutil.disk_usage(current_dir)
print(f"Total: {total // (2**30)} GB")
print(f"Used: {used // (2**30)} GB")
print(f"Free: {free // (2**30)} GB")

print("\nShow Linux version")
linux_version = platform.uname()
print(f"{linux_version.system} {linux_version.release} {linux_version.version}")
