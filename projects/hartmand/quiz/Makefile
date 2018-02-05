CFLAGS = -Wall -fpic -coverage -lm

default: runtest

testme: testme.c
	gcc -o testme -g testme.c $(CFLAGS)

runtest: testme
	-./testme
	gcov testme.c

clean:
	rm -f testme *.gcda *.gcno *.gcov
