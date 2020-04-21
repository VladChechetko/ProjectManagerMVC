package ru.school.mvc.taskmvc.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.school.mvc.taskmvc.security.entity.SecUser;

@Repository
public interface UserRepository extends JpaRepository<SecUser, Long>  {

	public SecUser findByLogin(String login);
	
}
