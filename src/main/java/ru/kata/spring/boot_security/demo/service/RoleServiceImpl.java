package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {


    private final RoleDAO roleDao;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }


    @Override
    public void save(Role role) {
        roleDao.save(role);
    }


    @Override
    public void update( Role updatedRole) {
        roleDao.update(updatedRole);
    }


    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

}