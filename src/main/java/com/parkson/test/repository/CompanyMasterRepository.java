package com.parkson.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.parkson.test.entity.CompanyMaster;

/**
 * 
 * @author laxmareddy
 *
 */
@Transactional
public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Long> {
	public CompanyMaster findOneBycompName(String compName);

	public Page<CompanyMaster> findByCompCodeStartingWith(String searchStr, Pageable pageable);

	public Page<CompanyMaster> findByCompCodeHRISStartingWith(String searchStr, Pageable pageable);

	public Page<CompanyMaster> findByCompNameStartingWith(String searchStr, Pageable pageable);

	public Page<CompanyMaster> findByCompAbbrNameStartingWith(String searchStr, Pageable pageable);

	public Page<CompanyMaster> findByCompRegNoStartingWith(String searchStr, Pageable pageable);

	public Page<CompanyMaster> findByCompLogoStartingWith(String searchStr, Pageable pageable);

	public Page<CompanyMaster> findByCompActiveDateStartingWith(String searchStr, Pageable pageable);
}
