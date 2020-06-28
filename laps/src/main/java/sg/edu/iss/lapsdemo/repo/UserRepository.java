package sg.edu.iss.lapsdemo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.lapsdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByUserName(String name);
	
	@Query("Select u.userName from User u")
	ArrayList<String> findAllNames();
}
