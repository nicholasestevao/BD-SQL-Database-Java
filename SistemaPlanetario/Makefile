SRC := src/sistemaplanetario
BUILD := build
DIST := dist
CLASSES := $(BUILD)/classes
FX_PATH := libFX/javaFX-202/lib
JBUILD := sistemaplanetario.

all: BaseEspacial SistemaPlanetario MissaoEspacial CadastrarPlanetas ConsultarMissoes Inicio TrabalhoBD

BaseEspacial: $(SRC)/BaseEspacial.java
	javac -d $(CLASSES) $(SRC)/BaseEspacial.java

SistemaPlanetario: $(SRC)/SistemaPlanetario.java
	javac -d $(CLASSES) $(SRC)/SistemaPlanetario.java

MissaoEspacial: $(SRC)/MissaoEspacial.java
	javac -d $(CLASSES) $(SRC)/MissaoEspacial.java

CadastrarPlanetas: $(SRC)/CadastrarPlanetasController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath $(CLASSES) $(SRC)/CadastrarPlanetasController.java
	cp $(SRC)/CadastrarPlanetas.fxml $(CLASSES)/sistemaplanetario

ConsultarMissoes: $(SRC)/ConsultarMissoesController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath $(CLASSES) $(SRC)/ConsultarMissoesController.java
	cp $(SRC)/ConsultarMissoes.fxml $(CLASSES)/sistemaplanetario

Inicio: $(SRC)/InicioController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath $(CLASSES) $(SRC)/InicioController.java
	cp $(SRC)/Inicio.fxml $(CLASSES)/sistemaplanetario

TrabalhoBD: $(SRC)/TrabalhoBD.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath $(CLASSES) $(SRC)/TrabalhoBD.java

start:
	cd $(CLASSES) && java --module-path ../../$(FX_PATH) --add-modules javafx.controls,javafx.fxml $(JBUILD)TrabalhoBD $(JBUILD)InicioController $(JBUILD)ConsultarMissoesController $(JBUILD)CadastrarPlanetasController $(JBUILD)MissaoEspacial $(JBUILD)SistemaPlanetario $(JBUILD)BaseEspacial

clean: $(CLASSES)/sistemaplanetario
	rm -r $(CLASSES)/sistemaplanetario