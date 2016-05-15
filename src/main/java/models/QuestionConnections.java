package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
public class QuestionConnections {
    private long id;
    private Serializable testId;
    private Serializable questionId;
    private Tests testsByTestId;
    private Questions questionsByQuestionId;
    private Collection<QuestionResults> questionResultsesById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "test_id")
    public Serializable getTestId() {
        return testId;
    }

    public void setTestId(Serializable testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "question_id")
    public Serializable getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Serializable questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionConnections that = (QuestionConnections) o;

        if (id != that.id) return false;
        if (testId != null ? !testId.equals(that.testId) : that.testId != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (testId != null ? testId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id", nullable = false)
    public Tests getTestsByTestId() {
        return testsByTestId;
    }

    public void setTestsByTestId(Tests testsByTestId) {
        this.testsByTestId = testsByTestId;
    }

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
    public Questions getQuestionsByQuestionId() {
        return questionsByQuestionId;
    }

    public void setQuestionsByQuestionId(Questions questionsByQuestionId) {
        this.questionsByQuestionId = questionsByQuestionId;
    }

    @OneToMany(mappedBy = "questionConnectionsByQcId")
    public Collection<QuestionResults> getQuestionResultsesById() {
        return questionResultsesById;
    }

    public void setQuestionResultsesById(Collection<QuestionResults> questionResultsesById) {
        this.questionResultsesById = questionResultsesById;
    }
}
