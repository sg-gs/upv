//TEAM_ALLIED

+nueva_posicion(P)
<-
  ?flag(F);
  .register_service("still_alive");

  if (F == P) {
    +lure;
  } else {
    -lure;
    .print("YES SIR! GOING TO", P);
    .goto(P);
    +he_llegado(P);
  }.

+he_llegado(P): position([X,Y,Z])
<-
  .nth(0,P,P_X);
  .nth(2,P,P_Z);

  -he_llegado;

  if (X == P_X & Z == P_Z) {
    .print("HE LLEGADO A MI POSICION!");
    ?flag(F);
    .look_at(F);
    .get_fieldops;
  } else {
    .wait(5000);
    +he_llegado(P);
  }.
  
+myFieldops(Fieldops_list): not lure
<-
  ?flag(F);
  ?name(MY_ID);

  for(.member(S_ID,Fieldops_list)) {
    if (S_ID == MY_ID) {
      // no op
    } else {
      .send(S_ID, tell, lure_can_attack);
    }
  }.


+start_attack: not lure & not attacking
<-
  .print("TO THE FIGHT!");
  +attacking;
  ?flag(F);
  .goto(F).

+lure_can_attack: lure & not attacking
<-
  .print("I AM LURE AND I WILL ATACK");
  ?flag(F);
  .goto(F).


+myFieldops(Fieldops_list): lure
<-
  ?name(MY_ID);

  for(.member(S_ID,Fieldops_list)) {
    if (S_ID == MY_ID) {
      .print("LURE SOLDIER: ATTACKING!");
    } else {
      .send(S_ID, tell, start_attack);
    }
  }.

+enemies_in_fov(ID,Type,Angle,Distance,Health,Position): lure & not attacking
  <-
  +attacking;
  .print("LURE: ENEMIES SEEN, CALLING REINFORCES");
  .get_fieldops;
  .shoot(3,Position).

+flag_taken: team(100)
<-
  .print("SOLDIER: FLAG TAKEN. RETURNING");
  +got_flag;
  ?base(B);
  .get_fieldops;
  .goto(B).

+myFieldops(Fieldops_list): got_flag
<-
  .print("HERe");
  ?name(MY_ID);

  for(.member(S_ID,Fieldops_list)) {
    if (S_ID == MY_ID) {
      .print("SOLDIER: PROTECT ME!");
    } else {
      .send(S_ID, tell, retreat);
    }
  }.

+retreat
<-
  .print("Returning!!");
  +returning.

+retreat: returning
<- 
  .print("Returning & stopping!!");
  -returning;
  ?base(B);
  .goto(B);
  .wait(2000);
  +returing.

+enemies_in_fov(ID,Type,Angle,Distance,Health,Position): attacking
<-
  .shoot(3,Position).

+target_reached(T): not(pedidaayuda)
<-
  .print("Necesito curación!!!");
  +pedidaayuda;
  .get_medics.

+myMedics(M): pedidaayuda
<-
  .print("estoy pidiendo ayuda");
  ?position(Pos);
  +bids([]);
  +agents([]);
  .send(M,tell,savemeproposal(Pos));
  .wait(1000);
  !!elegirmejor;
  -myMedics(_).

+mybid(Pos)[source(A)]: pedidaayuda 
<-
  .print("Recibo propuesta");
  ?bids(B);
  .concat(B,[Pos],B1); -+bids(B1);
  ?agents(Ag);
  .concat(Ag,[A],Ag1); -+agents(Ag1);
  -mybid(Pos).


+!elegirmejor: bids(Bi) & agents(Ag)
<-
  .print("Selecciono el mejor: ", Bi, Ag);
  .length(Bi,X);

  if (X == 0) {
   
  } else {
    .nth(0, Bi, Pos); // no elijo el mejor, me quedo con el primero
    .nth(0, Ag, A);
    .send(A, tell, acceptproposal);
    .delete(0, Ag, Ag1);
    .send(Ag1, tell, cancelproposal);
    -+bids([]);
    -+agents([]);
  }.
  
