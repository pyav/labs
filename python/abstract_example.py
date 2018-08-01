'''
Following program shows the use of @abstractmethod annotation. 

Output
------
Constructor - MyClass for SubFirst
Constructor - MyClass for SubSecond
inside class: SubFirst
inside class: SubSecond


Created on 01-Aug-2018

@author: pyav
'''
from abc import abstractmethod

class MyClass(object):
    '''
    classdocs
    '''
    def __init__(self):
        '''
        Constructor
        '''
        print("Constructor - MyClass for "+ type(self).__name__)
        
    @abstractmethod
    def print_class(self):
        pass

    def caller_func(self):
        self.print_class()
    
class SubFirst(MyClass):
    def __init__(self):
        MyClass.__init__(self)
    
    def print_class(self):
        print("inside class: " + type(self).__name__)
        
class SubSecond(MyClass):
    def __init__(self):
        MyClass.__init__(self)
    
    def print_class(self):
        print("inside class: " + type(self).__name__)
        
objFirst = SubFirst()
objSecond = SubSecond()

objFirst.caller_func()
objSecond.caller_func() 
