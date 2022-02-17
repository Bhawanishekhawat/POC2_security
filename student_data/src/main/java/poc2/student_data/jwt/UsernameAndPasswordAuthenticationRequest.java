package poc2.student_data.jwt;

import lombok.Data;

@Data
public class UsernameAndPasswordAuthenticationRequest {

	
	private String username;
    private String password;
    
    
}
