package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;

import javax.persistence.*;

@Entity
@Table(name="Special")
public class SpecialEntity extends ApplicationPersistenceEntity {

  private String name;

  private OfferEntity offer;

  private WeeklyPeriodEmbeddable activePeriod;

  private Money specialPrice;

  @ManyToOne
  public OfferEntity getOffer() {
    return offer;
  }

  public void setOffer(OfferEntity offer) {
    this.offer = offer;
  }

  @Embedded
  public WeeklyPeriodEmbeddable getActivePeriod() {
    return activePeriod;
  }

  public void setActivePeriod(WeeklyPeriodEmbeddable activePeriod) {
    this.activePeriod = activePeriod;
  }

  @Column(unique=true)
  public String getName() {

    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Money getSpecialPrice() {
    return specialPrice;
  }

  public void setSpecialPrice(Money specialPrice) {
    this.specialPrice = specialPrice;
  }
}
