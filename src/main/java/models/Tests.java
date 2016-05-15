package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Tests")

public class Tests implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Subjects subjectsBySubjectId;

    @Basic
    @Column(name = "description")
    private String description;

/*

    @OneToMany(mappedBy = "testsByTestId")
    @Transient
    private Set<TestAvailability> testAvailabilitiesById;

    @OneToMany(mappedBy = "testsByTestId")
    @Transient
    private Collection<QuestionConnections> questionConnectionsesById;
/*
    @Basic
    @Column(name = "subject_id")
    private Integer subjectId;

   */
}
