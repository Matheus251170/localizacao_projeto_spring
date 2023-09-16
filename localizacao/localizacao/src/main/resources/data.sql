create table tbl_cidade (
    id bigint not null primary key,
    nome_cidade varchar(50) not null,
    qtd_habitantes bigint
);

insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (1, 'São Paulo', 123456789);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (2, 'Rio de Janeiro', 456387778);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (3, 'Santa Catarina', 7864887);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (4, 'Minas Gerais', 6545646);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (5, 'Curitiba', 8975435);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (6, 'Cuiaba', 7895528697);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (7, 'Acre', 6545798646);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (8, 'Pernambuco', 6567545646);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (9, 'Belo Horizonte', 7986545646);
insert into tbl_cidade (id, nome_cidade, qtd_habitantes) values (10, 'Fortaleza', 45545646);