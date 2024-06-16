package com.elecciones.senado.results.context.election_table.domain.model;

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
public class ElectionTable {

    private Long id;
    private Long numberIds;
    private Long totalVotes;
    private String location;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private String state;

    public boolean isValid(ElectionTable electionTable) {
        if(electionTable.getNumberIds() == null ||
                electionTable.getTotalVotes() == null ||
                electionTable.getLocation() == null) return false;
        return !electionTable.getLocation().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectionTable electionTable = (ElectionTable) o;
        return Objects.equals(getNumberIds(), electionTable.getNumberIds()) && Objects.equals(getTotalVotes(), electionTable.getTotalVotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberIds(), getTotalVotes());
    }

    @Override
    public String toString() {
        return "ElectionTable{" +
                "id=" + id +
                ", numberIds=" + numberIds +
                ", totalVotes=" + totalVotes +
                '}';
    }
}
