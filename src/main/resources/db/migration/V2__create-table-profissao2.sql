create table profissao2(

                          id bigint not null auto_increment,
                          nome varchar(100) not null,
                          rg varchar(9) not null unique,
                          idade varchar(2) not null unique,
                          escolaridade varchar(100) not null,
                          profissao varchar(100) not null,
                          rua varchar(100) not null,
                          numero varchar(20),
                          complemento varchar(100),
                          cep varchar(9) not null,
                          bairro varchar(100) not null,
                          cidade varchar(100) not null,
                          uf char(2) not null,

                          primary key(id)

);