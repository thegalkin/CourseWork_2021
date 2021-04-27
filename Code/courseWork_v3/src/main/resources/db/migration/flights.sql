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
)