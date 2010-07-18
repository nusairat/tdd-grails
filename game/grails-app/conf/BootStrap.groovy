import com.tekspike.Player
import com.tekspike.Team
import com.tekspike.GameType

class BootStrap {

    def init = { servletContext ->
       def team1 = new Team(name: 'Crew').save()
       def team2 = new Team(name: 'Galaxy').save()   
       def team3 = new Team(name: 'Red Bull', active : false).save()      
       def team4 = new Team(name: 'Earthquakes', active : true).save()      

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
    }
    
    def destroy = {
    }
}
