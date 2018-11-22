#!/bin/bash

cur_dir=$(pwd)  #此处应为项目文件所在目录
echo "at $cur_dir,run jar with JVM"

java -jar $cur_dir/output/ktweb.jar
