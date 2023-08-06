package com.ecommerce.services;

import java.util.List;

import com.ecommerce.exceptions.CustomerException;
import com.ecommerce.models.Customers;

public interface CustomerService {

	Customers addUser(Customers customers, String secretKey) throws CustomerException;

	Customers updateUser(Customers customers) throws CustomerException;

	Customers deleteUser(String email) throws CustomerException;

	List<Customers> getAllUsers() throws CustomerException;

	List<Customers> getAllAdmins() throws CustomerException;

	Customers getUserByEmail(String email) throws CustomerException;

	Customers getUserById(Long id) throws CustomerException;

}
