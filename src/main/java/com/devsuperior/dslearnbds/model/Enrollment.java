package com.devsuperior.dslearnbds.model;

import com.devsuperior.dslearnbds.model.pk.EnrollmentPK;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant refundMoment;
    private Boolean available;
    private Boolean onlyUpdate;

    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, Boolean available, Boolean onlyUpdate) {
        this.id.setUserId(user);
        this.id.setOfferId(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent() {
        return id.getUserId();
    }

    public void setStudent(User user) {
        this.id.setUserId(user);
    }

    public Offer getOffer() {
        return id.getOfferId();
    }

    public void setOffer(Offer offer) {
        this.id.setOfferId(offer);
    }

}
