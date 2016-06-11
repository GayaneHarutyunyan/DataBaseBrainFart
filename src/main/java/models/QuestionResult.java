package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "question_result")
@AllArgsConstructor
@Getter
@Setter
public class QuestionResult extends Model {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "test_session_id", referencedColumnName = "id")
    private TestSession testSessionId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "qc_id", referencedColumnName = "id")
    private QuestionConnection questionConnectionId;

    @NotNull
    @Column(name = "result")
    private Integer result;

    public QuestionResult() {
        super();
    }

    public QuestionResult(Long id) {
        super(id);
    }
}

