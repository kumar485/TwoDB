package com.oded.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oded.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
