package com.infoshareacademy.jjdd3;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


    @Stateless
    public class CityDao {

        @PersistenceContext
        private EntityManager entityManager;

        public int save(City city) {
            entityManager.persist(city);
            return city.getId();
        }

        public City update(City c) {
            return entityManager.merge(c);
        }



        public City findByName(String city) {
            return entityManager.find(City.class, city);
        }

        public List<City> findAll() {
            final Query query = entityManager.createQuery("SELECT c FROM City c");

            return query.getResultList();
        }
    }


