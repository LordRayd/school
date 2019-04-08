##########################################################

#Nom de l'analyseur produit par JavaCC
PARSER_NAME= Calc

#fichier de specification pour JavaCC 
JAVACC_SPEC= $(PARSER_NAME).jj

#repertoire contenant les fichiers produits par javaCC
OUTPUT_DIR= calc

#fichiers java produits par JavaCC
JAVA_SRC=  $(OUTPUT_DIR)/$(PARSER_NAME).java \
	   $(OUTPUT_DIR)/$(PARSER_NAME)Constants.java \
	   $(OUTPUT_DIR)/$(PARSER_NAME)TokenManager.java\
	   $(OUTPUT_DIR)/JavaCharStream.java \
	   $(OUTPUT_DIR)/ParseException.java \
	   $(OUTPUT_DIR)/Token.java \
	   $(OUTPUT_DIR)/TokenMgrError.java

#classes java de l'application
JAVA_CLASS= $(JAVA_SRC:%.java=%.class)

#fichier d'archive contenant l'application (et le .jj)
JAVA_JAR= calc.jar

##########################################################

#commande pour compiler un fichier de specification JavaCC
JAVACC= javacc

#commande pour compiler un programme Java
JAVAC= javac 

#commande pour executer un programme Java
JAVA= java -classpath $(JAVA_JAR)

#commande pour creer une archive Java
JAR= jar

#commande pour lancer la calculatrice
CALC= $(JAVA) $(OUTPUT_DIR).$(PARSER_NAME)

###########################################################

all:	$(JAVA_JAR)

$(JAVA_JAR) : $(JAVA_CLASS)
	$(JAR) cvf $(JAVA_JAR) $(JAVA_CLASS) $(JAVACC_SPEC)

$(JAVA_CLASS) : $(JAVA_SRC)
	$(JAVAC) $(JAVA_SRC) 

$(JAVA_SRC) : $(JAVACC_SPEC)
	$(JAVACC) $(JAVACC_SPEC)

test1:	$(JAVA_JAR)
	$(CALC) "read A read B sum := A+B write sum write sum / 2"

test2: $(JAVA_JAR)
	$(CALC) "read A read B write (A*A)+B*B"

test3:	$(JAVA_JAR)
	$(CALC) "read A B sum := A+B write sum write sum / 2"

clean:
	rm -f $(JAVA_SRC) $(JAVA_CLASS) $(JAVA_JAR)
