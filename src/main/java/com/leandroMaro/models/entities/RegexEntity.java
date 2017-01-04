package com.leandroMaro.models.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by leandromaro on 2/1/17.
 */

@Entity
@Table(name = "WordsAndExpresions")
public class RegexEntity {

    // PRIVATE FIELDS
    // ------------------------
    // ------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String word;

    private String regularExpresions;

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getRegularExpresions() {
        return regularExpresions;
    }

    public void setRegularExpresions(String regularExpresions) {
        this.regularExpresions = regularExpresions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegexEntity)) return false;
        RegexEntity that = (RegexEntity) o;
        return id == that.id &&
                Objects.equals(word, that.word) &&
                Objects.equals(regularExpresions, that.regularExpresions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, regularExpresions);
    }

    @Override
    public String toString() {
        return "RegexEntity{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", regularExpresions='" + regularExpresions + '\'' +
                '}';
    }
}
