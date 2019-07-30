package com.parkson.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkson.test.entity.AppUser;

/**
 * 
 * @author laxmareddy
 *
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
