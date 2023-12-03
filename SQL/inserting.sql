-- alimentando a tabela SISTEMA_PLANETARIO com dados
INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Sistema Solar', 'Via Láctea', 0, 4.6, 'Anã Amarela');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Alpha Centauri', 'Alfa Centauri', 4.37, 6.3, 'Anã Amarela');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Trappist-1', 'Via Láctea', 39.6, 7.6, 'Anã Vermelha');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Kepler-186', 'Via Láctea', 500, 4.0, 'Anã Vermelha');

INSERT INTO SISTEMA_PLANETARIO (NOME, GALAXIA, DISTANCIA, IDADE_ESTIMADA, TIPO_ESTRELA_CENTRAL)
VALUES ('Sistema Gliese-163', 'Dorado', 49, 2000, 'Anã Vermelha');

-- alimentando a tabela ESTRELA com dados
-- o campo NOME se refere ao nome do sistema planetario
INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Sistema Solar', 'Via Láctea', 'Sol');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Alpha Centauri', 'Alfa Centauri', 'Alpha Centauri A');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Alpha Centauri', 'Alfa Centauri', 'Alpha Centauri B');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Trappist-1', 'Via Láctea', 'Trappist-1-Death');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Kepler-186', 'Via Láctea', 'D-Stranding');

INSERT INTO ESTRELA (NOME_SISTEMA, GALAXIA, ESTRELA)
VALUES ('Sistema Gliese-163', 'Dorado', 'Gliese-163');

-- alimentando a tabela PLANETA com dados
INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (1, 'Sistema Solar', 'Via Láctea', 'Terra', 20, 1013, 'Temperado');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (2, 'Sistema Solar', 'Via Láctea', 'Marte', -55, 636, 'Frio');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (3, 'Alpha Centauri', 'Alfa Centauri', 'MineWorld', 1200, 500, 'Quente');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (4, 'Trappist-1', 'Via Láctea', 'CraftWorld', -40, 700, 'Frio');

INSERT INTO PLANETA (ID, SISTEMA_PLANETARIO, GALAXIA, NOME, TEMPERATURA, PRESSAO, CLIMA)
VALUES (5, 'Sistema Gliese-163', 'Dorado', 'Gliese-163 B', -78, 452, 'Frio');

-- alimentando a tabela SATELITE_NATURAL com dados
INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (1, 'Lua');

INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (2, 'Fobos');

INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (3, 'Steve'); -- Exemplo fictício de satélite natural

INSERT INTO SATELITE_NATURAL (PLANETA, SATELITE)
VALUES (4, 'Creeper'); -- Exemplo fictício de satélite natural


-- alimentando a tabela COMPOSICAO_ATMOSFERICA com dados
INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (1, 'Oxigênio', 21); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (1, 'Nitrogênio', 78);

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (2, 'Dióxido de Carbono', 95); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (2, 'Nitrogênio', 2.7); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (3, 'Hélio', 75); 

INSERT INTO COMPOSICAO_ATMOSFERICA (PLANETA, ELEMENTO, PORCENTAGEM)
VALUES (4, 'Metano', 50); 


-- alimentando a tabela CIVILIZACAO com dados
INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('Terráquea', 'H', 'I', 1);

INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('Marciana', 'H', 'II', 2);

INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('AlfaCentauriana', 'A', 'I', 3);

INSERT INTO CIVILIZACAO (NOME, CATEGORIA, CLASSIFICACAO, PLANETA_ORIGEM)
VALUES ('Trappistiana', 'T', 'III', 4);

-- alimentando a tabela CIVILIZACAO_HABITA_PLANETA com dados
INSERT INTO CIVILIZACAO_HABITA_PLANETA (NOME_CIVILIZACAO, CATEGORIA_CIVILIZACAO, PLANETA)
VALUES ('Terráquea', 'H', 1);

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
VALUES ('Vírus Espacial', 'Propaga-se entre sistemas planetários.', 8);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Guerra Intergaláctica', 'Conflito armado entre civilizações interestelares.', 10);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Desastre Ambiental', 'Impacto ambiental de larga escala em um planeta.', 7);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Invasão Alienígena', 'Forças extraterrestres ameaçam colonizar planetas.', 9);

