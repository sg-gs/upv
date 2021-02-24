#!/bin/bash

for f in *.java; do
  javac $f
done

java PPool