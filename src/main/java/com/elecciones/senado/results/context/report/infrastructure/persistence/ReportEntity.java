package com.elecciones.senado.results.context.report.infrastructure.persistence;

import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_votes_report")
public class ReportEntity {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate")
    private CandidateEntity candidate;

    @ManyToOne
    @JoinColumn(name = "election_table")
    private ElectionTableEntity electionTable;

    @Column(name = "vote_percentage")
    private BigDecimal votePercentage;

}
