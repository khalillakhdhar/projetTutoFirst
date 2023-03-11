package com.repo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDetails {
@Id
private long id;
private Date createdOn;
private String createdBy;

@OneToOne
@MapsId // écrase et remplace le id par l'élément de référence
@JoinColumn(name="tutorial_id")
private Tutorial tutorial;
}
