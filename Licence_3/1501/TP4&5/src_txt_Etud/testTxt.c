#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"txt.h"
#include"txtfile.h"

int main(){

  struct txt_s*  monTexte=txtCreat();


  txtAddStr(monTexte,"Heureux qui, comme Ulysse, a fait un beau voyage,");
  txtAddStr(monTexte,"Ou comme cestuy-là qui conquit la toison,");
  txtAddStr(monTexte,"Et puis est retourné, plein d\'usage et raison,");
  txtAddStr(monTexte,"Vivre entre ses parents le reste de son âge !");

  txtPrintOut(monTexte);

  

  printf("\n====== txtAddPos(monTexte,2,Test) ====== \n");
  txtInsertPos(monTexte,2,"Test");

  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtPrintOut(monTexte);

  printf("\n====== txtAddPos(monTexte,0,test2) ====== \n");
  txtInsertPos(monTexte,0,"Test2");
  
  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtPrintOut(monTexte);
  
  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtSuppPos(monTexte,0);
  txtPrintOut(monTexte);
  
  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtSuppPos(monTexte,3);
  txtPrintOut(monTexte);
  
  char * file = "/ubs/home/etud/2016/e1604902/Documents/1501/TP4/file2.txt";
  txtSavefile(monTexte, file);
  
  printf("\n====== Changement ====== \n");
  txtInsertPos(monTexte,2,"Changement");
  txtInsertPos(monTexte,2,"Changement");
  txtInsertPos(monTexte,7,"Changement");
  txtPrintOut(monTexte);
  
  /*printf("\ntxtLoadFile(file)\n");
  monTexte = txtLoadFile(file);
  txtPrintOut(monTexte);*/
  
  printf("\n====== Remplace ====== \n");
  txtRemplace(monTexte, "comme Ulysse", "comme je ne sais plus qui");
  
  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtPrintOut(monTexte);
  
  
  printf("\n====== txtUniq(monTexte) ====== \n");
  txtUniq(monTexte);
  
  
  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtPrintOut(monTexte);
  
  printf("\n====== txtReverse(monTexte) ====== \n");
  monTexte = txtReverse(monTexte);
  
  printf("\n====== txtPrintOut(monTexte) ====== \n");
  txtPrintOut(monTexte);
}
  
