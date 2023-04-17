alter table medicos add ativo tinyint;
update medicos set ativo = 1;
alter table medicos MODIFY ativo tinyint not null;