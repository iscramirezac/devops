#!/bin/bash
echo "Show this dir"
pwd

echo "List of files"
ls -larth .

echo "Size this dir"
df -h .

echo "Show linux version"
LINUX_VERSION = $(uname -a)
echo $LINUX_VERSION