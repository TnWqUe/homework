package ru.mpei.homework.repository;


import org.springframework.stereotype.Repository;
import ru.mpei.homework.model.Current;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CurrentRepositoryImpl implements CurrentRepository{
    @PersistenceContext
    private EntityManager em;

    //добавление точки
    @Override
    public void addPoint( double ia, double ib, double ic){
        Current s=new Current(ia,ib,ic);
        em.persist(s);
    }
//List из измерений, т.е. List<Current>
    @Override
    public List<Current> findFault1(long startIndex, long endIndex) {
        List<Current> result=em.createQuery("select e from Current e where e.id between :startIndex and :endIndex",Current.class)
                .setParameter("startIndex",startIndex)
                .setParameter("endIndex",endIndex)
                .getResultList();
        return result;
    }
}
