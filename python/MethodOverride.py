'''
Following program shows method override.

Output
------
MyClass
MyClass2
MyClass3


Created on 02-Aug-2018

@author: pyav
'''

class MyClass(object):
    '''
    classdocs
    '''
    def __init__(self):
        '''
        Constructor
        '''
    
    def func(self):
        print(type(self).__name__)
        
class MyClass2(MyClass):

    def __init__(self):
        MyClass.__init__(self)
    
    def func(self):
        print(type(self).__name__)
        
class MyClass3(MyClass):
    
    def __init__(self):
        MyClass.__init__(self)
    
    def func(self):
        print(type(self).__name__)
        

obj1 = MyClass()
obj2 = MyClass2()
obj3 = MyClass3()

obj1.func()
obj2.func()
obj3.func()

