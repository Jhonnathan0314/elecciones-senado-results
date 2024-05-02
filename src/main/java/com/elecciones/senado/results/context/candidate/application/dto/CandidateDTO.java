package com.elecciones.senado.results.context.candidate.application.dto;

import com.elecciones.senado.results.context.party.application.dto.PartyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO {

    private Long id;
    private Long cardNumber;
    private String resolutionNumber;
    private String name;
    private String lastName;
    private PartyDTO party;

}
