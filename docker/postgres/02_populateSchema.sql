-- DEFAULT ACTIONS --
INSERT INTO public."ACTIONS" ( "NAME" ) values ( 'CREATE' );
INSERT INTO public."ACTIONS" ( "NAME" ) values ( 'READ' );
INSERT INTO public."ACTIONS" ( "NAME" ) values ( 'UPDATE' );
INSERT INTO public."ACTIONS" ( "NAME" ) values ( 'DELETE' );

-- DEFAULT RESOURCES --
INSERT INTO public."RESOURCES" ("NAME", "DESCRIPTION") values ( 'USER', 'Resource that represents application users');

-- DEFAULT PERMISSIONS --
INSERT INTO public."PERMISSIONS" ("ACTION_ID", "RESOURCE_ID") values ( 1, 1 );

-- DEFAULT ROLES --
INSERT INTO public."ROLES" ("NAME", "IP_FILTER") values ( 'ADMINISTRADOR', false );

-- DEFAULT ROLES_PERMISSIONS --
INSERT INTO public."ROLES_PERMISSIONS" ("ROLE_ID", "PERMISSION_ID") values ( 1, 1 );