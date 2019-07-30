package com.parkson.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parkson.test.entity.CompanyMaster;
import com.parkson.test.repository.CompanyMasterRepository;
import com.parkson.test.service.PaginationService;

/**
 * 
 * @author laxmareddy
 *
 */
@RestController
@RequestMapping(value = "/api")
public class CompanyMasterController {
	@Autowired
	private CompanyMasterRepository compantMasterRepository;

	@Autowired
	private PaginationService paginationService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/companylist", method = RequestMethod.GET)
	public List<CompanyMaster> companylist() {
		return compantMasterRepository.findAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/companys/{id}", method = RequestMethod.GET)
	public ResponseEntity<CompanyMaster> companyById(@PathVariable Long id) {
		CompanyMaster company = compantMasterRepository.findOne(id);
		if (company == null) {
			return new ResponseEntity<CompanyMaster>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<CompanyMaster>(company, HttpStatus.OK);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CompanyMaster> deleteCompany(@PathVariable Long id) {
		CompanyMaster company = compantMasterRepository.findOne(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (company == null) {
			return new ResponseEntity<CompanyMaster>(HttpStatus.NO_CONTENT);
		} else
			compantMasterRepository.delete(company);
		return new ResponseEntity<CompanyMaster>(company, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/companys", method = RequestMethod.POST)
	public ResponseEntity<CompanyMaster> createCompany(@RequestBody CompanyMaster company) {
		if (compantMasterRepository.findOneBycompName(company.getCompName()) != null) {
			throw new RuntimeException("Username already exist");
		}
		return new ResponseEntity<CompanyMaster>(compantMasterRepository.save(company), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/company", method = RequestMethod.PUT)
	public CompanyMaster updateCompany(@RequestBody CompanyMaster company) {
		if (compantMasterRepository.findOneBycompName(company.getCompName()) != null && compantMasterRepository
				.findOneBycompName(company.getCompName()).getCompCode() != company.getCompCode()) {
			throw new RuntimeException("Username already exist");
		}
		return compantMasterRepository.save(company);
	}

	@GetMapping("/all-company-masters")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Page<CompanyMaster>> getAllCompanyMasters(Pageable pageable) {
		Page<CompanyMaster> page = compantMasterRepository.findAll(pageable);
		HttpHeaders headers = paginationService.generatePaginationHttpHeaders(page, "/company-masters");
		return new ResponseEntity<>(page, headers, HttpStatus.OK);
	}

	@GetMapping("/company-masters/search")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Page<CompanyMaster>> search(Pageable pageable, @Param("searchCol") String searchCol,
			@Param("searchStr") String searchStr) {

		Page<CompanyMaster> page = null;
		switch (searchCol) {
		case "compCode":
			page = compantMasterRepository.findByCompCodeStartingWith(searchStr, pageable);
			break;
		case "compCodeHRIS":
			page = compantMasterRepository.findByCompCodeHRISStartingWith(searchStr, pageable);
			break;
		case "compName":
			page = compantMasterRepository.findByCompNameStartingWith(searchStr, pageable);
			break;
		case "compAbbrName":
			page = compantMasterRepository.findByCompAbbrNameStartingWith(searchStr, pageable);
			break;
		case "compRegNo":
			page = compantMasterRepository.findByCompRegNoStartingWith(searchStr, pageable);
			break;
		case "compLogo":
			page = compantMasterRepository.findByCompLogoStartingWith(searchStr, pageable);
			break;
		case "compActiveDate":
			page = compantMasterRepository.findByCompActiveDateStartingWith(searchStr, pageable);
			break;
		}

		HttpHeaders headers = paginationService.generatePaginationHttpHeaders(page, "/company-masters");
		return new ResponseEntity<>(page, headers, HttpStatus.OK);
	}

}
