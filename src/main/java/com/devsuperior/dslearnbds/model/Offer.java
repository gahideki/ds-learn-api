package com.devsuperior.dslearnbds.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_offer")
public class Offer {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String edition;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant startMoment;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offer")
    private List<Resource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "offer")
    private List<Topic> topics = new ArrayList<>();

}
