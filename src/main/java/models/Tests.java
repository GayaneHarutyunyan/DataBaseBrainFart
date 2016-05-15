package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "Tests")
@Getter
@Setter
public class Tests implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "subject_id")
    private Integer subjectId;
    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Subjects subjectsBySubjectId;

    @OneToMany(mappedBy = "testsByTestId")
    private Set<TestAvailability> testAvailabilitiesById;

    @OneToMany(mappedBy = "testsByTestId")
      private Collection<QuestionConnections> questionConnectionsesById;

}
