create table employees(
    id bigserial primary key,
    name text,
    secondName text,
    lastName text,
    licenses text[],
    role text,
    countryOfOrigin text,
    visas text[]
)