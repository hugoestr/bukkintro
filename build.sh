#!/bin/bash

# build.sh 
# usage: ./build.sh <name of plugin>

echo "+++ compiling..."
javac -Xlint -classpath ../craftbukkit.jar $1/$1.java

echo "+++ moving .class file to bin/PACKAGE ..."
mv $1/$1.class $1/bin/$1

echo "+++ copying plugin yml file to bin ..."
cp $1/plugin.yml $1/bin

echo "+++ creating jar file..."
jar -cvf $1/$1.jar -C $1/bin . 

echo "+++ copying jar file to plugins folder ..."
cp $1/$1.jar ../plugins

echo "end of script"
