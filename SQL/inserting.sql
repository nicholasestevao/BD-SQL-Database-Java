-- alimentando a tabela SISTEMA_PLANETARIO com dados
INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Sistema Solar', 'Via L�ctea', 0, 4.6, 'An� Amarela');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Alpha Centauri', 'Alfa Centauri', 4.37, 6.3, 'An� Amarela');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Trappist-1', 'Via L�ctea', 39.6, 7.6, 'An� Vermelha');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Kepler-186', 'Via L�ctea', 500, 4.0, 'An� Vermelha');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Sistema Gliese-163', 'Dorado', 49, 2000, 'An� Vermelha');

-- alimentando a tabela ESTRELA com dados
-- o campo NOME se refere ao nome do sistema planetario
INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Sistema Solar', 'Via L�ctea', 'Sol');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Alpha Centauri', 'Alfa Centauri', 'Alpha Centauri A');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Alpha Centauri', 'Alfa Centauri', 'Alpha Centauri B');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Trappist-1', 'Via L�ctea', 'Trappist-1-Death');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Kepler-186', 'Via L�ctea', 'D-Stranding');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Sistema Gliese-163', 'Dorado', 'Gliese-163');

-- alimentando a tabela PLANETA com dados
INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (1, 'Sistema Solar', 'Via L�ctea', 'Terra', 20, 1013, 'Temperado');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (2, 'Sistema Solar', 'Via L�ctea', 'Marte', -55, 636, 'Frio');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (3, 'Alpha Centauri', 'Alfa Centauri', 'MineWorld', 1200, 500, 'Quente');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (4, 'Trappist-1', 'Via L�ctea', 'CraftWorld', -40, 700, 'Frio');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (5, 'Sistema Gliese-163', 'Dorado', 'Gliese-163 B', -78, 452, 'Frio');

-- alimentando a tabela SATELITE_NATURAL com dados
INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (1, 'Lua');

INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (2, 'Fobos');

INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (3, 'Steve'); -- Exemplo fict�cio de sat�lite natural

INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (4, 'Creeper'); -- Exemplo fict�cio de sat�lite natural


-- alimentando a tabela COMPOSICAO_ATMOSFERICA com dados
INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (1, 'Oxig�nio', 21); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (1, 'Nitrog�nio', 78);

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (2, 'Di�xido de Carbono', 95); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (2, 'Nitrog�nio', 2.7); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (3, 'H�lio', 75); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (4, 'Metano', 50); 


-- alimentando a tabela CIVILIZACAO com dados
INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('Terr�quea', 'H', 'I', 1);

INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('Marciana', 'H', 'II', 2);

INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('AlfaCentauriana', 'A', 'I', 3);

INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('Trappistiana', 'T', 'III', 4);

-- alimentando a tabela CIVILIZACAO_HABITA_PLANETA com dados
INSERT INTO CIVILIZACAO_HABITA_PLANETA (NOME_CIVILIZACAO, CATEGORIA_CIVILIZACAO, PLANETA)
VALUES ('Terr�quea', 'H', 1);

INSERT INTO CIVILIZACAO_HABITA_PLANETA (NOME_CIVILIZACAO, CATEGORIA_CIVILIZACAO, PLANETA)
VALUES ('Marciana', 'H', 2);

INSERT INTO CIVILIZACAO_HABITA_PLANETA (NOME_CIVILIZACAO, CATEGORIA_CIVILIZACAO, PLANETA)
VALUES ('AlfaCentauriana', 'A', 3);


-- alimentando a tabela ROTA com dados
INSERT INTO ROTA (ORIGEM, DESTINO, DISTANCIA)
VALUES (1, 2, 100);

INSERT INTO ROTA (ORIGEM, DESTINO, DISTANCIA)
VALUES (2, 3, 50);

INSERT INTO ROTA (ORIGEM, DESTINO, DISTANCIA)
VALUES (3, 4, 30);

