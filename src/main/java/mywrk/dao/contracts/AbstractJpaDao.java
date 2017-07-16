package mywrk.dao.contracts;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao<T extends Serializable> {
	private Class<T> clazz;
	
	@PersistenceContext
	EntityManager entityManager;

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findbyId(Long id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName())
				.getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		entityManager.merge(entity);
		return entity;
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(Long entityId) {
		T entity = findbyId(entityId);
		delete(entity);
	}
}