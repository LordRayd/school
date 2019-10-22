import os
from skimage import io
import pylab as pl
import numpy as np

#%% Pretraitement de l'image
def pretraitAplat(img):
    res = img.flatten()
    for i in range(img):
        for j in range(img[0]):
            for k in range(img[0][0]):
                if (img[i][j][k] == 255):
                    res[i*j*k] = 254
    return res

#%% Codage des caracteres
def codageCar(tableau, carac):
    print()
    print("debut codage")
    carac = carac.replace('b','') 
    res = np.arange(8)
    
    bit= bin(ord(carac))
    print (bit)
    
    b = int(bit,2)
    print (b)
    
    c= chr(b)
    print(c)
    
    for i in range(0,7,1):
        if(bit[i] == 0):
            if tableau[i] == 0:
                res[i] = 0
            elif(tableau[i]%2 == 0):
                res[i] = tableau[i]
            else:
                res[i] = tableau[i]+1
        else:
            if(tableau[i]%2 == 0):
                res[i] = tableau[i]+1
            else:
                res[i] = tableau[i]

#%%            
def decodageCar(tableau):
    print()
    print("debut decodage")
    
    res = ''
    for i in range(0,8,1):
        if(tableau[i]%2 == 0):
            res = res+'0'
        else:
            res = res+'1'
    
    word = res[0]
    word = word + 'b'
    for i in range(1,8,1):
        word = word + res[i]
    print (word)
    
    b = int(word,2)
    print (b)
    
    c= chr(b)
    print(c)
    
    return c
#%% Test 
tabCodage = [255,255,253,145,0,65,35,255]
codageCar(tabCodage,'d')
tab = [254,255,253,146,0,65,36,254]
decodageCar(tab)