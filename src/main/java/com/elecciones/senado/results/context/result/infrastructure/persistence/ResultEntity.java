package com.elecciones.senado.results.context.result.infrastructure.persistence;

import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
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
@Table(name = "result")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "votes")
    private Long votes;

    @ManyToOne
    @JoinColumn(name = "election_table")
    private ElectionTableEntity electionTable;

    @ManyToOne
    @JoinColumn(name = "candidate")
    private CandidateEntity candidate;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

}
