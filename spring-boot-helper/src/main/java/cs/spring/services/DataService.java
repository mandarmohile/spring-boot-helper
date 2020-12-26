package cs.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.spring.entity.jpa.Users;
import cs.spring.entity.repositories.UsersRepository;

@Service
public class DataService {
	
	private UsersRepository usersRepo;
		
	public DataService(@Autowired UsersRepository usersRepo) {
		this.usersRepo = usersRepo;
	}
	
	public Users getUser(String pUserName) {
		Optional<Users> lUserOpt = usersRepo.findByUsername(pUserName);
		return lUserOpt.orElseThrow(() -> new RuntimeException("Invalid UserName " + pUserName));
	}
	
}
