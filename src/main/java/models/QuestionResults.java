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
@Table(name = "Question_Results")
@Getter
@Setter
//@NoArgsConstructor
public class QuestionResults extends Model {

    @Basic
    @Column(name = "test_session_id")
    private int testSessionId;
    @Basic
    @Column(name = "qc_id")
    private int qcId;

    private int result;

    @ManyToOne
    @JoinColumn(name = "test_session_id", referencedColumnName = "id",insertable=false, updatable=false)
    private TestSession testSessionByTestSessionId;

    @ManyToOne
    @JoinColumn(name = "qc_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private QuestionConnections questionConnectionsByQcId;

}
