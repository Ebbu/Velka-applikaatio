package com.velka.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByUsername(String username);

}
