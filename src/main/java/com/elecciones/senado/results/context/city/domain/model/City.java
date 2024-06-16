package com.elecciones.senado.results.context.city.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private Long id;
    private String name;
    private Long departmentId;

}