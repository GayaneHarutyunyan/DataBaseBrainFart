package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "answer_option")
@Getter
@Setter
@AllArgsConstructor
public class AnswerOption extends Model {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "questions_id", referencedColumnName = "id")
    private Question questionId;

    @Lob
    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "correctness")
    private boolean correctness;

    @Lob
    @Column(name = "img")
    private String img;

    public AnswerOption() {
        super();
    }

    public AnswerOption(Long id) {
        super(id);
    }
}
