package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.entities.AdminsEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminRepositoryTest {
    private AdminsEntity admin;
    private AdminRepository adminRepository;
    private List<AdminsEntity> allAdmins;

    @BeforeEach
    void setUp() {
        this.admin=new AdminsEntity("a23","p16");
        this.adminRepository=AdminRepository.getInstance();
        this.allAdmins=adminRepository.getAll();

    }

    @AfterEach
    void tearDown() {
        adminRepository.delete(admin);
    }

    @Test
    void save() {
        List<AdminsEntity> admins =adminRepository.getAll();
        adminRepository.save(admin);
        Assertions.assertNotEquals(admins,adminRepository.getAll());
    }

    @Test
    void update() {
        List<AdminsEntity> admins = adminRepository.getAll();
        AdminsEntity a = adminRepository.getById(1);
        a.setUsername("admin");
        a.setPassword("1234");
        adminRepository.update(a);
        Assertions.assertNotEquals(admins,adminRepository.getAll());
    }

    @Test
    void delete() {
        List<AdminsEntity> admins =adminRepository.getAll();
        adminRepository.delete(admin);
        Assertions.assertEquals(admins,adminRepository.getAll());
    }

    @Test
    void getById() {
        AdminsEntity a1=adminRepository.getById(1);
        AdminsEntity a2=adminRepository.getById(1);
        Assertions.assertEquals(a1,a2);
    }

    @Test
    void getAll() {
        List<AdminsEntity> all=adminRepository.getAll();
        List<AdminsEntity> all2=adminRepository.getAll();
        Assertions.assertEquals(all,all2);
    }
}