INSERT INTO AMEACA (NOME, DESCRICAO, NIVEL)
VALUES ('Colapso do Buraco de Minhoca', 'Possível colapso de uma rota de buraco de minhoca.', 6);


-- alimentando a tabela BASE_ESPACIAL com dados
INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (1, 'Base Lunar', 'Estação Orbital', 500, 'Frequência Lunar');

INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (2, 'Estação Marciana', 'Estação Espacial', 800, 'Frequência Marciana');

INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (3, 'Colônia Alpha Centauri', 'Colônia Espacial', 1000, 'Frequência Alpha Centauri');

INSERT INTO BASE_ESPACIAL (PLANETA, NOME, TIPO, CAPACIDADE, CANAL_COMUNICACAO)
VALUES (4, 'Base Trappist-1', 'Estação Orbital', 300, 'Frequência Trappist-1');

-- alimentando a tabela MISSAO_ESPACIAL com dados
INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (1, 1, 'Base Lunar', 'Missão Apollo 11', TO_DATE('1969-07-16', 'YYYY-MM-DD'), TO_DATE('1969-07-24', 'YYYY-MM-DD'), 'Pousar na Lua e retornar à Terra', 3, 'Exploração Lunar', 8, 7);

INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (2, 2, 'Estação Marciana', 'Missão Mars Rover', TO_DATE('2012-08-06', 'YYYY-MM-DD'), TO_DATE('2023-11-30', 'YYYY-MM-DD'), 'Exploração da superfície de Marte com veículo robótico', NULL, 'Exploração Marciana', NULL, 5);

INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (3, 3, 'Colônia Alpha Centauri', 'Missão Centauri Explorer', TO_DATE('2150-03-12', 'YYYY-MM-DD'), TO_DATE('2155-09-28', 'YYYY-MM-DD'), 'Exploração da região em torno de Alpha Centauri Bb', 50, 'Exploração Interestelar', 5, 9);

INSERT INTO MISSAO_ESPACIAL (ID, PLANETA_BASE, NOME_BASE, NOME, DATA_INICIO, DATA_FIM, DESCRICAO, TAMANHO_TRIPULACAO, OBJETIVO, DURACAO_ESTIMADA, NIVEL_PERICULOSIDADE)
VALUES (4, 4, 'Base Trappist-1', 'Missão Trappist Discovery', TO_DATE('2200-06-01', 'YYYY-MM-DD'), TO_DATE('2202-11-15', 'YYYY-MM-DD'), 'Exploração dos planetas do sistema Trappist-1', 8, 'Exploração Interestelar', 3, 8);


-- alimentando a tabela NAVE com dados
INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (1, 'Apollo 11', 'Nave de Exploração', 3, 90, 'Lua', 1, 'Base Lunar');

INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (2, 'Aurora', 'Nave de Carga', NULL, 95, 'Marte', 2, 'Estação Marciana');

INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (3, 'Centauri Explorer', 'Nave de Exploração', 50, 85, 'Alpha Centauri Bb', 3, 'Colônia Alpha Centauri');

INSERT INTO NAVE (ID, NOME, CLASSE, MAX_TRIPULACAO, RESISTENCIA, LOC_ATUAL, PLANETA_BASE, NOME_BASE)
VALUES (4, 'Trappist Discovery', 'Nave de Pesquisa', 8, 80, 'Trappist-1', 4, 'Base Trappist-1');


-- alimentando a tabela AMEACA_ROTA com dados
INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (1, 2, 'Invasão Alienígena');

INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (2, 3, 'Desastre Ambiental'); 

INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (3, 4, 'Guerra Intergaláctica'); 

INSERT INTO AMEACA_ROTA (ORIGEM_ROTA, DESTINO_ROTA, NOME_AMEACA)
VALUES (4, 5, 'Colapso do Buraco de Minhoca');


-- alimentando a tabela ROTA_MISSAO com dados
INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 1, 2, 1); -- Primeira rota da Missão 1: da Terra para Marte

INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 2, 3, 2); -- Segunda rota da Missão 1: de Marte para Alpha Centauri Bb

INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 3, 4, 3); -- Terceira rota da Missão 1: de Alpha Centauri Bb para Trappist-1d

INSERT INTO ROTA_MISSAO (MISSAO, ORIGEM_ROTA, DESTINO_ROTA, ORDEM)
VALUES (1, 4, 5, 4);


-- alimentando a tabela AMEACA_PLANETA com dados
INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (1, 'Guerra Intergaláctica'); 

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (2, 'Invasão Alienígena');

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (3, 'Desastre Ambiental'); 

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (4, 'Colapso do Buraco de Minhoca');

INSERT INTO AMEACA_PLANETA (PLANETA, AMEACA)
VALUES (5, 'Vírus Espacial'); 


-- alimentando a tabela RECURSO_NATURAL com dados
INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Água', 'Líquido');

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Água', 'Sólido');

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Minério de Ferro', 'Mineral'); 

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Oxigênio', 'Gás'); 

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Titânio', 'Metal'); 

INSERT INTO RECURSO_NATURAL (NOME, TIPO)
VALUES ('Madeira', 'Orgânico');


-- alimentando a tabela PRODUTO com dados
INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Fragmento de Estrela', 'Nebulosa Carina', 'Fragmento de estrela de nêutrons colhida a partir da Nebulosa Carina.', 999.99, 0.5);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Poeira de Cometa', 'Cinturão de Kuiper', 'A autêntica poeira de cometa do cinturão de Kuiper.', 49.99, 0.1);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Rocha Lunar Encantada', 'Lua', 'Uma rocha lunar carregada de energia mística.', 199.99, 2.0);
  
INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES('Gás Estelar em Frasco', 'Via Láctea', 'Gás interestelar puro, coletado diretamente da Via Láctea.', 79.99, 0.3);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Semente Extraterrestre', 'Planeta X', 'Uma semente misteriosa de uma planta alienígena. Ótima oportunidade para estudos botânicos.', 299.99, 0.5);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES('Água Extraterrestre', 'Europa (Lua de Júpiter)', 'Água líquida e pura, coletada da lua Europa de Júpiter. Uma raridade intergaláctica.', 149.99, 1.5);
  
INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Fósseis Marcianos', 'Marte', 'Fósseis únicos de criaturas antigas de Marte.', 349.99, 3.0);

INSERT INTO PRODUTO (NOME, ORIGEM, DESCRICAO, PRECO, PESO)
VALUES ('Amostra de Gás Nebuloso', 'Nebulosa Órion', 'Uma amostra de gás nebuloso, ideal para análises espectroscópicas e estudos astroquímicos.', 899.99, 1.2);

-- alimentando a tabela RECURSO_PLANETA com dados
INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (1, 'Água', 'Líquido',1386);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (2, 'Água', 'Sólido',978);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (3, 'Titânio', 'Metal',451);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (4, 'Minério de Ferro', 'Mineral',1232);

INSERT INTO RECURSO_PLANETA (PLANETA, NOME_REC, tipo_REC, ESTIMATIVA)
VALUES (5, 'Oxigênio', 'Gás',200);

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
VALUES ('AlfaCentauriana', 'A', 'Gás Estelar em Frasco', 'Via Láctea');

INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('Marciana', 'H', 'Fósseis Marcianos', 'Marte');

INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('Marciana', 'H', 'Água Extraterrestre', 'Europa (Lua de Júpiter)');

INSERT INTO PRODUTO_CIVILIZACAO(NOME_CIV, CATEG_CIV, NOME_PRODUTO, ORIGEM_PRODUTO)
VALUES ('Trappistiana', 'H', 'Amostra de Gás Nebuloso', 'Nebulosa Órion');

-- alimentando a tabela MISSAO_EXPLORACAO com dados

-- alimentando a tabela MISSAO_COMERCIO com dados

-- alimentando a tabela MISSAO_COLONIZACAO com dados

-- alimentando a tabela COMERCIO_PRODUTO com dados

-- alimentando a tabela EQUIPAMENTOS com dados