--liquibase formatted sql
--changeset Maxim_Abramov:v1.00_01_create_organizations_table

CREATE TABLE public.organizations
(
    id            SERIAL PRIMARY KEY,
    full_name     VARCHAR NOT NULL,
    name          VARCHAR NOT NULL,
    inn           VARCHAR,
    ogrn          VARCHAR,
    mail_address  VARCHAR NOT NULL,
    legal_address VARCHAR NOT NULL,
    ceo           VARCHAR NOT NULL
);

CREATE INDEX organizations_name_idx ON public.organizations (name);

COMMENT ON TABLE public.organizations IS 'Таблица организаций';
COMMENT ON COLUMN public.organizations.id IS 'Идентификатор организации';
COMMENT ON COLUMN public.organizations.full_name IS 'Полное наименование организации';
COMMENT ON COLUMN public.organizations.name IS 'Краткое наименования организации';
COMMENT ON COLUMN public.organizations.inn IS 'ИНН';
COMMENT ON COLUMN public.organizations.ogrn IS 'ОГРН';
COMMENT ON COLUMN public.organizations.mail_address IS 'Почтовый адрес';
COMMENT ON COLUMN public.organizations.legal_address IS 'Юридический адрес';
COMMENT ON COLUMN public.organizations.ceo IS 'Сведения о генеральном директоре';

--rollback DROP TABLE public.organizations;

--changeset Maxim_Abramov:v1.00_02_create_filials_table

CREATE TABLE public.filials
(
    id           SERIAL PRIMARY KEY,
    full_name    VARCHAR NOT NULL,
    name         VARCHAR NOT NULL UNIQUE,
    mail_address VARCHAR NOT NULL UNIQUE,
    director     VARCHAR NOT NULL,
    org_id       INT REFERENCES organizations (id)
);

CREATE INDEX filials_name_idx ON public.filials (name);

COMMENT ON TABLE public.filials IS 'Таблица филиалов организаций';
COMMENT ON COLUMN public.filials.id IS 'Идентификатор филиала организации';
COMMENT ON COLUMN public.filials.full_name IS 'Полное наименование филиала организации';
COMMENT ON COLUMN public.filials.name IS 'Краткое наименования филиала организации';
COMMENT ON COLUMN public.filials.mail_address IS 'Почтовый адрес';
COMMENT ON COLUMN public.filials.director IS 'Сведения о руководителе';
COMMENT ON COLUMN public.filials.org_id IS 'Идентификатор организации филиала';

--rollback DROP TABLE public.filials;
