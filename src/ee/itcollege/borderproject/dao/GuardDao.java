package ee.itcollege.borderproject.dao;

import java.util.List;

import ee.itcollege.borderproject.model.Guard;

public interface GuardDao {

	List<Guard> getGuards();
	
	void saveGuard(Guard guard);
	
	void saveGuards(List<Guard> guards);
	
	List<Guard> searchGuards(String name, int age);
	
	List<Guard> searchGuards(String name);
	
	List<Guard> searchGuards(int age);
	
	void updateGuard(int id, int age);
	
	void updateGuard(int id, String name);
	
	void updateGuard(int id, String name, int age);	
}
