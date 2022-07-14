package com.arnugroho.bootcamp10.repository;

import com.arnugroho.bootcamp10.model.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String> {
    Optional<Mahasiswa> findByUsernameAndPassword (String uname, String pass);

}
