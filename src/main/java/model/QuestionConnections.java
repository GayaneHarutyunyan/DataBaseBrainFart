package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Question_Connections")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)

public class QuestionConnections implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_id", nullable = false)
    @NotNull
    private Tests testsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "question_id", nullable = false)
    @NotNull
    private Questions questionId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionConnectionsId")
    private Set<QuestionResults> questionResultses;
}
