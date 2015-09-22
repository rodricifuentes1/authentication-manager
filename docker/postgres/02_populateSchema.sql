-- DEFAULT ACTIONS --
INSERT INTO public."ACTIONS" ( "NAME", "DESCRIPTION" ) values ( "*", "Any action for a given resource type" ); -- ID 1 --
INSERT INTO public."ACTIONS" ( "NAME", "DESCRIPTION" ) values ( "CREATE", "Creates a new element of a given resource type" ); -- ID 2 --
INSERT INTO public."ACTIONS" ( "NAME", "DESCRIPTION" ) values ( "READ", "Reads an existing element of a given resource type" ); -- ID 3 --
INSERT INTO public."ACTIONS" ( "NAME", "DESCRIPTION" ) values ( "UPDATE", "Updates an existing element of a given resource type" ); -- ID 4 --
INSERT INTO public."ACTIONS" ( "NAME", "DESCRIPTION" ) values ( "DELETE", "Deletes an existing element of a given resource type" ); -- ID 5 --

-- DEFAULT RESOURCES --
INSERT INTO public."RESOURCES" ( "NAME", "DESCRIPTION" ) values ( "*", "Any resource available in the application" ); -- ID 1 --

-- DEFAULT PERMISSIONS --
INSERT INTO public."PERMISSIONS" ( "ACTION_ID", "RESOURCE_ID" ) values ( 1, 1 ); -- ID 1 --

-- DEFAULT ROLES --
INSERT INTO public."ROLES" ( "NAME", "IP_FILTER" ) values ( "SUPERUSER", false ); -- ID 1 --

-- DEFAULT ROLES_PERMISSIONS --
INSERT INTO public."ROLES_PERMISSIONS" ( "ROLE_ID", "PERMISSION_ID" ) values ( 1, 1 ); -- ID 1 --

-- DEFAULT GENDERS --
INSERT INTO public."GENDERS" ( "NAME", "DESCRIPTION" ) values ( "MALE", "Gender representation for men" ); -- ID 1 --
INSERT INTO public."GENDERS" ( "NAME", "DESCRIPTION" ) values ( "FEMALE", "Gender representation for women" ); -- ID 2 --

-- DEFAULT IDENTIFICATION TYPES --
INSERT INTO public."IDENTIFICATION_TYPES" ( "NAME", "ABBREVIATION", "DESCRIPTION" ) values ( "Cédula de ciudadanía", "CC", "Documento de identificación personal de los ciudadanos mayores de edad" ); -- ID 1 --
INSERT INTO public."IDENTIFICATION_TYPES" ( "NAME", "ABBREVIATION", "DESCRIPTION" ) values ( "Cédula de extranjería", "CE", "Documento de identificación personal de los ciudadanos extranjeros en el territorio" ); -- ID 2 --
INSERT INTO public."IDENTIFICATION_TYPES" ( "NAME", "ABBREVIATION", "DESCRIPTION" ) values ( "NIT", "NIT", "Número de identificación tributario para empresas" ); -- ID 3 --
INSERT INTO public."IDENTIFICATION_TYPES" ( "NAME", "ABBREVIATION", "DESCRIPTION" ) values ( "Pasaporte", "PAS", "Documento de autorización para ingresar y/o entrar al país" ); -- ID 4 --