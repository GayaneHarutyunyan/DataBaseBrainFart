package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "question")
@AllArgsConstructor
@Getter
@Setter
public class Question extends Model {

    @Lob
    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "value")
    private Integer value;

    @Lob
    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionConnection> questionConnectionses = new HashSet<>();

    @OneToMany(mappedBy = "questionsId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AnswerOption> answerOptionses = new HashSet<>();

    public Question() {
        super();
    }

    public Question(Long id) {
        super(id);
    }
}
