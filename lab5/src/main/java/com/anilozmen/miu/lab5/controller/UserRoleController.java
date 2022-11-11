package com.anilozmen.miu.lab5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRoleController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<String> getData() {
        return Arrays.asList(
                "RoleUserData1", "RoleUserData2", "RoleUserData3", "RoleUserData4",
                "RoleUserData5", "RoleUserData6", "RoleUserData7", "RoleUserData8"
        );
    }

}
