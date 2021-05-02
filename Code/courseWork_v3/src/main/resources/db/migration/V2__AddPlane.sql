create table planes(
    id bigserial primary key,
    internationalNumber text,
    russianNumber text,
    boardName text,
    model text,
    repairHistory text[],
    ownerCompany text,
    humanCapacity smallint,
    personnelCapacity smallint,
    baggageCapacity smallint,
    flightHistory bigint[]
);

ALTER TABLE flights
    ADD COLUMN seatsNumbers smallint[],
    ADD COLUMN seatsFullNames text[],
    ADD COLUMN personnelIds bigint[],
    ADD COLUMN baggageIds bigint[];



CREATE TABLE baggage(
    id bigserial primary key,
    ownerFullName text,
    flightId bigserial,
    targetFlightName text,
    startCountry text,
    middleCountries text[],
    endCountry text
);
