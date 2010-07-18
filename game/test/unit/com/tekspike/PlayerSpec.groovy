package com.tekspike

class PlayerSpec extends BaseUnitSpec {
  def "domain mocking"() {
      setup:
      mockDomain(Player)

      when:
      new Player(name: name, dateOfBirth : dateOfBirth, pos: pos, gameType : gameType).save()

      then:
      Player.findByName(name) != null

      where:
      name = "bill"
      dateOfBirth = new Date()
      pos = "Forward"
      gameType = GameType.SOCCER
  }
  
}