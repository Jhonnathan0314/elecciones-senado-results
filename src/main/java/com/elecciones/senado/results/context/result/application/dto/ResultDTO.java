package com.elecciones.senado.results.context.result.application.dto;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateDTO;
import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableDTO;
import com.elecciones.senado.results.context.party.application.dto.PartyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private Long id;
    private Long votes;
    private ElectionTableDTO electionTable;
    private CandidateDTO candidate;

}
