package com.tekspike

class GameController {
  def gameService
  
  def viewAllPlayers = {
    println "- view all players $params - "
    def players = Player.executeQuery(" \
      Select t.players \
      from Team t \
      where t.name = ? \
    ", [params.team])
    [players : players]
  }
  
  def index = {
    // per needed basis
    // TODO look up why its grabbing 14
    def teams = Team.withCriteria() {
      join('players')
    }
    println "teams : ${teams.size()}"
    render (view : 'index', model: [teams : Team.list()])
  }
  
  def list = {
    [list : Game.list()]
  }
  
  def create = { }
  
  def save = { SaveTeamCommand cmd ->
    try {
      def game = gameService.save(cmd)      
      flash.message = "Success"   
      redirect(action : 'list')
    } catch (CantScheduleGameException e) {
      flash.error = "message(code:'game.notenough.players')"
      render(view :'create')
    } catch(Exception e) {
      flash.error = "message(code:'game.error')"
      render(view :'create')
    }
    
  }
}


class SaveTeamCommand {
  long awayTeam
  long homeTeam
  Date dateOfGame
  
  static constraints = {
    awayTeam(nullable:true)
    homeTeam(nullable:true)    
  }  
}