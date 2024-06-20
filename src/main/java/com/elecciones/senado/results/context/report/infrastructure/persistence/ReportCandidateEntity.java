package com.elecciones.senado.results.context.report.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_votes_report")
public class ReportCandidateEntity {

    @Id
    @Column(name = "candidate_name")
    private String candidateName;

    @Column(name = "party_name")
    private String partyName;

    @Column(name = "reported_tables")
    private Long reportedTables;

    @Column(name = "total_votes")
    private BigInteger totalVotes;

    @Column(name = "percentage")
    private BigDecimal percentage;
}
