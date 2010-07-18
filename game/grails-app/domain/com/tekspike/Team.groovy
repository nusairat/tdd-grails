package com.tekspike

class Team {
  String name
  boolean active = true
  Set players
  
  static hasMany = [players: Player]
  
  static constraints = {
    name(blank:false,unique:true)
  }
  
  /* all the time basis
  static mapping = {
    players fetch : 'join'
  }*/
}