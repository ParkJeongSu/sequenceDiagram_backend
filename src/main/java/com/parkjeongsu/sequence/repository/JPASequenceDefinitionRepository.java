package com.parkjeongsu.sequence.repository;

import com.parkjeongsu.sequence.domain.SequenceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JPASequenceDefinitionRepository implements SequenceDefinitionRepository{
    @Autowired
    private EntityManagerFactory emf;

    private EntityManager em;

    public SequenceDefinition create(SequenceDefinition sequenceDefinition){
        try {
            List<SequenceDefinition> SequenceDefinitionList= this.readAll();
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try{

                Long lastId = 0L;
                for(SequenceDefinition s : SequenceDefinitionList){
                    if(s.getId()>lastId){
                        lastId =s.getId();
                    }
                }
                lastId++;
                sequenceDefinition.setId(lastId);
                em.persist(sequenceDefinition);
                System.out.println("Id : " + sequenceDefinition.getId());
                System.out.println("SequenceMenuName : " + sequenceDefinition.getSequenceMenuName());
                System.out.println("DiagramText : " + sequenceDefinition.getDiagramText());
                tx.commit();
            }
            catch (Exception e){
                tx.rollback();
                System.out.println(e.getMessage());
            }
            finally {
                em.close();
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }

        return sequenceDefinition;
    }

    public List<SequenceDefinition> readAll() {
        em = emf.createEntityManager();
        String jpql = "SELECT b FROM SequenceDefinition b ";
        Query query = em.createQuery(jpql);
        List<SequenceDefinition> sequenceDefinitionList = query.getResultList();
        em.close();
        return sequenceDefinitionList;
    }

    public SequenceDefinition putSequenceDefinition(SequenceDefinition sequenceDefinition) {

        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            SequenceDefinition findSD = em.find(SequenceDefinition.class,sequenceDefinition.getId());

            try{
                findSD.setDiagramText(sequenceDefinition.getDiagramText());
                em.persist(findSD);
                System.out.println("Id : " + findSD.getId());
                System.out.println("SequenceMenuName : " + findSD.getSequenceMenuName());
                System.out.println("DiagramText : " + findSD.getDiagramText());
                tx.commit();
            }
            catch (Exception e){
                tx.rollback();
                System.out.println(e.getMessage());
            }
            finally {
                em.close();
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return sequenceDefinition;
    }


    public SequenceDefinition getSequenceDefinition(String id) {

        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            SequenceDefinition findSD = em.find(SequenceDefinition.class,Long.parseLong(id));
            return findSD;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }

        return null;
    }

}
