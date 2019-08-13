package com.jd.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.dojosninjas.models.Dojo;
import com.jd.dojosninjas.models.Ninja;
import com.jd.dojosninjas.repositories.DojoRepository;
import com.jd.dojosninjas.repositories.NinjaRepository;


@Service
public class DNService {
	
	@Autowired
	private DojoRepository dojoRepo;

	@Autowired
	private NinjaRepository ninjaRepo;

	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);		
	}

	public List<Dojo> allDojos() {
		List<Dojo> dojoList = (List<Dojo>) dojoRepo.findAll();
		return dojoList;
	}

	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		return dojo.get();
		
	}

	public List<Ninja> findAllNinjasByDojoId(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		return dojo.get().getNinjas();
	}
	
	
//  public Person create(Person p) {
//	return perRepo.save(p);
//}
//
//public License create(License l) {
//	return licRepo.save(l);
//}
//
//public List<Person> allPersons() {
//	return perRepo.findAll();
//}
//
//public Person findPerson(Long id) {
//	Optional<Person> optionalPerson = perRepo.findById(id);
//	if (optionalPerson.isPresent()) {
//		return optionalPerson.get();
//	} else {
//		return null;
//	}
//}
//
//public License findLicense(Long id) {
//	Optional<License> optionalLicense = licRepo.findByPersonId(id);
//	if (optionalLicense.isPresent()) {
//		return optionalLicense.get();
//	} else {
//		return null;
//	}
//
//}

}
