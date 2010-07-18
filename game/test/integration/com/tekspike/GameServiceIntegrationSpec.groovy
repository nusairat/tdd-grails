package com.tekspike 

import grails.plugin.spock.IntegrationSpec

class GameServiceIntegrationSpec extends IntegrationSpec {
  
  def gameService
  Team team1 
  Team team2 
  Team team3
  Team team4
  
  def 'test all eligible'() {
    setup:
      createGameData()
      
    when:
      def result = gameService.save([awayTeam : team1.id, homeTeam : team2.id, dateOfGame : new Date()])
      
    then:
      result != null   
  }
 
  def 'test one not eligible'() {
   def failed = true
   setup:
     createGameData()

   when:   
     try {
        gameService.save([awayTeam : team1.id, homeTeam : team4.id, dateOfGame : new Date()])
        failed = false
      } catch (CantScheduleGameException e) {}
      
    then :
      failed
  }
 
 void createGameData() {
   team1 = new Team(name: 'Crew').save()
   team2 = new Team(name: 'Galaxy').save()   
   team3 = new Team(name: 'Red Bull', active : false).save()      
   team4 = new Team(name: 'Earthquakes', active : true).save()      
      
   (1..4).each {
     team1.addToPlayers(new Player(name : "joe $it", gameType : GameType.SOCCER, eligible : true, team : team1))
   }
   team1.save()
   
   (1..4).each {
     team2.addToPlayers(new Player(name : "joe1 $it", gameType : GameType.SOCCER, eligible : true, team : team2))
   }   
   team2.save()
      
   (1..4).each {
     team3.addToPlayers(new Player(name : "joe2 $it", gameType : GameType.SOCCER, eligible : true, team : team3))
   }
   team3.save()
      
   (1..2).each {
     team4.addToPlayers(new Player(name : "joe3 $it", gameType : GameType.SOCCER, eligible : true, team : team4))
   }
   team4.save()
        
   println team1.name
   println team1.players
 }
}