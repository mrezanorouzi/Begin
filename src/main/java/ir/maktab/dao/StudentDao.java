package ir.maktab.dao;

import ir.maktab.entities.Student;

import javax.persistence.EntityManager;

public class StudentDao extends AbstractJpaDao{
    public StudentDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class getEntityClass() {
        return Student.class;
    }
}
