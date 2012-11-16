package com.maty.j2ee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.maty.j2ee.entity.BaseField;

public interface BaseFieldRepository extends PagingAndSortingRepository<BaseField, Long>, JpaSpecificationExecutor<BaseField> {

	List<BaseField> findByEnabled(Integer enabled);
}
