package com.devsuperior.dslearnbds.model;

import com.devsuperior.dslearnbds.model.pk.EnrollmentPK;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant refundMoment;

    private Boolean available;
    private Boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> lessonsDone = new HashSet<>();

    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();

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
