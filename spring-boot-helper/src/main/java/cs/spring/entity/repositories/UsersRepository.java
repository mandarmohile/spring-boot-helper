package cs.spring.entity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.spring.entity.jpa.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	
	public Optional<Users> findByUsername(String pUserName);
}
