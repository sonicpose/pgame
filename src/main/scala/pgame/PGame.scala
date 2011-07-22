package pgame

object PGame extends App {
    
  println("Welcome to Pokemon Master Quest!")

  // Daniel's
  val iceDragon = Pokemon("Kyuro", Set(Attack.FLY, Attack.ICE_BLADE, Attack.PROTECT, Attack.ICE_BEAM),
    Set(PokemonType.ICE, PokemonType.DRAGON, PokemonType.FLYING), "Kyuro", level = 100, healthPoints = 99980)
  val e = Pokemon("Elemental", Set(Attack.ELEMENTAL_PYLON, Attack.ELEMENTAL_BOLT, Attack.PROTECT,
    Attack.ELEMENTAL_BLAST), Set(PokemonType.ELEMENTAL), "Elemental", level = 100, healthPoints = 99990)
  val ss = Pokemon("Sword-slash", Set(Attack.FLY, Attack.SWORD_ATTACK, Attack.SURF,Attack.SWORD_THROWER),
  Set(PokemonType.WATER, PokemonType.FLYING, PokemonType.STEEL), "Sword-Slash", level = 100, healthPoints = 99990)

  val daniel = Trainer("daniel", Set(e, iceDragon, ss))


  // Joe's
  val pi = Pokemon("Pigno", Set(Attack.FLAME_PUNCH, Attack.FIRE_SPIN, Attack.FLAME_WHEEL, Attack.HEAD_BUT),
    Set(PokemonType.FIRE, PokemonType.FIGHTING), "Pigno", level = 100, healthPoints = 99990)
  val je = Pokemon("Jelemental", Set(Attack.ELEMENTAL_RING, Attack.ELEMENTAL_PAW, Attack.BUSHY_TAIL,
    Attack.HEAD_BUT), Set(PokemonType.ELEMENTAL), "Jelemental", level = 100, healthPoints = 99990)
  val resh = Pokemon("reshirack", Set(Attack.FLAMING_BEAK, Attack.FLY, Attack.FLAME_WHEEL, Attack.FLAME_ROLL),
  Set(PokemonType.FIRE, PokemonType.FLYING), "Reshirak", level = 100, healthPoints = 99990)

  val joe = Trainer("joe", Set(je, pi, resh))

  // Stuart's
  val stom = Pokemon("omant", Set(Attack.PROTECT, Attack.PSYCHIC, Attack.PSYCHIC_BOLT, Attack.BODY_SLAM),
  Set(PokemonType.PSYCHIC, PokemonType.WATER), "Stomant", level = 90, healthPoints = 99910)
  val stuart = Trainer("stuart", Set(stom))

  val allTrainers = Set(daniel, joe, stuart)

  def choosePlayer(number: Int): Trainer = {
    var player: Trainer = null
    do {
      val playerName = readLine("Player %d type in your name: ".format(number))
      player = allTrainers.find(_.name == playerName).getOrElse(null)
    } while (player == null)
    player
  }

  var player1 = choosePlayer(1)
  println("Player 1 is %s".format(player1))

  var player2 = choosePlayer(2)
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

  var p1 = pokemon1
  var p2 = pokemon2

  do {

    val attack1 = chooseAttack(player1, p1)
    println("You have chosen %s".format(attack1))

    val attack2 = chooseAttack(player2, p2)
    println("You have chosen %s".format(attack2))

    val damage1 = damageDone(p1.level)
    val damage2 = damageDone(p2.level)

    p1 = p1.copy(healthPoints = p1.healthPoints - damage2)
    p2 = p2.copy(healthPoints = p2.healthPoints - damage1)

    println("%s HP = %d".format(p1.nickname, p1.healthPoints))
    println("%s HP = %d".format(p2.nickname, p2.healthPoints))

  } while (p1.healthPoints > 0 && p2.healthPoints > 0)

}