#!/bin/sh

array=(/A/B
       /B/C
       /C/D)
index=0
while [ $index -lt 3 ]
do
    echo $index
    echo
    echo ${array[$index]}
    echo
    index=$((index+1))
done
echo

echo "array length=${#array[@]}"
