package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Master Quest!")

  val iceDragon = Pokemon("Kyuri", Set(Attack.FLY, Attack.ICE_BLADE, Attack.PROTECT, Attack.ICE_BEAM),
    Set(PokemonType.ICE, PokemonType.DRAGON, PokemonType.FLYING), "Kyuro")

  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON, Attack.ELEMENTAL_BOLT, Attack.PROTECT, Attack.ELEMENTAL_BLAST), Set(PokemonType.ELEMENTAL), "Elemental")
  val daniel = Trainer("daniel", Set(e, iceDragon))

  val je = Pokemon("Jelemental", Set(Attack.ELEMENTAL_RING, Attack.ELEMENTAL_PAW, Attack.BUSHY_TAIL,
    Attack.HEAD_BUT), Set(PokemonType.ELEMENTAL), "Jelemental")
  val joe = Trainer("joe", Set(je))

  val name = readLine("Type in your name: ")

  val trainer = if (name == daniel.name) daniel else if (name == joe.name) joe else null

  if (trainer == null) {
    println("Sorry, the computer does not know who you are.")
  } else {
    println("Welcome: " + trainer)
  }
}