#!/bin/bash

ITEMS="One Two Three"
for item in ${ITEMS}
do
    echo ${item}
    echo
done


ITEMS="One,Two,Three"
echo ${ITEMS}
ITEMS=$(echo ${ITEMS}|sed "s/,/ /g")
for item in ${ITEMS}; do
    echo ${item}
done


