struct article_s{
	short reference;
	char* designation;
	char* categorie;
	int exemplaires;
	int taille;
	char* couleur;
	char* matiere1;
	char* matiere2;
	char* matiere3;
	char* provenance;
	char* dlc;
};
struct magasin_s{
	struct article_s* articles;
};
