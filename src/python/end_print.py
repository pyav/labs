#!/usr/bin/env python3

'''
__author__ = 'pyav'

Output
------
1,1,2,3,5,8,13,21,34,55,

'''

a, b = 0, 1

for i in range(10):
    print(b, end=',')
    a, b = b, a+b
