package com.tekspike

class GameService {
  

  def save(cmd) {
    println " ********************************* "
    def game
    
    def awayTeam = Team.get(cmd.awayTeam)
    def homeTeam = Team.get(cmd.homeTeam)    
      
    if (eligibleEnoughPlayers(awayTeam.players,3)
      && eligibleEnoughPlayers(homeTeam.players,3)
      && awayTeam.active
      && homeTeam.active) {
        game = new Game(awayTeam : awayTeam, homeTeam : homeTeam, date : cmd.dateOfGame)
        game.save()
    }
    else {
      throw new CantScheduleGameException()
    }
  }
  
  private boolean eligibleEnoughPlayers(players, amount) {
   players.findAll {
      it.eligible == true
    }?.size() >= amount
  }

}