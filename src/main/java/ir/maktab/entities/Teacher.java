package ir.maktab.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    Double salary;

    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @ManyToMany(mappedBy = "teachers")
    Set<Student> students = new HashSet<>();

    @Column(name = "teacher_code", nullable = false, unique = true)
    Integer teacherCode;

    @Column(nullable = true)
    Date birthDay;

    @Column(name = "phone_number",nullable = false, unique = true)
    String phoneNumber;
}
