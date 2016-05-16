package model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Tests")
public class Tests implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "subject_id", nullable = false)
    @NotNull
    private Subjects subjectId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Column(name = "description")
    private String description;

    @Basic
    @NotNull
    @Column(name = "publicity")
    private boolean publicity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testsId")
    private Set<QuestionConnections> questionConnectionses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testId")
    private Set<TestAvailability> testAvailabilityes;


    @Override
    public String toString() {
        return "Tests{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectId=" + subjectId +
                ", description='" + description + '\'' +
                ", publicity=" + publicity +
                ", questionConnectionses=" + questionConnectionses +
                ", testAvailabilityes=" + testAvailabilityes +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublicity() {
        return publicity;
    }

    public void setPublicity(boolean publicity) {
        this.publicity = publicity;
    }

    public Set<QuestionConnections> getQuestionConnectionses() {
        return questionConnectionses;
    }

    public void setQuestionConnectionses(Set<QuestionConnections> questionConnectionses) {
        this.questionConnectionses = questionConnectionses;
    }

    public Set<TestAvailability> getTestAvailabilityes() {
        return testAvailabilityes;
    }

    public void setTestAvailabilityes(Set<TestAvailability> testAvailabilityes) {
        this.testAvailabilityes = testAvailabilityes;
    }
}
