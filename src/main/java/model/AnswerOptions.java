package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
@Table(name = "Answer_Options")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)

public class AnswerOptions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "questions_id", nullable = false)
    @NotNull
    private Questions questionsId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Column(name = "content")
    private String content;

    @Basic
    @NotNull
    @Column(name = "correctness")
    private boolean correctness;
}
