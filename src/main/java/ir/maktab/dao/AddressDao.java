package ir.maktab.dao;

import ir.maktab.entities.Address;

import javax.persistence.EntityManager;

public class AddressDao  extends AbstractJpaDao{
    public AddressDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class getEntityClass() {
        return Address.class;
    }
}
