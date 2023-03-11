package com.repo.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tutorials")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Tutorial {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(nullable = false,unique = true)
private String title;
@Column(nullable = true)
private String description;

private boolean published;

@ManyToMany(fetch = FetchType.LAZY,
cascade = {
		CascadeType.PERSIST,
		CascadeType.MERGE
}
		)
@JoinTable(name = "tutorial_tags",
joinColumns = {
		@JoinColumn(name="tutorial_id")},
inverseJoinColumns = {@JoinColumn(name="tag_id")})
private Set<Tag> tags=new HashSet<>();
public void addTag(Tag tag)
{
this.tags.add(tag);
tag.getTutorials().add(this);
}




}
