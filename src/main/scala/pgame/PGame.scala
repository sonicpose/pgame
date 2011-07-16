package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Master Quest!")

  // Daniel's
  val iceDragon = Pokemon("Kyuru", Set(Attack.FLY, Attack.ICE_BLADE, Attack.PROTECT, Attack.ICE_BEAM),
    Set(PokemonType.ICE, PokemonType.DRAGON, PokemonType.FLYING), "Kyuro", level = 92, healthPoints = 99960)
  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON, Attack.ELEMENTAL_BOLT, Attack.PROTECT,
    Attack.ELEMENTAL_BLAST), Set(PokemonType.ELEMENTAL), "Elemental", level = 100, healthPoints = 99990)
  val daniel = Trainer("daniel", Set(e, iceDragon))

  // Joe's
  val pi = Pokemon("Pigno", Set(Attack.FLAME_PUNCH, Attack.FIRE_SPIN, Attack.FLAME_WHEEL, Attack.HEAD_BUT),
    Set(PokemonType.FIRE, PokemonType.FIGHTING), "Pigno", level = 100, healthPoints = 99990)
  val je = Pokemon("Jelemental", Set(Attack.ELEMENTAL_RING, Attack.ELEMENTAL_PAW, Attack.BUSHY_TAIL,
    Attack.HEAD_BUT), Set(PokemonType.ELEMENTAL), "Jelemental", level = 100, healthPoints = 99990)
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


  def choosePokemon(player: Trainer): Pokemon = {
    println("%s choose your Pokemon".format(player.name))

    player.pokemon.toSeq.zipWithIndex.map {
      case (p, i) =>
        println("  %d: %s".format(i, p.nickname))
    }
    val playerChoice = readLine("Choice: ")
    val pokemon = player.pokemon.toSeq(playerChoice.toInt)
    return pokemon
  }

  def chooseAttack(player: Trainer, pokemon: Pokemon): Attack.Value = {
    println("%s choose your attack".format(player.name))

    pokemon.attacks.map { a =>
        println("  %d: %s".format(a.id, a.toString))
    }
    val playerChoice = readLine("Choice: ")
    val attack = Attack(playerChoice.toInt)
    return attack
  }

  def damageDone(pokemonLevel: Int) = pokemonLevel * 49

  val pokemon1 = choosePokemon(player1)
  println("You have chosen %s".format(pokemon1))

  val pokemon2 = choosePokemon(player2)
  println("You have chosen %s".format(pokemon2))

  val attack1 = chooseAttack(player1, pokemon1)
  println("You have chosen %s".format(attack1))

  val attack2 = chooseAttack(player2, pokemon2)
  println("You have chosen %s".format(attack2))

  val damage1 = damageDone(pokemon1.level)
  println("Damage done to %s's pokemon = %d HP".format(player2.name, damage1))

  val damage2 = damageDone(pokemon2.level)
  println("Damage done to %s's pokemon = %d HP".format(player1.name, damage2))


}