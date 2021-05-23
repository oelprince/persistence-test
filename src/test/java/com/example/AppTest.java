package com.example;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private EntityManager entityManager;

    @Before
    public void setup() {
        EntityManagerUtil entityManagerUtil = new EntityManagerUtil();
        entityManager = entityManagerUtil.getEntityManager();
    }
    

    @Test
    public void testValidationBug() {       
        LbtHdr lbtHdr = saveLbtHdr(1L);
        Assert.assertNotNull(lbtHdr);
        listLbtHdr();
    }

    public void listLbtHdr() {
      try {
        entityManager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<LbtHdr> lbtHdrs = entityManager.createQuery("select x from LbtHdr x").getResultList();
        Assert.assertTrue(lbtHdrs.size() > 0);
        for (Iterator<LbtHdr> iterator = lbtHdrs.iterator(); iterator.hasNext();) {
          LbtHdr lbtHdr = (LbtHdr) iterator.next();
          System.out.println("id = " + lbtHdr.getNtrnlLbtHdr());
          Assert.assertEquals(Long.valueOf(0L), lbtHdr.getNtrnlLbtHdr());
        }
        entityManager.getTransaction().commit();
      } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("It should not throw exception");
        entityManager.getTransaction().rollback();
      }
    }
  
    public LbtHdr saveLbtHdr(Long lbtHdrId) {
      LbtHdr lbtHdr = new LbtHdr();
      try {
        entityManager.getTransaction().begin();
        lbtHdr.setNtrnlLbtHdr(lbtHdrId);
        LbtTyp lbtTyp = new LbtTyp();
        lbtTyp.setLbtTypCd(Integer.valueOf(0));
  
        lbtHdr.setLbtTypCd(lbtTyp);
        lbtHdr = entityManager.merge(lbtHdr);
        entityManager.getTransaction().commit();
      } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("It should not throw exception");
        entityManager.getTransaction().rollback();
      }
      return lbtHdr;
    }

}
