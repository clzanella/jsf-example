package com.cleber.jsf.dao;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

    private Class<T> entityClass;
    private EntityManager em;

    public GenericDAO(Class<T> entityClass){
        this.entityClass = entityClass;
        this.em = JPAUtil.getEntityManager();
    }

    public T buscarPorOid(Object oid){
        return em.find(entityClass, oid);
    }

    public void adicionar(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void atualizar(Object oid, T entity){

        T objContext = buscarPorOid(oid);

        if(objContext != null){
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } else {
            adicionar(entity);
        }
    }

    public void remover(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

}
