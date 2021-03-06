#!/bin/bash

FOLDER=$1
FILE=$2

cd $FOLDER
echo "Compiling..."
javac $FILE.java

if test -f "$FILE.class";
then
    echo "Compiled succesfully! Executing:"
    # Use JVM to interprete bytecode (.class file)
    java $FILE
    # Delete the .class file generated by the java compiler
    rm "$FILE.class"
else 
    echo "There was an error compilling .java file"
fi