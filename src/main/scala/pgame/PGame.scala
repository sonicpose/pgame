package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Master Quest!")

  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON), Set(PokemonType.ELEMENTAL))
  val daniel = Trainer("daniel", Set(e))

  val je = Pokemon("Jelemental", Set(Attack.ELEMENTAL_RING), Set(PokemonType.ELEMENTAL))
  val joe = Trainer("joe", Set(je))

  val name = readLine("Type in your name: ")

  val trainer = if (name == daniel.name) daniel else if (name == joe.name) joe else null

  if (trainer == null) {
    println("Sorry, the computer does not know who you are.")
  } else {
    println("Welcome: " + trainer)
  }
}