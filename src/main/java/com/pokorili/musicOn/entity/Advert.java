package com.pokorili.musicOn.entity;

import java.sql.Timestamp;

public class Advert {

    private Long id;

    private Visitor visitor;

    private String pictureLink;

    private String description;

    private String advLink;

    private AdvertPlace advertPlace;

    private Timestamp offerDate;

    private Boolean approval;

    private Boolean payment;

    private Timestamp paymentDate;

    private Timestamp paidUntil;

    public Advert() {}

    public Advert(Visitor visitor, String pictureLink, String advLink) {
        this.visitor = visitor;
        this.pictureLink = pictureLink;
        this.advLink = advLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvLink() {
        return advLink;
    }

    public void setAdvLink(String advLink) {
        this.advLink = advLink;
    }

    public AdvertPlace getAdvertPlace() {
        return advertPlace;
    }

    public void setAdvertPlace(AdvertPlace advertPlace) {
        this.advertPlace = advertPlace;
    }

    public Timestamp getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Timestamp offerDate) {
        this.offerDate = offerDate;
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getPaidUntil() {
        return paidUntil;
    }

    public void setPaidUntil(Timestamp paidUntil) {
        this.paidUntil = paidUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advert advert = (Advert) o;

        if (id != null ? !id.equals(advert.id) : advert.id != null) return false;
        if (visitor != null ? !visitor.equals(advert.visitor) : advert.visitor != null) return false;
        if (pictureLink != null ? !pictureLink.equals(advert.pictureLink) : advert.pictureLink != null) return false;
        if (description != null ? !description.equals(advert.description) : advert.description != null) return false;
        if (advLink != null ? !advLink.equals(advert.advLink) : advert.advLink != null) return false;
        if (advertPlace != null ? !advertPlace.equals(advert.advertPlace) : advert.advertPlace != null) return false;
        if (offerDate != null ? !offerDate.equals(advert.offerDate) : advert.offerDate != null) return false;
        if (approval != null ? !approval.equals(advert.approval) : advert.approval != null) return false;
        if (payment != null ? !payment.equals(advert.payment) : advert.payment != null) return false;
        if (paymentDate != null ? !paymentDate.equals(advert.paymentDate) : advert.paymentDate != null) return false;
        if (paidUntil != null ? !paidUntil.equals(advert.paidUntil) : advert.paidUntil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
        result = 31 * result + (pictureLink != null ? pictureLink.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (advLink != null ? advLink.hashCode() : 0);
        result = 31 * result + (advertPlace != null ? advertPlace.hashCode() : 0);
        result = 31 * result + (offerDate != null ? offerDate.hashCode() : 0);
        result = 31 * result + (approval != null ? approval.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (paidUntil != null ? paidUntil.hashCode() : 0);
        return result;
    }
}
