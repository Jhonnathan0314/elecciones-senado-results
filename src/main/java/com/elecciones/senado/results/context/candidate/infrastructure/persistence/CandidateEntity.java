package com.elecciones.senado.results.context.candidate.infrastructure.persistence;

import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "resolution_number")
    private String resolutionNumber;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "party")
    private PartyEntity party;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "state")
    private String state;

    @PrePersist
    protected void onCreate() { this.state = "active"; }

}
