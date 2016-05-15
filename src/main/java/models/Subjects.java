package models;

import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "Subjects")
@Getter
@Setter
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "subject")
    private String subject;

    @Transient
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<Tests> testsesById ;

}
