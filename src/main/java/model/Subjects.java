package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Subjects")
//@Data
@Accessors(chain = true)
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
//@ToString(doNotUseGetters = true)
//@EqualsAndHashCode(doNotUseGetters = true)

public class Subjects implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "subject")
    private String subject;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subjectId")
    private Set<Tests> testses=new HashSet<>();

    public Subjects(String subject) {
        this.subject = subject;
    }
}
