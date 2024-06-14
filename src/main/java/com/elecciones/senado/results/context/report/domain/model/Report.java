package com.elecciones.senado.results.context.report.domain.model;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.party.domain.model.Party;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private Party party;
    private Candidate candidate;
    private ElectionTable electionTable;
    private BigDecimal votePercentage;

}
