package com.tutorial.imagesdyn;

import java.util.ArrayList;
import java.util.List;

// This class simulates some kind of DAO that brings planet data from DB according to
// the location of a user given by its id
public class Cuadrilla_TerrenoLoader {

  // This simulates a query to the DB that returns some DTOs of type Cuadrilla_Terreno
  public static List<Cuadrilla_Terreno> loadData(int userIdInt) {
    List<Cuadrilla_Terreno> ret = new ArrayList<Cuadrilla_Terreno>();

    switch (userIdInt) {
      case 1 :
        // USER 1, some map
        ret.add(new Cuadrilla_Terreno("msn",      60, 60, 0, 0));
        ret.add(new Cuadrilla_Terreno("pulga", 120, 60, 60, 0)); // creo pulga(otro nombre si no no hace el action listener)
        ret.add(new Cuadrilla_Terreno("msn",     180, 60, 120, 0));
        ret.add(new Cuadrilla_Terreno("pulgoso", 240, 60, 180, 0));
        ret.add(new Cuadrilla_Terreno("msn",     300, 60, 240, 0));
        ret.add(new Cuadrilla_Terreno("pulgoso", 360, 60, 300, 0));
               
        // Etc...
        break;
      case 2 :
        // USER 2, some different map
          ret.add(new Cuadrilla_Terreno("pulgoso", 60, 60, 0, 0));
          ret.add(new Cuadrilla_Terreno("msn", 120, 60, 60, 0));
          ret.add(new Cuadrilla_Terreno("pulgoso", 180, 60, 120, 0));
          ret.add(new Cuadrilla_Terreno("msn", 240, 60, 180, 0));
          ret.add(new Cuadrilla_Terreno("pulgoso", 300, 60, 240, 0));
          ret.add(new Cuadrilla_Terreno("msn", 360, 60, 300, 0));
          
        // Etc...
        break;
      default :
        // Empty, black map
        break;
    }

    return ret;
  }
}
