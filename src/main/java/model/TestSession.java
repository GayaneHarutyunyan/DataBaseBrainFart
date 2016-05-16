package model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "Test_Session")
public class TestSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private Users userId;

    @NotNull
    @Column(name = "submit_date")
    private Date submitDate;

    @NotNull
    @Column(name = "test_result")
    private Integer testResult;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testSessionId")
    private Set<QuestionResults> questionResultses;


    @Override
    public String toString() {
        return "TestSession{" +
                "id=" + id +
                ", userId=" + userId +
                ", submitDate=" + submitDate +
                ", testResult=" + testResult +
                ", questionResultses=" + questionResultses +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getTestResult() {
        return testResult;
    }

    public void setTestResult(Integer testResult) {
        this.testResult = testResult;
    }

    public Set<QuestionResults> getQuestionResultses() {
        return questionResultses;
    }

    public void setQuestionResultses(Set<QuestionResults> questionResultses) {
        this.questionResultses = questionResultses;
    }
}
