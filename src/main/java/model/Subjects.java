package model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Subjects")
public class Subjects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "subject")
    private String subject;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subjectId")
    private Set<Tests> testses;

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", testses=" + testses +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Tests> getTestses() {
        return testses;
    }

    public void setTestses(Set<Tests> testses) {
        this.testses = testses;
    }
}
