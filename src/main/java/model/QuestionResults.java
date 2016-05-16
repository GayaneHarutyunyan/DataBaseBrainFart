package model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
@Table(name = "Question_Results")
public class QuestionResults implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_session_id", nullable = false)
    @NotNull
    private TestSession testSessionId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "qc_id", nullable = false)
    @NotNull
    private QuestionConnections questionConnectionsId;

    @Basic
    @NotNull
    @Column(name = "result")
    private Integer result;

    @Override
    public String toString() {
        return "QuestionResults{" +
                "id=" + id +
                ", testSessionId=" + testSessionId +
                ", questionConnectionsId=" + questionConnectionsId +
                ", result=" + result +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TestSession getTestSessionId() {
        return testSessionId;
    }

    public void setTestSessionId(TestSession testSessionId) {
        this.testSessionId = testSessionId;
    }

    public QuestionConnections getQuestionConnectionsId() {
        return questionConnectionsId;
    }

    public void setQuestionConnectionsId(QuestionConnections questionConnectionsId) {
        this.questionConnectionsId = questionConnectionsId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
