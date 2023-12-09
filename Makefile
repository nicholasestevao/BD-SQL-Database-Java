APLICACAO := ./SistemaPlanetario

all: compile start

compile: $(APLICACAO)/Makefile
	cd $(APLICACAO) && make all

start: $(APLICACAO)/Makefile
	cd $(APLICACAO) && make start

clean: $(APLICACAO)/Makefile
	cd $(APLICACAO) && make clean 