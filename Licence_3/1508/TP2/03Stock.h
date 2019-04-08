struct vetement_s{
    int taille;
	char* couleur;
	char* matiere1;
	char* matiere2;
	char* matiere3;
}; 


struct comestible_s{  	
	char* provenance;
	char* dlc;
}; 

struct article_s{
	int type;
	int reference;
	char* designation;
	char* categorie;
	int nbExemplaire;
	union{
		struct vetement_s vetement;
		struct comestible_s comestible;
	};
};

struct magasin_s{
	struct article_s articles[1000];
};