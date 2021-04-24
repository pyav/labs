#!/usr/bin/env python

'''
__author__ = pyav

Output [Content of a.json after executing this python script]
------
{
    "a": {
        "Second": {
            "Second_1": "Second_1_1", 
            "Second_2": "Second_2_1"
        }, 
        "Third": {
            "Third_1": "Third1_1", 
            "Third_2": "Third_2_1"
        }, 
        "First": {
            "First_1": "First_1_1", 
            "First_2": "First_2_1"
        }
    }
}
'''

import json

with open("a.json") as f:
    json_loaded_file = json.load(f)
    f.close()

val = json_loaded_file["a"]["newkey"]
json_loaded_file["a"].pop("newkey")
json_loaded_file["a"].update(val)

with open("a.json", "w") as f:
    json.dump(json_loaded_file, f, indent=4)
    f.close()

