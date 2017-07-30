CREATE TABLE mywrk.logins
(
  login_id bigint,
  user_id bigint,
  user_name text,
  password_hash character(60)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.logins
  OWNER TO tony;


CREATE TABLE mywrk.memberships
(
  membership_id bigint,
  related_role_id bigint,
  related_user_id bigint,
  email_addrs text,
  phone_number text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.memberships
  OWNER TO tony;


CREATE TABLE mywrk.privileges
(
  privilege_id bigint,
  privilege_name text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.privileges
  OWNER TO tony;

CREATE TABLE mywrk.roles
(
  role_id bigint,
  role_name text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.roles
  OWNER TO tony;

CREATE TABLE mywrk.roles_privileges
(
  role_id bigint,
  privilege_id bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.roles_privileges
  OWNER TO tony;

CREATE TABLE mywrk.users
(
  user_id bigint,
  first_name text,
  last_name text,
  user_name text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.users
  OWNER TO tony;

