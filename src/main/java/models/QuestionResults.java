package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Question_Results")

public class QuestionResults implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "test_session_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TestSession testSessionId;

    @ManyToOne
    @JoinColumn(name = "qc_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private QuestionConnections questionConnectionsByQcId;

    @Basic
    @Column(name = "result")
    private int result;


/*
    @ManyToOne
    @JoinColumn(name = "test_session_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TestSession testSessionByTestSessionId;




*/

}
