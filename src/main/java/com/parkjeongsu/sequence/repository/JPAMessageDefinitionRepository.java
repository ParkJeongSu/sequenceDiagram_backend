package com.parkjeongsu.sequence.repository;

import com.parkjeongsu.sequence.domain.MessageDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JPAMessageDefinitionRepository implements MessageDefinitionRepository{
    @Autowired
    private EntityManagerFactory emf;

    private EntityManager em;

    public MessageDefinition create(MessageDefinition MessageDefinition){
        try {
            List<MessageDefinition> MessageDefinitionList= this.readAll();
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try{

                Long lastId = 0L;
                for(MessageDefinition s : MessageDefinitionList){
                    if(s.getId()>lastId){
                        lastId =s.getId();
                    }
                }
                lastId++;
                MessageDefinition.setId(lastId);
                em.persist(MessageDefinition);
                System.out.println("Id : " + MessageDefinition.getId());
                System.out.println("MessageName : " + MessageDefinition.getMessageName());
                System.out.println("MessageContent : " + MessageDefinition.getExampleMessageContent());
                System.out.println("Messagedesc : " + MessageDefinition.getMessageDescription());
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

        return MessageDefinition;
    }

    public List<MessageDefinition> readAll() {
        em = emf.createEntityManager();
        String jpql = "SELECT b FROM MessageDefinition b ";
        Query query = em.createQuery(jpql);
        List<MessageDefinition> MessageDefinitionList = query.getResultList();
        em.close();
        return MessageDefinitionList;
    }

    public MessageDefinition putMessageDefinition(MessageDefinition MessageDefinition) {

        try {

            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            MessageDefinition findSD = em.find(MessageDefinition.class,MessageDefinition.getId());

            try{
                findSD.setExampleMessageContent(MessageDefinition.getExampleMessageContent());
                findSD.setMessageDescription(MessageDefinition.getMessageDescription());
                em.persist(findSD);
                System.out.println("Id : " + findSD.getId());
                System.out.println("MessageName : " + findSD.getMessageName());
                System.out.println("MessageContent : " + findSD.getExampleMessageContent());
                System.out.println("Messagedesc : " + findSD.getMessageDescription());
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

        return MessageDefinition;
    }


    public MessageDefinition getMessageDefinitionByMessageName(String messageName) {

        try {
            em = emf.createEntityManager();
            String jpql = "SELECT b FROM MessageDefinition b where b.messageName ='"+messageName+"'";
            Query query = em.createQuery(jpql);
            List<MessageDefinition> MessageDefinitionList = query.getResultList();
            em.close();
            return MessageDefinitionList.get(0);
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
