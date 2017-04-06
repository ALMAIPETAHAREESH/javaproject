package com.harish.dao;



import com.harish.model.UserDetails;

public interface UserDao
{
	public boolean addUsers(UserDetails user);
	public UserDetails getUser(int id);
	public boolean updateUser(UserDetails user);
	public boolean deleteUser(int id);
	public UserDetails getUserNameByUserName(String username);
	public UserDetails getUserByEmail(String email);
	
}

