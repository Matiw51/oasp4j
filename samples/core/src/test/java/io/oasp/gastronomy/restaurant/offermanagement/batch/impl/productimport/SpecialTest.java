package io.oasp.gastronomy.restaurant.offermanagement.batch.impl.productimport;


import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Offer;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.Offermanagement;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialEto;
import io.oasp.module.test.common.base.ComponentTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = { SpringBootApp.class })
@WebAppConfiguration
@Transactional
@RunWith(MockitoJUnitRunner.class)
public class SpecialTest extends ComponentTest {
  @Inject
  private SpecialDao specialDao;

  @Mock
  private Offermanagement offermanagement;

  @Test(expected=JpaObjectRetrievalFailureException.class)
  public void deleteTest(){
    specialDao.delete(10L);
  }


  @Test
  public void getAllSpecialOffersTest(){
    //given
    SpecialEntity specialEntity = new SpecialEntity();
    WeeklyPeriodEmbeddable weeklyPeriod = new WeeklyPeriodEmbeddable();
    OfferEntity offer = new OfferEntity();

    weeklyPeriod.setEndingHour(1);
    weeklyPeriod.setStartingHour(23);
    weeklyPeriod.setEndingDay(DayOfWeek.FRIDAY);
    weeklyPeriod.setEndingDay(DayOfWeek.SATURDAY);

    specialEntity.setActivePeriod(weeklyPeriod);
    specialEntity.setOffer(offer);
    specialEntity.setName("dsadsad");
    specialEntity.setSpecialPrice(Money.ZERO);

    //when
    specialDao.save(specialEntity);
    List<SpecialEntity> list = specialDao.getAllSpecialOffers();
    //then
    Assert.assertEquals(list.size(), 1);
  }

  @Test
  public void SpecialSaveTest(){
    //given
    SpecialEto specialEto = new SpecialEto("dsaasdsad", 1L, Money.ZERO, new WeeklyPeriodEmbeddable());
    Mockito.when(offermanagement.saveSpecial(specialEto)).thenReturn(specialEto);
    //when
    SpecialEto specialEto2 = offermanagement.saveSpecial(specialEto);
    //then
    Assert.assertEquals(specialEto, specialEto2);
  }
}
