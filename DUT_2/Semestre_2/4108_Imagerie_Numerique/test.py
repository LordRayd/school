# -*- coding: utf-8 -*-
#%%
a = 3
print(a)
#%%
print("Hello World")
print('Hello World')
#%% List
s = [1, 2, 'age', 3.14]
print(s)
print(s[1]) #--2
print(s[-1])

#%% Tuple
s = (1, 2, 'age', 3.14)
s1= 1, 2, 'age', 3.14
print(s[1:])
print(s[:-1])

#%% dictionnaire hasMap
animal= {'nom':'gerafe','age':23}
print(animal['nom'])
print(animal.keys())

#%% range
print(range(5,10))
for i in range(5,80,5):
    print(i)

#%% if
for i in range(10):
    if (i % 2 == 0):
        print(str(i) + " est pair")
    else : 
        print(str(i) + " est impair")

#%% function
def myAdd(x,y):
    return x*y
print(myAdd(3,"hello"))

import numpy