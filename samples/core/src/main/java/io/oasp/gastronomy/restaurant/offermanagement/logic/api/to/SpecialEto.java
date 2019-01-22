package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import org.h2.util.New;

public class SpecialEto {
  private String name;

  private Long offerId;

  private Money specialPrice;

  private WeeklyPeriodEto weeklyPeriod;

  public SpecialEto(String name, Long offerId, Money specialPrice, WeeklyPeriodEmbeddable weeklyPeriod) {
    this.name = name;
    this.offerId = offerId;
    this.specialPrice = specialPrice;
    this.weeklyPeriod = mapWeeklyPeriod(weeklyPeriod);
  }

  public SpecialEto(){}

  public WeeklyPeriodEto getWeeklyPeriod() {
    return weeklyPeriod;
  }

  public void setWeeklyPeriod(WeeklyPeriodEmbeddable weeklyPeriod) {
    this.weeklyPeriod = mapWeeklyPeriod(weeklyPeriod);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getOfferId() {
    return offerId;
  }

  public void setOfferId(Long offerId) {
    this.offerId = offerId;
  }

  public Money getSpecialPrice() {
    return specialPrice;
  }

  public void setSpecialPrice(Money specialPrice) {
    this.specialPrice = specialPrice;
  }

  public WeeklyPeriodEto mapWeeklyPeriod(WeeklyPeriodEmbeddable weeklyPeriodEmbeddable){
    WeeklyPeriodEto weeklyPeriodEto = new WeeklyPeriodEto();
    weeklyPeriodEto.setEndingDay(weeklyPeriodEmbeddable.getEndingDay());
    weeklyPeriodEto.setStartingDay(weeklyPeriodEmbeddable.getEndingDay());
    weeklyPeriodEto.setStartingHour(weeklyPeriodEmbeddable.getStartingHour());
    weeklyPeriodEto.setEndingHour(weeklyPeriodEmbeddable.getEndingHour());
    return weeklyPeriodEto;
  }

}
