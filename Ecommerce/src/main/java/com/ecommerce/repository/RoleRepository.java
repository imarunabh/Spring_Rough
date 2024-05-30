package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
