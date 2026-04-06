package tn.esprit.spring.services;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	@Override
	public List<User> retrieveAllUsers() { 
		return null;
	}
	@Override
	public User addUser(User u) {
		User utilisateur = null; 
		try {
			l.info("addUser() start");
			utilisateur = userRepository.save(u); 
			l.info("addUser() end");
		} catch (Exception e) {
			l.error("error in addUser() : " + e);
		}
		return utilisateur; 
	}
	@Override 
	public User updateUser(User u) {
		User userUpdated = null; 
		try {
			l.info("updateUser() start");
			userUpdated = userRepository.save(u); 
			l.info("updateUser() end");
		} catch (Exception e) {
			l.error("error in updateUser() : " + e);
		}
		return userUpdated; 
	}
	@Override
	public void deleteUser(String id) {
		try {
			l.info("deleteUser() start");
			userRepository.deleteById(Long.parseLong(id)); 
			l.info("deleteUser() end");
		} catch (Exception e) {
			l.error("error in deleteUser() : " + e);
		}
	}
	@Override
	public User retrieveUser(String id) {
		User u = null;
		try {
			u = userRepository.findById(Long.parseLong(id)).get();
		} catch (Exception e) {
			l.error("error in retrieveUser() : " + e);
		}
		return u;
	}
}
