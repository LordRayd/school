test : npi.jar
	java -cp npi.jar npi.NPI

test1 : npi.jar
	echo "3 3 * >PI 5 +\n PI PI *"|java -cp npi.jar npi.NPI

npi/NPI.class : npi/NPI.java
	javac npi/NPI.java

npi/NPI.java : npi/NPI.lex
	jflex npi/NPI.lex

clean : 
	rm -f npi/NPI.class npi/NPI.java npi.jar

npi.jar : npi/NPI.class
	jar -cvf npi.jar npi/NPI.class npi/NPI.lex
