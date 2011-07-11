package pgame

case class Pokemon(name: String, attacks: Set[Attack.Value], types: Set[PokemonType.Value]) {

  override def toString = "Pokemon(name: %s, attacks: (%s), types: %s)".
    format(name, attacks.mkString(","), types.mkString(","))

}

object Attack extends Enumeration {
  val ELEMENTAL_BOLT, SURF, THUNDERBOLT, ELEMENTAL_PYLON, ELEMENTAL_RING = Value
}

object PokemonType extends Enumeration {
  val FIRE, WATER, STEEL, DRAGON, ELECTRIC, ELEMENTAL = Value
}