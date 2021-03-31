package com.tomgregory.themepark.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ThemeParkRide {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private String imagePath;

  public ThemeParkRide(String name, String description, String imagePath) {
    this.name = name;
    this.description = description;
    this.imagePath = imagePath;
  }
}