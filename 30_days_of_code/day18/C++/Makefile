all: palin

palin: palin.o 
	g++ -Wall palin.o -o $@

palin.o: palin.cpp
	g++ -Wall -c palin.cpp

clean:
	rm -f palin palin.o
