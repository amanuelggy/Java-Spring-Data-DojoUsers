package com.amanuel.dojoNinja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.amanuel.dojoNinja.models.Dojo;
import com.amanuel.dojoNinja.models.Ninja;
import com.amanuel.dojoNinja.repositories.DojoRepo;
import com.amanuel.dojoNinja.repositories.NinjaRepo;

@Transactional
@Service
public class Services {
	private DojoRepo dojoRepo;
	private NinjaRepo ninjaRepo;
	public Services(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
		
	}
	
	public void saveDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}

	public List<Dojo>findAll(){
		return (List<Dojo>) dojoRepo.findAll();
	}
	public Dojo findAllD() {
		return (Dojo)dojoRepo.findAll();
	}

	public Dojo findDojoById(Long id) {
		return dojoRepo.findOne(id);
	}

	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}


}
