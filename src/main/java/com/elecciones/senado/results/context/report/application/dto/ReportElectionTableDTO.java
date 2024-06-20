package com.elecciones.senado.results.context.report.application.dto;

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
public class ReportElectionTableDTO {

    private Long cityId;
    private Long reportedTables;
    private BigInteger totalVotes;
    private BigDecimal percentage;

}
