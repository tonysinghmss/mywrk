CREATE SEQUENCE mywrk.logins_seq;
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

CREATE SEQUENCE mywrk.memberships_seq;
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

CREATE SEQUENCE mywrk.privileges_seq;
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
CREATE SEQUENCE mywrk.roles_seq;
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
CREATE SEQUENCE mywrk.roles_privileges_seq;
CREATE TABLE mywrk.roles_privileges
(
  rlspriv_id bigint,
  role_id bigint,
  privilege_id bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE mywrk.roles_privileges
  OWNER TO tony;
CREATE SEQUENCE mywrk.users_seq;
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
CREATE SEQUENCE mywrk.invoicelineitems_seq;
CREATE TABLE mywrk.invoicelineitems
(
    invoicelineitem_id bigint,
    related_invoice_id bigint,
    price numeric(10, 2)
)
WITH (
    OIDS = FALSE
)
;

ALTER TABLE mywrk.invoicelineitems
    OWNER to tony;

CREATE SEQUENCE mywrk.invoices_seq;
CREATE TABLE mywrk.invoices
(
    invoice_id bigint,
    description text
)
WITH (
    OIDS = FALSE
)
;

ALTER TABLE mywrk.invoices
    OWNER to tony;
CREATE SEQUENCE mywrk.orderlineitems_seq;    
CREATE TABLE mywrk.orderlineitems
(
    orderlineitem_id bigint,
    related_order_id bigint,
    related_work_id bigint,
    order_number integer,
    invoicelineitem_id bigint,
    paid boolean
)
WITH (
    OIDS = FALSE
);

ALTER TABLE mywrk.orderlineitems
    OWNER to tony;
CREATE SEQUENCE mywrk.orders_seq;
CREATE TABLE mywrk.orders
(
    order_id bigint,
    related_user_id bigint,
    order_dttm timestamp without time zone,
    required_date timestamp without time zone,
    fulfilled boolean,
    paid boolean
)
WITH (
    OIDS = FALSE
)
;

ALTER TABLE mywrk.orders
    OWNER to tony;

CREATE SEQUENCE mywrk.payments_seq;
CREATE TABLE mywrk.payments
(
    payment_id bigint,
    related_user_id bigint,
    related_invoice_id bigint,
    amount_paid numeric(10, 2),
    paid_on timestamp without time zone
)
WITH (
    OIDS = FALSE
);

ALTER TABLE mywrk.payments
    OWNER to tony;
CREATE SEQUENCE mywrk.work_category_seq;    
CREATE TABLE mywrk.work_category
(
    work_category_id bigint,
    category_name text COLLATE "default".pg_catalog,
    description text COLLATE "default".pg_catalog,
    created_by bigint,
    creation_dttm timestamp without time zone
)
WITH (
    OIDS = FALSE
);

ALTER TABLE mywrk.work_category
    OWNER to tony;
   
 CREATE SEQUENCE mywrk.work_status_seq;  
CREATE TABLE mywrk.work_status
(
    work_status_id bigint,
    fulfilled boolean,
    last_worked_on timestamp without time zone
)
WITH (
    OIDS = FALSE
);

ALTER TABLE mywrk.work_status
    OWNER to tony;
    
CREATE SEQUENCE mywrk.works_seq;
CREATE TABLE mywrk.works
(
    work_id bigint,
    related_work_category_id bigint,
    related_work_status_id bigint,
    work_created_on timestamp without time zone
)
WITH (
    OIDS = FALSE
);

ALTER TABLE mywrk.works
    OWNER to tony;