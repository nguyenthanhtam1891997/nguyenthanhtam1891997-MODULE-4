package com.example.customerspringboot.repository;

import com.example.customerspringboot.model.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {

}
