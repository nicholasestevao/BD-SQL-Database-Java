SRC := src/sistemaplanetario
BUILD := build
DIST := dist
CLASSES := $(BUILD)/classes
FX_PATH := libFX/javaFX-202/lib
JBUILD := sistemaplanetario.
JDBC := ojdbc11.jar

all: Conexao BaseEspacial SistemaPlanetario MissaoEspacial CadastrarPlanetas ConsultarMissoes Inicio Login TrabalhoBD

Conexao: $(SRC)/Conexao.java
	javac -d $(CLASSES) $(SRC)/Conexao.java

BaseEspacial: $(SRC)/BaseEspacial.java
	javac -d $(CLASSES) $(SRC)/BaseEspacial.java

SistemaPlanetario: $(SRC)/SistemaPlanetario.java
	javac -d $(CLASSES) $(SRC)/SistemaPlanetario.java

MissaoEspacial: $(SRC)/MissaoEspacial.java
	javac -d $(CLASSES) $(SRC)/MissaoEspacial.java

CadastrarPlanetas: $(SRC)/CadastrarPlanetasController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath "$(CLASSES);$(JDBC)" $(SRC)/CadastrarPlanetasController.java
	cp $(SRC)/CadastrarPlanetas.fxml $(CLASSES)/sistemaplanetario

ConsultarMissoes: $(SRC)/ConsultarMissoesController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath "$(CLASSES);$(JDBC)" $(SRC)/ConsultarMissoesController.java
	cp $(SRC)/ConsultarMissoes.fxml $(CLASSES)/sistemaplanetario

Inicio: $(SRC)/InicioController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath "$(CLASSES);$(JDBC)" $(SRC)/InicioController.java
	cp $(SRC)/Inicio.fxml $(CLASSES)/sistemaplanetario

Login: $(SRC)/LoginController.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath "$(CLASSES);$(JDBC)" $(SRC)/LoginController.java
	cp $(SRC)/Login.fxml $(CLASSES)/sistemaplanetario

TrabalhoBD: $(SRC)/TrabalhoBD.java
	javac --module-path $(FX_PATH) --add-modules javafx.controls,javafx.fxml -d $(CLASSES) -classpath "$(CLASSES);$(JDBC)" $(SRC)/TrabalhoBD.java

start:
	cd $(CLASSES) && java --module-path ../../$(FX_PATH) --add-modules javafx.controls,javafx.fxml -cp ".;../../$(JDBC)" $(JBUILD)TrabalhoBD $(JBUILD)LoginController $(JBUILD)InicioController $(JBUILD)ConsultarMissoesController $(JBUILD)CadastrarPlanetasController $(JBUILD)MissaoEspacial $(JBUILD)SistemaPlanetario $(JBUILD)BaseEspacial $(JBUILD)Conexao

clean: $(CLASSES)/sistemaplanetario
	rm -r $(CLASSES)/sistemaplanetario