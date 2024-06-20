package com.elecciones.senado.results.context.report.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location_votes_report")
public class ReportElectionTableEntity {

    @Id
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "reported_tables")
    private Long reportedTables;

    @Column(name = "total_votes")
    private BigInteger totalVotes;

    @Column(name = "percentage")
    private BigDecimal percentage;

}
