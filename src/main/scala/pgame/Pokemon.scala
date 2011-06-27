package pgame

case class Pokemon(name: String, attacks: Set[Attack.Value], types: Set[PokemonType.Value])

object Attack extends Enumeration {
  val ELEMENTAL_BOLT, SURF, THUNDERBOLT, ELEMENTAL_PYLON = Value
}

object PokemonType extends Enumeration {
  val FIRE, WATER, STEEL, DRAGON, ELECTRIC, ELEMENTAL = Value
}