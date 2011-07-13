package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Master Quest!")

  // Daniel's
  val iceDragon = Pokemon("Kyuri", Set(Attack.FLY, Attack.ICE_BLADE, Attack.PROTECT, Attack.ICE_BEAM),
    Set(PokemonType.ICE, PokemonType.DRAGON, PokemonType.FLYING), "Kyuro")
  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON, Attack.ELEMENTAL_BOLT, Attack.PROTECT, Attack.ELEMENTAL_BLAST), Set(PokemonType.ELEMENTAL), "Elemental")
  val daniel = Trainer("daniel", Set(e, iceDragon))

  // Joe's
  val pi = Pokemon("Pigno", Set(Attack.FLAME_PUNCH, Attack.FIRE_SPIN, Attack.FLAME_WHEEL, Attack.HEAD_BUT),
    Set(PokemonType.FIRE, PokemonType.FIGHTING), "Pigno")
  val je = Pokemon("Jelemental", Set(Attack.ELEMENTAL_RING, Attack.ELEMENTAL_PAW, Attack.BUSHY_TAIL,
    Attack.HEAD_BUT), Set(PokemonType.ELEMENTAL), "Jelemental")
  val joe = Trainer("joe", Set(je, pi))

  var player1: Trainer = _
  do {
    val player1Name = readLine("Player 1 type in your name: ")
    player1 = if (player1Name == daniel.name) daniel else if (player1Name == joe.name) joe else null
  } while (player1 == null)

  println("Player 1 is %s".format(player1))

  var player2: Trainer = _
  do {
    val player2Name = readLine("Player 2 type in your name: ")
    player2 = if (player2Name == daniel.name) daniel else if (player2Name == joe.name) joe else null
  } while (player2 == null)

  println("Player 2 is %s".format(player2))


  println("%s choose your Pokemon".format(player1.name))

  player1.pokemon.toSeq.zipWithIndex.map {
    case (p, i) =>
      println("  %d: %s".format(i, p.nickname))
  }
  val player1choice = readLine("Choice: ")
  val pokemon1 = player1.pokemon.toSeq(player1choice.toInt)
  println("You have chosen %s".format(pokemon1))
}