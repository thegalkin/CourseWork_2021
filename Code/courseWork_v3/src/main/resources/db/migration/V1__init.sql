create table employees(
    id bigserial primary key,
    name text,
    secondName text,
    lastName text,
    licenses text[],
    role text,
    countryOfOrigin text,
    visas text[]
);
create table flights(
                        id bigserial primary key,
                        flightName text,
                        planeId text,
                        prevFlightName text,
                        startTime timestamp,
                        endTime timestamp,
                        planeModel text,
                        startCountry text,
                        endCountry text,
                        startCity text,
                        endCity text,
                        passengersAmount int
);