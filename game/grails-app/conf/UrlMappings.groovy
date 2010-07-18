import com.tekspike.Team

class UrlMappings {

	static mappings = {
	  // ? makes it optional at the end
	  "/$team/$junk1?/$junk2?"(controller: 'game', action : 'viewAllPlayers') {
	    constraints {
	      team(validator : {
	        Team.findByName(it) != null
	      })
	    }
	  }
	  
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
