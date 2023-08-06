package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ecommerce.exceptions.CustomerException;
import com.ecommerce.models.Customers;
import com.ecommerce.models.Role;
import com.ecommerce.repositories.CustomersRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomersRepository customerRepository;

	@Value("${secretKey}")
	private String secretKey;

	/**
	 * @param customer
	 * @param secretKey
	 * @return Customers object if the user is added successfully to the database.
	 * @throws CustomerException
	 * 
	 *                           This method is used to add a new user to the
	 *                           database.
	 *                           If the secret key is correct, the user is added as
	 *                           an admin.
	 *                           Otherwise, the user is added as a regular user.
	 */
	@Override
	public Customers addUser(Customers customer, String secretKey) throws CustomerException {

		if (customer == null)
			throw new CustomerException("Invalid user details");

		if (secretKey.equals(this.secretKey)) {
			customer.setRole(Role.ROLE_ADMIN);
		} else {
			customer.setRole(Role.ROLE_USER);
		}
		return customerRepository.save(customer);

	}

	/**
	 * @param customers
	 * @return Customers object if the user is updated successfully in the database.
	 * @throws CustomerException
	 * 
	 *                           This method is used to update an existing user in
	 *                           the database.
	 *                           If the user is not found, an exception is thrown.
	 *                           Otherwise, the user is updated and saved to the
	 *                           database.
	 */
	@Override
	public Customers updateUser(Customers customers) throws CustomerException {
		Customers existingCustomer = customerRepository.findByEmail(customers.getEmail());

		if (existingCustomer == null)
			throw new CustomerException("User not found");

		existingCustomer.setFirstName(customers.getFirstName());
		existingCustomer.setLastName(customers.getLastName());
		existingCustomer.setPhone(customers.getPhone());
		existingCustomer.setCity(customers.getCity());
		existingCustomer.setState(customers.getState());
		existingCustomer.setCountry(customers.getCountry());
		existingCustomer.setPostalCode(customers.getPostalCode());

		return customerRepository.save(existingCustomer);

	}

	/**
	 * @param email
	 * @return Customers object if the user is deleted successfully from the
	 *         database.
	 * @throws CustomerException
	 * 
	 *                           This method is used to delete an existing user from
	 *                           the database.
	 *                           If the user is not found, an exception is thrown.
	 *                           Otherwise, the user is deleted from the database.
	 */
	@Override
	public Customers deleteUser(String email) throws CustomerException {
		Customers existingCustomer = customerRepository.findByEmail(email);

		if (existingCustomer == null)
			throw new CustomerException("User not found");

		customerRepository.delete(existingCustomer);
		return existingCustomer;
	}

	/**
	 * @return List of Customers objects if the users are found in the database.
	 * @throws CustomerException
	 * 
	 *                           This method is used to get all the users from the
	 *                           database.
	 *                           If no users are found, an exception is thrown.
	 *                           Otherwise, the users are returned.
	 */
	@Override
	public List<Customers> getAllUsers() throws CustomerException {
		List<Customers> customers = customerRepository.findAll().stream().filter((s) -> s.getRole().equals(Role.ROLE_USER))
				.toList();

		if (customers == null)
			throw new CustomerException("No users found");

		return customers;
	}

	/**
	 * @return List of Customers objects if the admins are found in the database.
	 * @throws CustomerException
	 * 
	 *                           This method is used to get all the admins from the
	 *                           database.
	 *                           If no admins are found, an exception is thrown.
	 *                           Otherwise, the admins are returned.
	 */
	@Override
	public List<Customers> getAllAdmins() throws CustomerException {
		List<Customers> customers = customerRepository.findAll().stream().filter((s) -> s.getRole().equals(Role.ROLE_ADMIN))
				.toList();

		if (customers == null)
			throw new CustomerException("No admins found");

		return customers;
	}

	/**
	 * 
	 */
	@Override
	public Customers getUserByEmail(String email) throws CustomerException {

		Customers customer = customerRepository.findByEmail(email);

		if (customer == null)
			throw new CustomerException("User not found");

		return customer;

	}

	@Override
	public Customers getUserById(Long id) throws CustomerException {

		Customers customer = customerRepository.findById(id).orElse(null);

		if (customer == null)
			throw new CustomerException("User not found");

		return customer;
	}

}
