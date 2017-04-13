package com.velka.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;





@RepositoryRestResource(collectionResourceRel = "velka", path = "velka")
public interface VelkaRepository extends CrudRepository<Velka, Long> {
	List<Velka> findById(String velka);

}
