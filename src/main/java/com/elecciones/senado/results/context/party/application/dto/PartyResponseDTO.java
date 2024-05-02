package com.elecciones.senado.results.context.party.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartyResponseDTO {

    private Long id;
    private String name;
    private String motto;

}
