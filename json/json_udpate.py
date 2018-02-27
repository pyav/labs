#!/usr/bin/env python

'''
__author__ = pyav

Output [Content of a.json after executing this python script]
------
{
    "a": {
        "newkey": {
            "Third": {
                "Third_1": "Third1_1", 
                "Third_2": "Third_2_1"
            }
        }, 
        "Second": {
            "Second_1": "Second_1_1", 
            "Second_2": "Second_2_1"
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

new_entry = {"Third": {"Third_1": "Third1_1", "Third_2": "Third_2_1"}}
#json_loaded_file["a"].update(new_entry)
a = json_loaded_file["a"]
a["newkey"] = new_entry

with open("a.json", "w") as f:
    json.dump(json_loaded_file, f, indent=4)
    f.close()

