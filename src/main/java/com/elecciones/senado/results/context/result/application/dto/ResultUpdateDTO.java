package com.elecciones.senado.results.context.result.application.dto;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateUpdateDTO;
import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableUpdateDTO;
import com.elecciones.senado.results.context.party.application.dto.PartyUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultUpdateDTO {

    private Long id;
    private Long votes;
    private ElectionTableUpdateDTO electionTable;
    private CandidateUpdateDTO candidate;

}
