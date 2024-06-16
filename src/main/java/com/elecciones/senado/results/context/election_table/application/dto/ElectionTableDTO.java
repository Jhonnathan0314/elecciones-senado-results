package com.elecciones.senado.results.context.election_table.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ElectionTableDTO {

    private Long id;
    private Long numberIds;
    private Long totalVotes;
    private String location;

}
