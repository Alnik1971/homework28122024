package ru.netology.SpringHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @EmbeddedId
    private PersonId personId;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;

}
