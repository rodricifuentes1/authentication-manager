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