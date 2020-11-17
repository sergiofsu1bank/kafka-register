# kafka-register

-- Applicacao-------------------------------------------------
Baixar o Código Fonte:
git clone https://github.com/sergiofsu1bank/kafka-register.git

Para roda a aplicação:
- Gerar os Stubs/Pojos via maven
mvn clean package
- Rodar a aplicação
mvn spring-boot:run


-- Conatiner-------------------------------------------------
Pré Requisito
----------------------------
- Docker e Docker-Compose devidamente instalado.
- Iniciando o docker
  docker run -d -p 80:80 docker/getting-started


Realizando a instalação
---------------------------
- Criar uma pasta local e adicionar o docker-compose.yml
- Verificar a tag:
  KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://broker:9092,PLAINTEXT_HOST://192.168.0.109:29092
  Substituir o IP pelo o IP da maquina onde esta rodando o Kafka

- Instalando os containers
-------------------------- 
//list only ids containers
docker ps -aq

//stop all containers
docker stop $(docker ps -aq)

//remove all containers
docker rm $(docker ps -aq)

//remve all images
docker rmi -f $(docker images -q)

docker-compose up -d ou se quizer compilar localmente
docker-compose up -d --build

Instalando IDE Kafka (Opcional)
--------------------
docker run -it -p 80:80 xeotek/kadeck-allinone:latest
Após a instalação, digite: http://localhost:80	

Acessando KSDQLDB
-----------------
docker exec -it ksqldb-cli ksql http://ksqldb-server:8088 

Selecionar a partir do primeiro registro
----------------------------------------
set 'auto.offset.reset' = 'earliest';

Imprimir os dados dos tópicos
-----------------------------
print siestabcoml from beginning;
print siidentificador from beginning;

Criando Streams
---------------
create stream st_identificador
	(idIdent string, idEcGrupo string key, tipoIdent string, dataAlteracao string, placa string, ativo string, bloqTemp string, bloqSaldo string)
with (kafka_topic='siidentificador', 
      value_format='json');
	  
create stream st_estabComercial
	(idEcGrupo string key, idEc string, tipoEc string, dataAlteracao string, liberado string)
with (kafka_topic='siestabcoml', 
      value_format='json');

Visualizando os dados das Strems
--------------------------------
select *
from st_identificador
emit changes limit 3;

select *
from st_estabComercial
emit changes limit 3;

select 	ide.idIdent, 
		ide.idEcGrupo, 
		ide.tipoIdent, 
		ide.dataAlteracao, 
		ide.placa, 
		ide.ativo, 
		ide.bloqTemp, 
		ide.bloqSaldo,
		est.idEcGrupo, 
		est.idEc, 
		est.tipoEc, 
		est.dataAlteracao, 
		est.liberado
from st_identificador ide inner join st_estabComercial est
     within 7 days
	 on ide.idEcGrupo = est.idEcGrupo
	 EMIT CHANGES
	 LIMIT 3;

Construindo Join a partir de 2 Streams
--------------------------------------				
create stream st_join_iden_est as 
select 	ide.idIdent, 
		ide.idEcGrupo, 
		ide.tipoIdent, 
		ide.dataAlteracao, 
		ide.placa, 
		ide.ativo, 
		ide.bloqTemp, 
		ide.bloqSaldo,
		est.idEcGrupo, 
		est.idEc, 
		est.tipoEc, 
		est.dataAlteracao, 
		est.liberado
from st_identificador ide				
	 inner join st_estabComercial est
     within 7 days
	 on ide.idEcGrupo = est.idEcGrupo
emit changes;


Criando tabelas
---------------
create table tb_estab_ident_join
  (ide_idecgrupo string primary key,
   idident string,
   tipoident string,
   ide_dataalteracao string,
   placa string,  
   ativo string, 
   bloqtemp string,  
   bloqsaldo string,
   idec string,
   tipoec string,
   est_dataalteracao string,
   liberado string)	
with (kafka_topic='ST_JOIN_IDEN_EST', 
      value_format='json');

create table tb_identificador
	(idIdent string, idEcGrupo string primary key, tipoIdent string, dataAlteracao string, placa string, ativo string, bloqTemp string, bloqSaldo string)
with (kafka_topic='siidentificador', 
      value_format='json');
	  
create table tb_estabComercial
	(idEcGrupo string primary key, idEc string, tipoEc string, dataAlteracao string, liberado string)
with (kafka_topic='siestabcoml', 
      value_format='json');

create table tb_jn_ide_estab_count_v1 as
select  ide.idEcGrupo, 
		COUNT(*) AS TOTAL
from tb_identificador ide
     FULL OUTER join tb_estabComercial est
	 on ide.idEcGrupo = est.idEcGrupo
group by ide.idEcGrupo
emit changes;


Visualizando Dados
------------------
select * from tb_identificador emit changes;
select * from tb_estabComercial emit changes;
select * from st_identificador emit changes;
select * from st_estabComercial emit changes;
select * from st_join_iden_est emit changes;
select * from tb_jn_ide_estab_count_v1 emit changes;

Detalhes dos Asset
------------------ 
describe extended tb_estabComercial;
describe extended stream_estabComercial_in;
describe extended stream_join_iden_est;
describe extended tb_jn_ide_estab_count;
