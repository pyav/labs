#!/bin/bash

common_part="ls -l;"
main_cmd="df -h"

final_cmd="${common_part} ${main_cmd} && ls -l"
echo "${final_cmd}"

echo ${final_cmd}.abc
