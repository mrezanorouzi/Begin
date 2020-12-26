package ir.maktab.dao;

import ir.maktab.entities.Teacher;

import javax.persistence.EntityManager;


public class TeacherDao extends AbstractJpaDao {


    public TeacherDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class getEntityClass() {
        return Teacher.class;
    }
}
