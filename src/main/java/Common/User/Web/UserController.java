package Common.User.Web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Common.User.Service.UserVO;

@RestController
public class UserController {


	@RequestMapping( value="/u", method=RequestMethod.GET )
	public UserVO getUserInfo( UserVO usrVO ) {
		
		return usrVO;
	}
	
	
}
