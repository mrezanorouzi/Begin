package ir.maktab.entities;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "phone_number",nullable = false, unique = true)
    String phoneNumber;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;


    @OneToMany(fetch = FetchType.LAZY)
    Set<Address> addressSet = new HashSet<>();

    @ManyToMany
            @JoinTable(name = "stu_tch",
                    joinColumns = @JoinColumn(name = "Student_id"),
                    inverseJoinColumns = @JoinColumn(name = "Teacher_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
     private Set<Teacher> teachers;

    @Column(name = "student_code", nullable = false, unique = true)
    Integer studentCode;

    @Temporal(TemporalType.DATE)
    Date birthDay;
}
