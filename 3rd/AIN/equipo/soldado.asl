//TEAM_ALIED

+flag (F): team(100)
  <-
  .get_fieldops.

+myFieldops(Fieldops_list)
<-
  ?flag(F);
  .determinar_posiciones(F, Fieldops_list, R);
  .look_at(F);

  for(.member(S,R)) {
    .nth(0,S,ID);
    .nth(1,S,X);
    .nth(2,S,Y);
    .nth(3,S,Z);

    .print("CAPTAIN: SOLDIER ", ID, "GO TO", [X,Y,Z], "NOW!");

    .send(ID, tell, nueva_posicion([X,Y,Z]));
  }
  
  +watching_soldiers.

+watching_soldiers
<-
  .get_service("still_alive");
  .wait(5000);
  +watching_soldiers.

+still_alive(A)
<-
  .print("Agents", A, "are alive").

+flag_taken: team(100)
<-
  ?base(B);
  .goto(B).

/*
+target_reached(T): patrolling & team(200)
  <-
  ?patroll_point(P);
  -+patroll_point(P+1);
  -target_reached(T).

+patroll_point(P): total_control_points(T) & P<T
  <-
  ?control_points(C);
  .nth(P,C,A);
  .goto(A).

+patroll_point(P): total_control_points(T) & P==T
  <-
  -patroll_point(P);
  +patroll_point(0).


//TEAM_ALLIED

+flag (F): team(100)
  <-
    
  .goto(F).

+flag_taken: team(100)
  <-
  .print("In ASL, TEAM_ALLIED flag_taken");
  ?base(B);
  +returning;
  .goto(B);
  -exploring.

+heading(H): exploring
  <-
  .wait(2000);
  .turn(0.375).

//+heading(H): returning
//  <-
//  .print("returning").

+target_reached(T): team(100)
  <-
  .print("target_reached");
  +exploring;
  .turn(0.375).

+enemies_in_fov(ID,Type,Angle,Distance,Health,Position)
  <-
  .shoot(3,Position).

  */