package com.example.demo.jpa.dao;

import com.example.demo.jpa.entiy.A;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("aDao")
public interface ARepository extends PagingAndSortingRepository<A, Long>, JpaSpecificationExecutor<A> {

}
