#!/usr/bin/env python

'''
Following program demonstrates nested dictionary access techniques.

Output (python nested_dictionary.py)
------

{'Second': {'Second_1': 'Second_1_1', 'Second_2': 'Second_2_1'}, 'First': {'First_1': 'First_1_1', 'First_2': 'First_2_1'}}
First_2_1
First_1_1
Second_2_1


__author__ = "pyav"
'''

# Define dictionary
a = {
        "First": {
                        "First_1": "First_1_1",
                        "First_2": "First_2_1"
                 },
        "Second": {
                        "Second_1": "Second_1_1",
                        "Second_2": "Second_2_1"
                  }
    }

'''
The above nested dictionary members can be accessed as follows:
    1. a
    2. a.get("server1").get("action1_2")
    3. a.get("server1")["action1_1"]
    4. a["server2"]["action2_2"]
'''

# Access members
print a
print a.get("First").get("First_2")
print a.get("First")["First_1"]
print a["Second"]["Second_2"]

