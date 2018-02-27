#!/usr/bin/env python

'''
__author__ = pyav

Output
------
first

'''

class A:
    def first(self):
        return "first"

class B:
    def second(self):
        print A().first()

B().second()
