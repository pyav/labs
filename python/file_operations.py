#!/usr/bin/env python

with open("/Users/aanverma/Desktop/labs/python/test_file.txt", "r") as f:
    data = f.read()
    f.close()

data=data.replace("Anand", "pyav")

with open("/Users/aanverma/Desktop/labs/python/new_test_file.txt", "w") as f:
    f.write(data)
    f.close()
