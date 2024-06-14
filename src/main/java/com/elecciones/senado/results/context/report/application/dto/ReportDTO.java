package com.elecciones.senado.results.context.report.application.dto;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateDTO;
import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableDTO;
import com.elecciones.senado.results.context.party.application.dto.PartyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private PartyDTO party;
    private CandidateDTO candidate;
    private ElectionTableDTO electionTable;
    private BigDecimal votePercentage;

}
