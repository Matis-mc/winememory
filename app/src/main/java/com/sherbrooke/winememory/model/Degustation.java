package com.sherbrooke.winememory.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Degustation implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    private Type type;

    private String appelation;

    private int year;

    private String nom;

    private int equilibre;

    private int harmonie;

    private int complexite;

    private int persistance;

    private int note;

    private String comment;

    public Degustation(Type type, String appelation, int year, String nom, int equilibre, int harmonie, int complexite, int persistance, int note, String comment) {
        this.type = type;
        this.appelation = appelation;
        this.year = year;
        this.nom = nom;
        this.equilibre = equilibre;
        this.harmonie = harmonie;
        this.complexite = complexite;
        this.persistance = persistance;
        this.note = note;
        this.comment = comment;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAppelation() {
        return appelation;
    }

    public void setAppelation(String appelation) {
        this.appelation = appelation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEquilibre() {
        return equilibre;
    }

    public void setEquilibre(int equilibre) {
        this.equilibre = equilibre;
    }

    public int getHarmonie() {
        return harmonie;
    }

    public void setHarmonie(int harmonie) {
        this.harmonie = harmonie;
    }

    public int getComplexite() {
        return complexite;
    }

    public void setComplexite(int complexite) {
        this.complexite = complexite;
    }

    public int getPersistance() {
        return persistance;
    }

    public void setPersistance(int persistance) {
        this.persistance = persistance;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degustation that = (Degustation) o;
        return type == that.type && Objects.equals(appelation, that.appelation) && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, appelation, nom);
    }
}