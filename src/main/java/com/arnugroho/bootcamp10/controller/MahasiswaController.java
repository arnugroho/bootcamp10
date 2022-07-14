package com.arnugroho.bootcamp10.controller;

import com.arnugroho.bootcamp10.model.dto.DefaultResponse;
import com.arnugroho.bootcamp10.model.dto.LoginDto;
import com.arnugroho.bootcamp10.model.entity.Mahasiswa;
import com.arnugroho.bootcamp10.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    /*
    untuk mengakses -- /mahasiswa/login
    */
    @PostMapping("/login")
    public DefaultResponse login(@RequestBody LoginDto loginDto){

        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepository.findByUsernameAndPassword(loginDto.getUname(),loginDto.getPass());

        DefaultResponse df = new DefaultResponse();
        if(optionalMahasiswa.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Berhasil Login");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Maaf Username atau Password salah");
        }


        return df;
    }

    @GetMapping("/byid/{nim}")
    public DefaultResponse getByIdMahasiswa(@PathVariable String nim){
        DefaultResponse df = new DefaultResponse();
        Optional<Mahasiswa> mhsOpt = mahasiswaRepository.findById(nim);
        if(mhsOpt.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data ditemukan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("data tidak ada");
        }
        return df;
    }
}
