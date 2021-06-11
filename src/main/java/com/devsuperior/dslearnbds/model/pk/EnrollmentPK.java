package com.devsuperior.dslearnbds.model.pk;

import com.devsuperior.dslearnbds.model.Offer;
import com.devsuperior.dslearnbds.model.User;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class EnrollmentPK implements Serializable {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offerId;

}
