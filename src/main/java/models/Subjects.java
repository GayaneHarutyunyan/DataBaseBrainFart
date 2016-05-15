package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Subjects")
public class Subjects implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "subjectsBySubjectId")
    @Transient
    private Collection<Tests> testsesById;

}
