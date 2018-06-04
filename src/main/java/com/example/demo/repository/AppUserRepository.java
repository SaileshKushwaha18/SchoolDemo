/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppUser;

/**
 * @author Sailesh
 *
 */
@Repository
@RepositoryRestController
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
