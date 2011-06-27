package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Distortion!")

  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON), Set(PokemonType.ELEMENTAL))

  println(e)
}