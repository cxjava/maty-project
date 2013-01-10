package com.maty.j2ee.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.maty.j2ee.entity.BaseModule;
import com.maty.j2ee.repository.BaseModuleRepositoryDao;

/**
 * @author Maty Chen
 *
 */
public class BaseModuleRepositoryImpl implements BaseModuleRepositoryDao {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Configure the entity manager to be used.
	 * 
	 * @param em
	 *            the {@link EntityManager} to set.
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<BaseModule> findAllModules(Map<String, Object> parameters) {
		CriteriaQuery<BaseModule> criteriaQuery = em.getCriteriaBuilder().createQuery(BaseModule.class);
		Root<BaseModule> variableRoot = criteriaQuery.from(BaseModule.class);
		criteriaQuery.select(variableRoot);

		return em.createQuery(criteriaQuery).getResultList();
	}

}
