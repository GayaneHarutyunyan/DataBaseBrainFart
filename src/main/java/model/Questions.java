package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Questions")
//@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString(doNotUseGetters = true)
//@EqualsAndHashCode(doNotUseGetters = true)

public class Questions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Column(name = "content")
    private String content;

    @Basic
    @NotNull
    @Column(name = "value")
    private Integer value;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
    private Set<QuestionConnections> questionConnectionses=new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionsId")
    private Set<AnswerOptions> answerOptionses=new HashSet<>();

    public Questions(String content, Integer value) {
        this.content = content;
        this.value = value;
    }
}
