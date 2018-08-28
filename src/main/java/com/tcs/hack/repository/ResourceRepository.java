package com.tcs.hack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.hack.model.Resource;


@Repository
public interface ResourceRepository extends CrudRepository<Resource, Integer>{

}
