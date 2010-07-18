package com.tekspike

class Player {
  String name
  String pos
  Date dateOfBirth
  boolean eligible = true
  GameType gameType
  Team team
  
  static belongsTo = Team
  
  static constraints = {
    name(blank:false)
    pos(nullable:true)
    dateOfBirth(nullable:true)    
    team(nullable: true)
  }
  
  String toString() {
    "$name for ${team?.name}"
  }
}

enum GameType {
  SOCCER, FOOTBALL
}