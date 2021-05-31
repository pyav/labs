#!/usr/bin/python

def is_list_subset(list1, list2):
    map = {}
    for i in list1:
        map.update({i: False})
    count = 0
    count1 = len(list1)
    for i in list2:
        if (map.has_key(i)):
            count = count+1
            if (count == count1):
                return True
    return False

if __name__ == '__main__':
    list1 = [1, -2, 3]
    list2 = [-2, 3, 1]
    print(is_list_subset(list1, list2))
    list3 = ["one", "two", "three"]
    list4 = ["one", "two", "four"]
    print(is_list_subset(list3, list4))
    


'''
list3 = [1,2,3]
list3 = [s1, s2 ,s3]
s1= struct{...}

[list3, list4, list5]
'''
