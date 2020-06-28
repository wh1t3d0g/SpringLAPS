package sg.edu.iss.lapsdemo.service;

import java.util.ArrayList;

import sg.edu.iss.lapsdemo.model.User;

public interface UserService {

	ArrayList<User> findAll();
	public boolean saveUser(User user);
	public void deleteUser(User user);
	public ArrayList<String> findAllUserNames();
	public User findUserByName(String name);
	public User findUserById(Integer id);


}
