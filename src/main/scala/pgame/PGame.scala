package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Master Quest!")

  val daniel = Trainer("daniel")
  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON), Set(PokemonType.ELEMENTAL))

  val name = readLine("Type in your name: ")

  val trainer = if (name == daniel.name) daniel else null

  println("Welcome: " + trainer)
}