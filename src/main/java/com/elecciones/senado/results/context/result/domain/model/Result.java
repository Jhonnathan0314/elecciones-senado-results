package com.elecciones.senado.results.context.result.domain.model;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.party.domain.model.Party;
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
public class Result {

    private Long id;
    private Long votes;
    private ElectionTable electionTable;
    private Candidate candidate;
    private Timestamp creationDate;
    private Timestamp updateDate;

    public boolean isValid(Result result) {
        if(result.getVotes() == null ||
                result.getElectionTable() == null ||
                result.getCandidate() == null) return false;

        if(result.getVotes() < 0) return false;

        if(result.getElectionTable().getId() == null || result.getCandidate().getId() == null) return false;

        return result.getElectionTable().getId() > 0 &&
                result.getCandidate().getId() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(getVotes(), result.getVotes()) &&
                Objects.equals(getElectionTable().getId(), result.getElectionTable().getId()) &&
                Objects.equals(getCandidate().getId(), result.getCandidate().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVotes(), getElectionTable(), getCandidate());
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", votes=" + votes +
                ", electionTable=" + electionTable.toString() +
                ", candidate=" + candidate.toString() +
                '}';
    }
}
