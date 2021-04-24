#!/usr/bin/env python3

'''
__author__ = pyav

Output
------
first
Inside class C, first

'''

class A:
    def first(self):
        return "first"

class B:
    def second(self):
        print(A().first())

B().second()

class C():
    def __init__(self):
        self.objA = A()
    def third(self):
        print('Inside class C, ' + self.objA.first())

# __init__ gets into action
C().third()
