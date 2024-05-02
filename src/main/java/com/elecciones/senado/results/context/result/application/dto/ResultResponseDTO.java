package com.elecciones.senado.results.context.result.application.dto;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateResponseDTO;
import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableResponseDTO;
import com.elecciones.senado.results.context.party.application.dto.PartyResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponseDTO {

    private Long id;
    private Long votes;
    private ElectionTableResponseDTO electionTable;
    private CandidateResponseDTO candidate;

}
