#!/usr/bin/env python

################################################################################
# Following program is a simple game to rearrange numbers from 0 through 8 so
# that the pattern becomes as follows:
#
# 0 1 2
# 3 4 5
# 6 7 8
#
# 
# Allowed moves
# -------------
#
# The input when the prompt for 'Enter move:' comes can be any number between 1
# through 8 and that number will be exchanged in position with that of 0. There
# is no directional constraints i.e. diagonal exchanges are allowed currently.
# 
# Further enhancements
# --------------------
#
#   1. Allow only distance 1 grid exchanges: left-right & top-bottom with 0.
#   2. No diagonal exchanges.
#   2. Random positional display initially.
#   3. Better exception handling.
#
#
# Author: @pyav
################################################################################

list = [3, 5, 4, 1, 0, 2, 6, 7, 8]

def print_list(list):
	for i in range(3):
		print list[i],
	print

	for i in range(3,6):
		print list[i],
	print

	for i in range(6,9):
		print list[i],

def change_list(list, number):
	index_zero = list.index(0)
	index_number = list.index(number)
	temp = list[index_zero]
	list[index_zero] = list[index_number]
	list[index_number] = temp

def check_all(list):
  i = 0
  for j in range(9):
    if (list[i] != j):
      return -1
    i += 1
  return 0

while True:
  print_list(list)
  print
  number = int(raw_input("Enter move: "))

  change_list(list, number)

  if (0 == check_all(list)):
    print_list(list)
    print
    print "DONE!"
    break

