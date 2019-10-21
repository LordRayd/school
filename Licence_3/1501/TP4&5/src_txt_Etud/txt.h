
// ....


struct maillon_s {
	char * ligne;
	struct maillon_s* suivant;
};

struct txt_s {
   struct maillon_s* premier;
} ; 

 


//
//  txtCreat
//
// initialise un objet de type txt_t (struct txt_s *)  
//
struct txt_s* txtCreat();


//
//  txtAddStr
//
// ajoute une ligne en fin du texte
// dans un objet txt_t  (struct txt_s *) 
// 
//
void txtAddStr(struct txt_s*  texte,char *);



//
//  txtPrintOut
//  affiche sur la sortie standard
//  les ligned de texte d un objet struct txt_s * 
//  
//  
void txtPrintOut(struct txt_s*   texte);



void txtInsertPos(struct txt_s* texte, int pos, char* ligne);

void txtRemplace(struct txt_s * texte,char * motif, char * par);

struct txt_s * txtUniq(struct txt_s * texte );

struct txt_s * txtReverse(struct txt_s * texte);
