flight(barcelona,madrid,
       date(10,nov,2030),time(13,05),
       date(10,nov,2030),time(15,05),
       120,80).
flight(barcelona,valencia,
       date(10,nov,2030),time(13,05),
       date(10,nov,2030),time(15,05),
       120,20).
flight(madrid,london,
       date(10,nov,2030),time(16,05),
       date(10,nov,2030),time(17,35),
       90,140).
flight(valencia,london,
       date(10,nov,2030),time(16,05),
       date(10,nov,2030),time(17,35),
       90,50).
flight(madrid,london,
       date(10,nov,2030),time(23,05),
       date(11,nov,2030),time(00,25),
       80,50).

connection_same_day(Origin,Destination,Date):- 
    flight(Origin,Connection,Date,_,Date,time(Hl1,Ms1),_,_),
    flight(Connection,Destination,Date,time(Hs2,Ms2),Date,_,_,_),
    Hl1_in_minutes is Hl1 * 60 + Ms1 + 60,
    Hs2_in_minutes is Hs2 * 60 + Ms2,
    Hl1_in_minutes =< Hs2_in_minutes.

/** 
Ex 11 
  In swipl: flight(valencia, london, DepartureDay, DepartureTime, ArrivalDay, ArrivalTime, Duration, Price).
**/

/**
Ex 12
  In swipl: flight(madrid, Destination, date(10, nov, 2030), ArrivalDay, DepartureTime, ArrivalTime, Duration, Price).
  In swipl: flight(Origin, Destination, DepartureDay, time(13, 05), ArrivalDay, ArrivalTime, Duration, Price).
  In swipl: flight(Origin, Destination, DepartureDay, time(H, M), ArrivalDay, ArrivalTime, Duration, Price), H >=16.
**/

/**
Ex 13
  In swipl: connection_same_day(Origin,Destination,date(10, nov, 2030)).
**/

/**
Ex 14
  The list obtained will return flights that have the same day of departure and arrival day in the Origin, Connection and Destination, or with with a different
  day of arrival day for the destination
**/
