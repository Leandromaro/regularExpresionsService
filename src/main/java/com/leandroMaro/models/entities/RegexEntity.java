package com.leandroMaro.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by leandromaro on 2/1/17.
 */

@Entity
@Table(name = "WordsAndExpresions")

public class RegexEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String word;

    private String regularExpresion;


    public RegexEntity(Integer id) {
        this.id = id;
    }

    public RegexEntity() {
    }

    public RegexEntity(String word, String regularExpresion) {
        this.word = word;
        this.regularExpresion = regularExpresion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getRegularExpresion() {
        return regularExpresion;
    }

    public void setRegularExpresion(String regularExpresion) {
        this.regularExpresion = regularExpresion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegexEntity)) return false;
        RegexEntity that = (RegexEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(word, that.word) &&
                Objects.equals(regularExpresion, that.regularExpresion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, regularExpresion);
    }

    @Override
    public String toString() {
        return "RegexEntity{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", regularExpresion='" + regularExpresion + '\'' +
                '}';
    }
}
