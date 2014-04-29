#!/bin/bash

# new.sh
# usage: new.sh <Name>
# purpose: to create a new stub plugin.

plugin=`echo "${1^}"` 

echo "+++ copy template..."
cp -R template $plugin

echo "+++ create bin folder and bin/Pakcage..."
mkdir $plugin/bin
mkdir $plugin/bin/$plugin

echo "+++ renaming template .java file..."
mv $plugin/template.java $plugin/$plugin.java

echo "end of script"
