package com.elecciones.senado.results.context.report.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportCandidate {

    private String candidateName;
    private String partyName;
    private Long reportedTables;
    private BigInteger totalVotes;
    private BigDecimal percentage;

}
