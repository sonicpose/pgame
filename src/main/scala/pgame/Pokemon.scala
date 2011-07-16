package pgame

case class Pokemon(name: String,
                   attacks: Set[Attack.Value],
                   types: Set[PokemonType.Value],
                   nickname: String,
                   level: Int = 1,
                   healthPoints: Int = 11,
                   evolutionLevel: Option[Int] = None) {

  override def toString = "Pokemon(nickname: %s, attacks: (%s), types: %s)".
    format(nickname, attacks.mkString(","), types.mkString(","))

}

object Attack extends Enumeration {
  val ELEMENTAL_BOLT, SURF, THUNDERBOLT, ELEMENTAL_PYLON, ELEMENTAL_RING,
      FLY, PROTECT, ICE_BLADE, ICE_BEAM, ELEMENTAL_PAW, BUSHY_TAIL, HEAD_BUT,
      ELEMENTAL_BLAST, FLAME_PUNCH, FIRE_SPIN, FLAME_WHEEL = Value
}

object PokemonType extends Enumeration {
  val FIRE, WATER, STEEL, DRAGON, ELECTRIC, ELEMENTAL, ICE, FLYING, FIGHTING = Value
}