import os
from skimage import io
import pylab as pl


# action basique tableau
s = [1, 2, 3, 4, 1, 1]
print(len(s))
print (min(s))
print (max(s))
nbOcuurence = s.count(1)
print(nbOcuurence )

# insertion dans tableau a l'index 0
s.insert(0,3)
nbOcuurence = s.count(1)
print(nbOcuurence )
print("Tableau insert")
for i in range(0,len(s)-1,1):
    print(s[i])

# suppression a l'indice 3
del(s[3])
print("Tableau delete")
for i in range(0,len(s)-1,1):
    print(s[i])

#affiche Image
os.chdir('D:\\Dut_Informatique\\Semestre4\\M4202')
img = io.imread('lena-64x64.jpg')
print(type(img))
print(img.shape)
#pl.imshow(img,cmap=pl.cm.gray)
#pl.show()

imgNeg=255-img
pl.subplot(1,2,1)
pl.title('Image')
pl.imshow(img,cmap=pl.cm.gray)
pl.subplot(1,2,2)
pl.title('Negatif')
pl.imshow(imgNeg,cmap=pl.cm.gray)
pl.show()