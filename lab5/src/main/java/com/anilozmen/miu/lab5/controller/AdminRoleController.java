package com.anilozmen.miu.lab5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminRoleController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<String> getData() {
        return Arrays.asList(
                "AdminUserData1", "AdminUserData2", "AdminUserData3", "AdminUserData4",
                "AdminUserData5", "AdminUserData6", "AdminUserData7", "AdminUserData8"
        );
    }

}