# fichier makefile
all :  txt_file_t.o testTxt
testTxt : testTxt.o txt_file_t.o txt_t.o
	gcc -o testTxt testTxt.o txt_t.o txt_file_t.o
testTxt.o : testTxt.c txt.h txt_file_t.o
	gcc -c -o testTxt.o testTxt.c
txt_file_t.o : txtfile.c txtfile.h
	gcc -c -o txt_file_t.o txtfile.c
txt_t.o : txt.c txt.h
	gcc -c -o txt_t.o txt.c
clean	:
	rm -f *.o

