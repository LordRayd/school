//  txt.c

#include<stdio.h>
#include"txt.h"
#include <stdlib.h> // malloc
#include<string.h>

//
//  txtCreat
//
// initialise un objet de type txt_t (struct txt_s * ) 
//
struct txt_s*  txtCreat(){
  struct txt_s* res = (struct txt_s*) malloc(sizeof(struct txt_s));
  res->premier = (struct maillon_s*) NULL;
  return res;
}

//
//  txtAddStr
//
// ajoute une s lignes en fin du texte
// dans un objet txt_t  
// 
//
void txtAddStr(struct txt_s*   texte,char * ligne){
	struct maillon_s* new = (struct maillon_s*) malloc(sizeof(struct maillon_s));
	new->ligne = (char *) malloc(strlen(ligne)+1);
	strcpy(new->ligne, ligne);
	new->suivant = (struct maillon_s*) NULL;
	struct maillon_s* tmp = texte->premier;
	if(texte->premier != NULL){
		while(tmp->suivant != NULL){
			tmp = tmp->suivant;
		}
		tmp->suivant = new;
	}else{
		texte->premier = new;
	}
}

//
//  txtPrintOut
//  affiche sur la sortie standard
//  les ligned de texte d un objet  txt_t  
//  
//  
void txtPrintOut(struct txt_s*  texte){
   if(texte->premier){
	struct maillon_s* tmp = texte->premier;
	   while(tmp != NULL){
		   printf("%s\n",tmp->ligne);
		   tmp = tmp->suivant;
	   }
	}else{
		printf("Texte vide");
	}
}

void txtInsertPos(struct txt_s* texte, int pos, char* ligne){
	struct maillon_s* new = (struct maillon_s*) malloc(sizeof(struct maillon_s));
	new->ligne = (char *) malloc(strlen(ligne)+1);
	strcpy(new->ligne, ligne);
	new->suivant = (struct maillon_s*) NULL;
	
	struct maillon_s* tmp = texte->premier;
	
	if(pos > 1){
		int avancement = 1;
		while(tmp->suivant != NULL && avancement < pos-1){
			tmp = tmp->suivant;
			avancement++;
		}
		new->suivant = tmp->suivant;
		tmp->suivant = new;
	}else{
		new->suivant = texte->premier;
		texte->premier = new;
	}
}

void txtSuppPos(struct txt_s* texte, int pos){	
	if(pos > 1){
		struct maillon_s* tmp = texte->premier;
		int avancement = 1;
		while(tmp->suivant != NULL && avancement < pos-1){
			tmp = tmp->suivant;
			avancement++;
		}
		tmp->suivant = tmp->suivant->suivant;
	}else{
		texte->premier = texte->premier->suivant;
	}
}

void txtRemplace(struct txt_s* texte,char* motif,char* par){
    struct maillon_s* mail=texte->premier;
    while(mail != NULL){
            char* ret=malloc(4096*sizeof(char));
            ret = strstr(mail->ligne,motif);
            while(ret!=NULL){
                char* res=malloc(4096*sizeof(char));
                char* start;
                start=res;
                strncpy(res,mail->ligne,ret-mail->ligne);
                res=res+strlen(res);
                strncpy(res,par,strlen(par));
                res=res+strlen(res);
                ret+=strlen(motif);
                strncpy(res,ret,strlen(ret));
                res=start;
                mail->ligne=res;
                ret = strstr(mail->ligne,motif);
            }
            mail=mail->suivant;
    }
}

struct txt_s * txtUniq(struct txt_s * texte ){
	struct maillon_s* mail1=texte->premier;
    
    while(mail1){
		struct maillon_s* mail2=mail1;
		printf("A comparer : %s\n",mail1->ligne);
		
		while(mail2 && mail2->suivant){
			printf("Avec : %s\n",mail2->suivant->ligne);
			
			if(mail2->suivant->ligne!=NULL && strstr(mail1->ligne,mail2->suivant->ligne)){
				
				if(mail2->suivant->suivant){
					mail2->suivant = mail2->suivant->suivant;
				}else{
					mail2->suivant = NULL;
				}
			}
			
			mail2=mail2->suivant;
		}
		mail1=mail1->suivant;
    
    }
    return texte;
}

struct txt_s * txtReverse(struct txt_s * texte ){
	struct txt_s* res = txtCreat();
	if(texte->premier->suivant){
		struct maillon_s* mail = texte->premier;
		txtAddStr(res, mail->ligne);
		mail = mail->suivant;
		while(mail){
			txtInsertPos(res,0,mail->ligne);
			mail = mail->suivant;
		}
	}
	return res;
}
