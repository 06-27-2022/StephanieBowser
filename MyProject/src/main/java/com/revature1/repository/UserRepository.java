package com.revature1.repository;

import java.util.List;

import com.revature1.model.Reimburse;
import com.revature1.model.User;

public interface UserRepository {


	List<User> findAllUsers();

	void save(User user);

	void update(User user);

	User findById(int id);
	List<Reimburse> findAllReimburse();
	void save(Reimburse reimburse);
	void update(Reimburse reimburse);
	
}