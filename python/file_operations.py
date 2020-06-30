#!/usr/bin/env python

with open("test_file.txt", "r") as f:
    data = f.read()
    f.close()

data=data.replace("Anand", "pyav")

with open("new_test_file.txt", "w") as f:
    f.write(data)
    f.close()