INSERT INTO ROTA (ORIGEM, DESTINO, DISTANCIA)
VALUES (4, 5, 80);


-- alimentando a tabela AMEACA com dados
INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('V�rus Espacial', 'Propaga-se entre sistemas planet�rios.', 8);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Guerra Intergal�ctica', 'Conflito armado entre civiliza��es interestelares.', 10);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Desastre Ambiental', 'Impacto ambiental de larga escala em um planeta.', 7);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Invas�o Alien�gena', 'For�as extraterrestres amea�am colonizar planetas.', 9);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Colapso do Buraco de Minhoca', 'Poss�vel colapso de uma rota de buraco de minhoca.', 6);


-- alimentando a tabela BASE_ESPACIAL com dados
INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (1, 'Base Lunar', 'Esta��o Orbital', 500, 'Frequ�ncia Lunar');

INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (2, 'Esta��o Marciana', 'Esta��o Espacial', 800, 'Frequ�ncia Marciana');

INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (3, 'Col�nia Alpha Centauri', 'Col�nia Espacial', 1000, 'Frequ�ncia Alpha Centauri');

INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (4, 'Base Trappist-1', 'Esta��o Orbital', 300, 'Frequ�ncia Trappist-1');

-- alimentando a tabela MISSAO_ESPACIAL com dados
INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (1, 1, 'Base Lunar', 'Miss�o Apollo 11', TO_DATE('1969-07-16', 'YYYY-MM-DD'), TO_DATE('1969-07-24', 'YYYY-MM-DD'), 'Pousar na Lua e retornar � Terra', 3, 'Explora��o Lunar', 8, 7);

INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (2, 2, 'Esta��o Marciana', 'Miss�o Mars Rover', TO_DATE('2012-08-06', 'YYYY-MM-DD'), TO_DATE('2023-11-30', 'YYYY-MM-DD'), 'Explora��o da superf�cie de Marte com ve�culo rob�tico', NULL, 'Explora��o Marciana', NULL, 5);

INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (3, 3, 'Col�nia Alpha Centauri', 'Miss�o Centauri Explorer', TO_DATE('2150-03-12', 'YYYY-MM-DD'), TO_DATE('2155-09-28', 'YYYY-MM-DD'), 'Explora��o da regi�o em torno de Alpha Centauri Bb', 50, 'Explora��o Interestelar', 5, 9);

INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (4, 4, 'Base Trappist-1', 'Miss�o Trappist Discovery', TO_DATE('2200-06-01', 'YYYY-MM-DD'), TO_DATE('2202-11-15', 'YYYY-MM-DD'), 'Explora��o dos planetas do sistema Trappist-1', 8, 'Explora��o Interestelar', 3, 8);


-- alimentando a tabela NAVE com dados
INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (1, 'Apollo 11', 'Nave de Explora��o', 3, 90, 'Lua', 1, 'Base Lunar');

INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (2, 'Aurora', 'Nave de Carga', NULL, 95, 'Marte', 2, 'Esta��o Marciana');

INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (3, 'Centauri Explorer', 'Nave de Explora��o', 50, 85, 'Alpha Centauri Bb', 3, 'Col�nia Alpha Centauri');

INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (4, 'Trappist Discovery', 'Nave de Pesquisa', 8, 80, 'Trappist-1', 4, 'Base Trappist-1');


-- alimentando a tabela AMEACA_ROTA com dados
INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (1, 2, 'Invas�o Alien�gena');

INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (2, 3, 'Desastre Ambiental'); 

INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (3, 4, 'Guerra Intergal�ctica'); 

INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (4, 5, 'Colapso do Buraco de Minhoca');


-- alimentando a tabela ROTA_MISSAO com dados
INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 1, 2, 1); -- Primeira rota da Miss�o 1: da Terra para Marte

INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 2, 3, 2); -- Segunda rota da Miss�o 1: de Marte para Alpha Centauri Bb

INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 3, 4, 3); -- Terceira rota da Miss�o 1: de Alpha Centauri Bb para Trappist-1d

INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 4, 5, 4);


-- alimentando a tabela AMEACA_PLANETA com dados
INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (1, 'Guerra Intergal�ctica'); 

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (2, 'Invas�o Alien�gena');

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (3, 'Desastre Ambiental'); 

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (4, 'Colapso do Buraco de Minhoca');

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (5, 'V�rus Espacial'); 


-- alimentando a tabela RECURSO_NATURAL com dados
INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('�gua', 'L�quido');

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('�gua', 'S�lido');

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Min�rio de Ferro', 'Mineral'); 

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Oxig�nio', 'G�s'); 

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Tit�nio', 'Metal'); 

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Madeira', 'Org�nico');


-- alimentando a tabela PRODUTO com dados
INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Fragmento de Estrela', 'Nebulosa Carina', 'Fragmento de estrela de n�utrons colhida a partir da Nebulosa Carina.', 999.99, 0.5);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Poeira de Cometa', 'Cintur�o de Kuiper', 'A aut�ntica poeira de cometa do cintur�o de Kuiper.', 49.99, 0.1);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Rocha Lunar Encantada', 'Lua', 'Uma rocha lunar carregada de energia m�stica.', 199.99, 2.0);
  
INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES('G�s Estelar em Frasco', 'Via L�ctea', 'G�s interestelar puro, coletado diretamente da Via L�ctea.', 79.99, 0.3);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Semente Extraterrestre', 'Planeta X', 'Uma semente misteriosa de uma planta alien�gena. �tima oportunidade para estudos bot�nicos.', 299.99, 0.5);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES('�gua Extraterrestre', 'Europa (Lua de J�piter)', '�gua l�quida e pura, coletada da lua Europa de J�piter. Uma raridade intergal�ctica.', 149.99, 1.5);
  
INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('F�sseis Marcianos', 'Marte', 'F�sseis �nicos de criaturas antigas de Marte.', 349.99, 3.0);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Amostra de G�s Nebuloso', 'Nebulosa �rion', 'Uma amostra de g�s nebuloso, ideal para an�lises espectrosc�picas e estudos astroqu�micos.', 899.99, 1.2);

-- alimentando a tabela RECURSO_PLANETA com dados
INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (1, '�gua', 'L�quido',1386);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (2, '�gua', 'S�lido',978);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (3, 'Tit�nio', 'Metal',451);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (4, 'Min�rio de Ferro', 'Mineral',1232);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (5, 'Oxig�nio', 'G�s',200);

-- alimentando a tabela NAVE_COLONIZADORA com dados
INSERT INTO NAVE_COLONIZADORA (NAVE)
VALUES (3);

INSERT INTO NAVE_COLONIZADORA (NAVE)
VALUES (1);

-- alimentando a tabela NAVE_CARGA com dados
INSERT INTO NAVE_CARGA(NAVE, CAPACIDADE_CARGA)
VALUES (2, 20);

-- alimentando a tabela NAVE_CIENTIFICA com dados
INSERT INTO NAVE_CIENTIFICA(NAVE, CAPACIDADE_CARGA)
VALUES (4, 5);

-- alimentando a tabela PRODUTO_CIVILIZACAO com dados
INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('AlfaCentauriana', 'A', 'G�s Estelar em Frasco', 'Via L�ctea');

INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('Marciana', 'H', 'F�sseis Marcianos', 'Marte');

INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('Marciana', 'H', '�gua Extraterrestre', 'Europa (Lua de J�piter)');

INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('Trappistiana', 'H', 'Amostra de G�s Nebuloso', 'Nebulosa �rion');

-- alimentando a tabela MISSAO_EXPLORACAO com dados

-- alimentando a tabela MISSAO_COMERCIO com dados

-- alimentando a tabela MISSAO_COLONIZACAO com dados

-- alimentando a tabela COMERCIO_PRODUTO com dados

-- alimentando a tabela EQUIPAMENTOS com dados