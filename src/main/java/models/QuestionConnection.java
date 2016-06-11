package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "question_connection")
@Setter
@Getter
@AllArgsConstructor
public class QuestionConnection extends Model {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test testId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question questionId;

    @OneToMany(mappedBy = "questionConnectionsId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionResult> questionResultses = new HashSet<>();

    public QuestionConnection() {
        super();
    }

    public QuestionConnection(Long id) {
        super(id);
    }
}
