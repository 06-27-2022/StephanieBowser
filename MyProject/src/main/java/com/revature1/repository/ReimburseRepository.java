package com.revature1.repository;

import java.util.List;

import com.revature1.model.Reimburse;

public interface ReimburseRepository {

	
	List<Reimburse> findAllReimburse();


	void save(Reimburse reimburse);


	void update(Reimburse reimburse);

	Reimburse findById(int id);
//	Reimburse findByUserName(String userName);
	
}
