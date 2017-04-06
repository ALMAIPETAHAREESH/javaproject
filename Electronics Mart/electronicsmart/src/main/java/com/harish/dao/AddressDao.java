package com.harish.dao;

import java.util.List;

import com.harish.model.Address;
import com.harish.model.UserDetails;

public interface AddressDao
{
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	public List<Address> getAddress(UserDetails user);

}
