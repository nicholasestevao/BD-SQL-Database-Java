/* CONSULTA 1: Contar quantas ameaças tem nas rotas de cada missão */

SELECT NOME, COUNT(*) FROM (SELECT NOME, NOME_AMEACA AS AMEACA
FROM MISSAO_ESPACIAL M JOIN ROTA_MISSAO RM ON M.ID = RM.MISSAO 									/* seleciona as rotas da missão */
JOIN AMEACA_ROTA AR ON RM.ORIGEM_ROTA = AR.ORIGEM_ROTA AND RM.DESTINO_ROTA = AR.DESTINO_ROTA	/* seleciona as ameaças nas rotas da missão */

UNION	/* união para considerar os dois tipos de ameaça: rota e planeta*/

SELECT NOME, AMEACA
FROM MISSAO_ESPACIAL M JOIN ROTA_MISSAO RM ON M.ID = RM.MISSAO									/* seleciona as rotas da missão */
JOIN AMEACA_PLANETA AP ON AP.PLANETA = RM.ORIGEM_ROTA OR AP.PLANETA = RM.DESTINO_ROTA)			/* seleciona as ameaças nos planetas das rotas da missão */

GROUP BY NOME /* agrupa por nome da missão */


/* CONSULTA 2: Listar civilizações que comercializam todos os produtos que uma missão comercializa (independente de ser compra ou venda) */

SELECT NOME FROM CIVILIZACAO C1 WHERE NOT EXISTS ( 
(SELECT NOME_PRODUTO FROM MISSAO_ESPACIAL M JOIN COMERCIO_PRODUTO CP ON M.ID = CP.MISSAO WHERE M.ID = 1) /* lista produtos comercializados pela missão de ID 1 */
MINUS
(SELECT NOME_PRODUTO FROM CIVILIZACAO C JOIN PRODUTO_CIVILIZACAO PC ON C.NOME = PC.NOME_CIV AND C.CATEGORIA = PC.CATEG_CIV WHERE C.NOME = C1.NOME AND C.CATEGORIA = C1.CATEGORIA) /* lista produtos comercializados pela civilização C1 */
)


/* CONSULTA 3: Contar quantas missões cada nave realizou */

SELECT NV.NOME, COUNT(NAVE) AS NUM_MISSOES FROM (SELECT MCOM.MISSAO, NCOM.NAVE FROM MISSAO_COMERCIO MCOM JOIN NAVE_CARGA NCOM ON NCOM.NAVE = MCOM.NAVE /* retorna naves que realizaram missoes de comercio*/
UNION
SELECT MEXP.MISSAO, NCIEN.NAVE FROM MISSAO_EXPLORACAO MEXP JOIN NAVE_CIENTIFICA NCIEN ON NCIEN.NAVE = MEXP.NAVE /* retorna naves que realizaram missoes de exploracao*/
UNION
SELECT MCOL.MISSAO, NCOL.NAVE FROM MISSAO_COLONIZACAO MCOL JOIN NAVE_COLONIZADORA NCOL ON NCOL.NAVE = MCOL.NAVE) /* retorna naves que realizaram missoes de colonizacao*/
RIGHT JOIN NAVE NV ON NAVE = NV.ID /* right join para incluir com contagem 0 as naves que nao realizaram nenhuma missão*/
GROUP BY NV.NOME


/* CONSULTA 4: Informar o valor total vendido por cada missão de comércio*/

SELECT ME.NOME, SUM(P.PRECO * CP.QUANTIDADE) AS VALOR_VENDAS FROM MISSAO_ESPACIAL ME JOIN MISSAO_COMERCIO MC ON ME.ID = MC.MISSAO /* join com missao espacial para mostrar o nome da missao*/
JOIN COMERCIO_PRODUTO CP ON CP.MISSAO = MC.MISSAO /* obtem produtos comercializados pela missao e a quantidade comercializada*/
JOIN PRODUTO P ON P.NOME  = CP.NOME_PRODUTO AND P.ORIGEM = CP.ORIGEM_PRODUTO /* obtem preco unitario do produto comercilizados*/
WHERE CP.TIPO_COMERCIO = 'Venda' /* filtra somente comercio do tipo venda */
GROUP BY ME.NOME /* agrupa por nome da missao */


/* CONSULTA 5: Listar as missões de todos os tipos com suas naves correspondentes caso a missão já tenha uma nave designada*/

SELECT ME.NOME AS MISSAO, NV.NOME AS NAVE FROM MISSAO_ESPACIAL ME LEFT JOIN /* left join para incluir as missoes sem tipo (comercio, explo., colon.) e também sem nave designada */
(SELECT MCOM.MISSAO, NCOM.NAVE AS NAVE_MISSAO FROM MISSAO_COMERCIO MCOM JOIN NAVE_CARGA NCOM ON NCOM.NAVE = MCOM.NAVE /* busca naves das missoes de comercio */
UNION
SELECT MEXP.MISSAO, NCIEN.NAVE AS NAVE_MISSAO  FROM MISSAO_EXPLORACAO MEXP JOIN NAVE_CIENTIFICA NCIEN ON NCIEN.NAVE = MEXP.NAVE /* busca naves das missoes de exploracao */
UNION
SELECT MCOL.MISSAO, NCOL.NAVE AS NAVE_MISSAO  FROM MISSAO_COLONIZACAO MCOL JOIN NAVE_COLONIZADORA NCOL ON NCOL.NAVE = MCOL.NAVE) /* busca naves das missoes de colonizacao */
ON ME.ID = MISSAO
LEFT JOIN NAVE NV ON NV.ID = NAVE_MISSAO /* left join para incluir as missoes sem nave designada */
ORDER BY ME.NOME, NV.NOME

