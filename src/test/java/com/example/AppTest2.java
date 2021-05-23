package com.example;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest2 {

    private EntityManager entityManager;

    @Before
    public void setup() {
        EntityManagerUtil entityManagerUtil = new EntityManagerUtil();
        entityManager = entityManagerUtil.getEntityManager();
    }
    

    @Test
    public void testCharTypeValidation() {
      LbtHdr lbtHdr = saveLbtHdrWithSsnTyp(2L);
      Assert.assertNotNull(lbtHdr);
      listLbtHdrWithSsnTyp();
    }

    
    public void listLbtHdrWithSsnTyp() {
      try {
        entityManager.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<LbtHdr> lbtHdrs = entityManager.createQuery("select x from LbtHdr x where x.ntrnlLbtHdr = 2").getResultList();
        Assert.assertTrue(lbtHdrs.size() > 0);
        for (Iterator<LbtHdr> iterator = lbtHdrs.iterator(); iterator.hasNext();) {
          LbtHdr lbtHdr = (LbtHdr) iterator.next();
          System.out.println("id = " + lbtHdr.getNtrnlLbtHdr());
          Assert.assertEquals(Long.valueOf(2L), lbtHdr.getNtrnlLbtHdr());
        }
        entityManager.getTransaction().commit();
      } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("It should not throw exception");
        entityManager.getTransaction().rollback();
      }
    }

    
  
    

    public LbtHdr saveLbtHdrWithSsnTyp(Long lbtHdrId) {
      LbtHdr lbtHdr = new LbtHdr();
      try {
        entityManager.getTransaction().begin();
        lbtHdr.setNtrnlLbtHdr(lbtHdrId);
        LbtTyp lbtTyp = new LbtTyp();
        lbtTyp.setLbtTypCd(Integer.valueOf(1));
  
        lbtHdr.setLbtTypCd(lbtTyp);

        SsnTyp ssnTyp = new SsnTyp();
        ssnTyp.setSsnTypCd('0');

        lbtHdr.setSsnTypCd(ssnTyp);

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
