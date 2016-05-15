package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "QuestionResults")
@Getter
@Setter
@NoArgsConstructor
public class QuestionResults {

    @Basic

    @Column(name = "test_session_id")
    private Long testSessionId;
    @Basic
    @Column(name = "qc_id")
    private Serializable qcId;

    private long result;

    @ManyToOne
    @JoinColumn(name = "test_session_id", referencedColumnName = "id")
    private TestSession testSessionByTestSessionId;

  //  private QuestionConnections questionConnectionsByQcId;
/*
    @Basic
    @Column(name = "test_session_id")
    public Long getTestSessionId() {
        return testSessionId;
    }

    public void setTestSessionId(Long testSessionId) {
        this.testSessionId = testSessionId;
    }

    @Basic
    @Column(name = "qc_id")
    public Serializable getQcId() {
        return qcId;
    }

    public void setQcId(Serializable qcId) {
        this.qcId = qcId;
    }

    @Basic
    @Column(name = "result")
    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionResults that = (QuestionResults) o;

        if (result != that.result) return false;
        if (testSessionId != null ? !testSessionId.equals(that.testSessionId) : that.testSessionId != null)
            return false;
        if (qcId != null ? !qcId.equals(that.qcId) : that.qcId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = testSessionId != null ? testSessionId.hashCode() : 0;
        result1 = 31 * result1 + (qcId != null ? qcId.hashCode() : 0);
        result1 = 31 * result1 + (int) (result ^ (result >>> 32));
        return result1;
    }
*/
    @ManyToOne
    @JoinColumn(name = "test_session_id", referencedColumnName = "id")
    public TestSession getTestSessionByTestSessionId() {
        return testSessionByTestSessionId;
    }

    public void setTestSessionByTestSessionId(TestSession testSessionByTestSessionId) {
        this.testSessionByTestSessionId = testSessionByTestSessionId;
    }
/*
    @ManyToOne
    @JoinColumn(name = "qc_id", referencedColumnName = "id", nullable = false)
    public QuestionConnections getQuestionConnectionsByQcId() {
        return questionConnectionsByQcId;
    }

    public void setQuestionConnectionsByQcId(QuestionConnections questionConnectionsByQcId) {
        this.questionConnectionsByQcId = questionConnectionsByQcId;
    }
    */
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
