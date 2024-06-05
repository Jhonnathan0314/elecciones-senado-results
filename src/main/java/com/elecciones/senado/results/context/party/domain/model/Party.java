package com.elecciones.senado.results.context.party.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Party {

    private Long id;
    private String name;
    private String motto;
    private String logo;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private String state;

    public boolean isValid(Party party) {
        if(party.getName() == null || party.getMotto() == null) return false;

        return !party.getName().isEmpty() && !party.getMotto().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return Objects.equals(getName(), party.getName()) && Objects.equals(getMotto(), party.getMotto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMotto());
    }

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }
}
