package com.msu.dao;

import java.util.List;

import com.msu.dataobject.UserProfile;

public interface IUserProfileDAO {
	
	public boolean insert(UserProfile userProfile);

	public boolean delete(UserProfile userProfile);

	public boolean update(UserProfile userProfile);

	public List<UserProfile> getAllUserProfiles();

	public UserProfile getUserProfileById(UserProfile userProfile);
	
	public UserProfile getUserProfileById(String userId);

}
