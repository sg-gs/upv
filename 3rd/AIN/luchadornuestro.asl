// Trabajo hecho por: Darío Mesas Martí y Sergio Gutiérrez Villalba

  +flag(F): position([X,Y,Z])
  <-
  
  +patrulla;
  if (not hellegadoabandera) {+caminoabandera;};
  if (noammo) {-flag(F);+noammo;} else {

  .goto(F);
  +vuelta(F);
  }.
  //.print("Ejecutando flag(F)").
  
 +vuelta(F): caminoabandera & ammo(A)
 <-
//-caminoabandera;
 .wait(2000); //frecuencia de giro -- importante porque sino se acaba quedando quieto al ser muy baja
 //.print("BOX FERNANDO BOX"); //da un giro
 .stop; //da la vuelta completa, 8 giros de 45 grados cada uno.
     .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 18) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 16) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 14) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 12) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 10) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 8) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 6) {
    +disparomovimiento(F);
    }
    .wait(25);
     .turn(0.785398);
     if (friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 4 ) {
    +disparomovimiento(F);
    }
        .goto(F);
 +flag(F).
  
  +friends_in_fov(ID,Type,Angle,Distance,Health,Position) : ammo(A) & A > 2 
    <-
    .look_at(Position);
    .shoot(2,Position).
 
  
  +disparomovimiento(F): ammo(A) 
  <-
  if (friends_in_fov(ID,Type,Angle,Distance,Health,Position)) {if (A > 10){.look_at(Position);.shoot(2,Position)} else {+noammo;}};
  -disparomovimiento(F);

  if (A > 10) {if (disparomovimiento(F)) {+flag(F)};}
  else{+noammo;}.
  
      
  +target_reached(T): patrulla & ammo(A) & position([X,Y,Z]) & not friends_in_fov(ID,Type,Angle,Distance,Health,Position)
  <-
  .print("hola");
  .turn(0.0025).

  +target_reached(T): patrulla & ammo(A) & position([X,Y,Z]) & friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A > 2
  <-
  +disparar(Position).

  +target_reached(T): patrulla & ammo(A) & position([X,Y,Z]) & friends_in_fov(ID,Type,Angle,Distance,Health,Position) & A < 3
  <-
  .print("No tengo munición!");
  +noammo.
 
  +target_reached(T): patrulla & ammo(A) & position([X,Y,Z])
  <- 
  .print("He llegado a mi destino");
  if (buscandomunicion) {+flag(T);};
  +hellegadoabandera;
  -caminoabandera; // deja de girar
  -target_reached(T).
  
  +disparar(Position) : position([X,Y,Z]) & ammo(A) & A > 1 
  <-
  .look_at(Position);
  .shoot(2, Position);
  -disparar(Position).

  +noammo: packs_in_fov(ID,TYPE,ANGLE,DIST,HEALTH,POSITION)
  <-
  .print("Me voy a por munición");
  +vueltaenfinal;
  .stop;
  .goto(POSITION);.print("función que faltaba 1").
  
  
  +health(X): X < 50 & packs_in_fov(ID,TYPE,ANGLE,DIST,HEALTH,POSITION) //CURARSE
  <-
  .print("Necesito curación!");
  if (TYPE == 1001) {.goto(POSITION);}.
      
      
  +ammo(X): X < 10 & not packs_in_fov(ID,TYPE,ANGLE,DIST,HEALTH,POSITION) //MUNICIÓN PERO SIN VER UN PAQUETE
  <-
  .print("Estoy sin munición, pero no hay ningún paquete cerca");
  +vueltaenfinal.
  
  
  +ammo(X): X < 10 & packs_in_fov(ID,TYPE,ANGLE,DIST,HEALTH,POSITION) //MUNICIÓN PERO VIENDO UN PAQUETE
  <-
  .print("Necesito munición!");
  .stop;
  if (TYPE == 1002) {.goto(POSITION); .print("He encontrado munición!"); +buscandomunicion;}.
    
 
      +vueltaenfinal
      <-
      .print("vueltaenfinal");
      while (not friends_in_fov(ID,Type,Angle,Distance,Health,Position)) {.turn(0.0025);}.
