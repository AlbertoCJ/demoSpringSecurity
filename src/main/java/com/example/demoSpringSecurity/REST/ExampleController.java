package com.example.demoSpringSecurity.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {

    /*
    * Podemos controlar el acceso al recurso a usando roles o permisos:
    * @PreAuthorize("hasRole('user')")     <---- Role
    * @PreAuthorize("hasAuthority('canWrite')")   <----- Permiso
    */

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/protected")
    public ResponseEntity<String> getAllProtected() {

        return new ResponseEntity<>("RESULT PROTECTED", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> getAllAdmin() {

        return new ResponseEntity<>("RESULT ADMIN", HttpStatus.OK);
    }

}
