package ru.school.mvc.taskmvc.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.school.mvc.taskmvc.security.entity.SecRole;
import ru.school.mvc.taskmvc.security.entity.SecUser;
import ru.school.mvc.taskmvc.security.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(String login, String rawPassword) {
		SecUser user = new SecUser();
		user.setLogin(login);
		user.setName(login);
		user.setPasswordHash(passwordEncoder.encode(rawPassword));
		
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecUser user = userRepository.findByLogin(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("User not found");
		}

		User.UserBuilder builder = User.withUsername(user.getLogin());
		builder.password(user.getPasswordHash());
		builder.roles(getUserRoles(user));
		return builder.build();
	}

	private String[] getUserRoles(SecUser user) {
		ArrayList<String> roles = new ArrayList<String>();
		for (SecRole role : user.getRoleList()) {
			roles.add(role.getRoleType());
		}
		return (String[]) roles.toArray(new String[roles.size()]);
	}

}
