#!/usr/bin/env python

"""
 Following program is used to demonstrate the check for inconsistencies in
 tabs and spaces. 

 __author__ = "pyav"

 Output
 ------

 python -m tabnanny -v tabs_space_mix.py 
 'tabs_space_mix.py': *** Line 21: trouble in tab city! ***
 offending line: '\t\tprint False\n'
 indent not greater e.g. at tab sizes 1, 2

"""

if 0 == 1:
    print True
		print False
else:
    print False

