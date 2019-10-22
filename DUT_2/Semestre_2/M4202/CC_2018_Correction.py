# -*- coding: utf-8 -*-
"""
Created on Mon Mar 12 16:22:48 2018

@author: ridard
"""

#%% importation des modules
import numpy as np # juste pour une histoire de transposition à un moment donné
from sympy import * # pour tout le calcul algébrique formel
init_session()

#%% matrice de l'exercice 1
A = Matrix([[1,2,2],[2,1,2],[2,2,1]])
A

#%% Q1 : polynôme caractérstique de A
lamda = Symbol('lamda')
chi = A.charpoly(lamda).factor() # fournit en fait le polynôme unitaire (coefficient dominant égal à 1) de mêmes racines
chi

#%% Q2 : racines du polynôme caractéristique avec multiplicité
sp = roots(chi) # fournit le dictionnaire des multiplicités dont les clés sont les racines
sp

#%% Q3 : d'abord, on détermine le sous-espace propre associé à -1 (seule valeur propre multiple donc seul problème potentiel)
lamda = -1
I = eye(3) # matrice identité d'ordre 3
e = (A-lamda*I).nullspace() # fournit une base du noyau de A-lamda*I
e

#%% Q3 : ensuite, on utilise la condition de diagonalisabilité (en supposant que l'on a le bon nombre de valeurs propres et une seule valeur propre multiple)
if len(e) == sp[lamda] : # si la dimension du sous-espace propre coincide avec la multiplicité
    print('A est diagonalisable')
else : # en fait len(e) < sp[lamda]
    print('A n\'est pas diagonalisable car la dimension du sous-espace propre associé à',lamda,'est strictement inférieure à la multiplicité')
    
#%% Q3 : on peut déjà former la matrice D
D = diag(-1,-1,5)
D   

#%% Q3 : on détermine maintenant le sous-espace propre associé à 5
lamda = 5
I = eye(3)
f = (A-lamda*I).nullspace()
f

#%% Q3 : on peut alors former la matrice P
P = Matrix(np.array(e+f).transpose()) # attention à la transposition qui est nécessaire ici
P

#%% Q4 : inversion de P
Q = P.inv()
Q

#%% Q5 : vérification de l'inverse de P
P*Q

#%% Q5 : vérification de la diagonalisation
Q*A*P

#%% on peut obtenir directement les sous-espaces propres !
A.eigenvects()

#%% on peut même obtenir directement les matrices P et D, ou savoir si A n'est pas diagonalisable !
A.diagonalize()

#%% matrice de l'exercice 2 question 1
A = Matrix([[1,-1,2],[-1,1,2],[2,1,-1]])
A

#%% on peut aussi obtenir directement les valeurs propres uniquement !
sp = A.eigenvals()
sp

#%% A n'est pas diagonalisable
A.diagonalize()

#%% pour plus de détails sur la non diagonalisabilité
lamda = 2
I = eye(3) # matrice identité d'ordre 3
e = (A-lamda*I).nullspace() # fournit une base du noyau de A-lamda*I
e

#%% on retrouve effectivement la non diagonalisabilité
if len(e) == sp[lamda] : # si la dimension du sous-espace propre coincide avec la multiplicité
    print('A est diagonalisable car',len(e),' =',sp[lamda])
else : # en fait len(e) < V[lamda]
    print('A n\'est pas diagonalisable car la dimension (',len(e),') du sous-espace propre associé à',lamda,'est strictement inférieure à la multiplicité (',sp[lamda],')')