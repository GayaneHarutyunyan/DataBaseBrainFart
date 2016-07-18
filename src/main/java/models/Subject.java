package models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;


@Entity
@Table(name = "subject")
@AllArgsConstructor
@Getter
@Setter
public class Subject extends Model {

    @NotNull
    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "subjectId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Test> testses = new HashSet<>();

    public Subject() {
        super();
    }

    public Subject(Long id) {
        super(id);
    }
}
