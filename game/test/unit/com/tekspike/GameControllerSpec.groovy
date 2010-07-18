package com.tekspike

import grails.plugin.spock.*

class GameControllerSpec extends ControllerSpec {

  def gameServiceMock = Mock(GameService)
  
  def "test save"() {      
    given:
      controller.gameService = gameServiceMock
      mockTheMessage()      
      1 * gameServiceMock.save(_) >> [id : 3]            
      
    when:
      controller.save()
      
    then:
      redirectArgs == [action : 'list']   
      mockFlash.message == "Success"
  }  

  def "test save error"() {      
    given:
      controller.gameService = gameServiceMock
      mockTheMessage()
      1 * gameServiceMock.save(_) >> {throw new CantScheduleGameException() }
            
    when:
      controller.save()
      
    then:
      renderArgs == [view : 'create']   
      mockFlash.error == "message(code:'game.notenough.players')"
  }
    
  // there is a poor inability to mock messages
  // which is really useful to do.
  private mockTheMessage() {
    controller.metaClass.message { msg ->
      if (msg['args']) {
        return "${msg['code']}:${msg['args']}"
      }
      else {
        return "${msg['code']}"
      }
   }  
 }
}