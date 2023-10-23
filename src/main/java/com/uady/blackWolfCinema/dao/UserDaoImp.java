package com.uady.blackWolfCinema.dao;

import com.uady.blackWolfCinema.model.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verifyEmailAndPassword(User user){
        String query = "FROM User WHERE email = :email";
        List<User> lista= entityManager.createQuery(query)
                .setParameter("email",user.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return false;
        }
        String passwordHasher= lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        return argon2.verify(passwordHasher, user.getPassword());
    }
}
