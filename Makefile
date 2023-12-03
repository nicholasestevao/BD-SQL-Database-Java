APLICACAO := ./SistemaPlanetario

all: compile

compile: $(APLICACAO)/Makefile
	cd $(APLICACAO) && make all

start: $(APLICACAO)/Makefile
	cd $(APLICACAO) && make start

clean: $(APLICACAO)/Makefile
	cd $(APLICACAO) && make clean 