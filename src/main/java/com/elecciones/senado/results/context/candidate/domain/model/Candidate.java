package com.elecciones.senado.results.context.candidate.domain.model;

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
public class Candidate {

    private Long id;
    private Long cardNumber;
    private String resolutionNumber;
    private String name;
    private String lastName;
    private Party party;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private String state;

    public boolean isValid(Candidate candidate) {
        if(candidate.getCardNumber() == null ||
                candidate.getResolutionNumber() == null ||
                candidate.getName() == null ||
                candidate.getLastName() == null ||
                candidate.getParty() == null) return false;

        if(candidate.getParty().getId() == null) return false;

        if(candidate.getCardNumber() <= 0 || candidate.getParty().getId() <= 0) return false;

        return !candidate.getResolutionNumber().isEmpty() &&
                !candidate.getName().isEmpty() &&
                !candidate.getLastName().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(getCardNumber(), candidate.getCardNumber()) &&
                Objects.equals(getResolutionNumber(), candidate.getResolutionNumber()) &&
                Objects.equals(getName(), candidate.getName()) &&
                Objects.equals(getLastName(), candidate.getLastName()) &&
                Objects.equals(getParty().getId(), candidate.getParty().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardNumber(), getResolutionNumber(), getName(), getLastName(), getParty());
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", resolutionNumber='" + resolutionNumber + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", party=" + party.toString() +
                '}';
    }
}