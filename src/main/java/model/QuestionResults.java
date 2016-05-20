package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
@Table(name = "Question_Results")
//@Data
//@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString(doNotUseGetters = true)
//@EqualsAndHashCode(doNotUseGetters = true)

public class QuestionResults implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_session_id", nullable = false)
    @NotNull
    private TestSession testSessionId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "qc_id", nullable = false)
    @NotNull
    private QuestionConnections questionConnectionsId;

    @Basic
    @NotNull
    @Column(name = "result")
    private Integer result;

    public QuestionResults(Integer result) {
        this.result = result;
    }
}
