package com.arnugroho.bootcamp10.controller;

import com.arnugroho.bootcamp10.model.DefaultResponse;
import com.arnugroho.bootcamp10.model.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    /*
    untuk mengakses -- /mahasiswa/login
    */
    @PostMapping("/login")
    public DefaultResponse login(@RequestBody LoginDto loginDto){

        DefaultResponse df = new DefaultResponse();
        df.setStatus(Boolean.TRUE);
        df.setMessage("Selamat Login Berhasil");

        return df;
    }
}
