package com.shopdev.demo.controller.user;


import com.shopdev.demo.entity.user.UserEntity;
import com.shopdev.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity add(@RequestBody UserEntity entity){
        return  userService.create(entity);
    }


    @GetMapping("/find")
    public  UserEntity   find(@RequestParam String username,@RequestParam String email)
    {
        return
                userService.findByUsernameAndEmail(username,email)
         ;

    }


    @GetMapping("/getall")
    public Page<UserEntity> getAll(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "20") int size
        ,@RequestParam(defaultValue = "id") String sort,@RequestParam(defaultValue = "desc") String direction)
    {

        Sort.Direction sortDirect = direction.equalsIgnoreCase("asc") ?  Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirect,sort);
        Pageable pageRequest = PageRequest.of(page,size,sortBy);
        return  userService.findAllUsers(pageRequest);
    }

    @GetMapping("/paging")
    public Page<UserEntity> getPaging(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "20") int size
            ,@RequestParam(defaultValue = "id") String sort,@RequestParam(defaultValue = "desc") String direction,@RequestParam String username)
    {

        Sort.Direction sortDirect = direction.equalsIgnoreCase("asc") ?  Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirect,sort);
        Pageable pageRequest = PageRequest.of(page,size,sortBy);

        return  userService.findByUsername(username,pageRequest);
    }

    @GetMapping("/total")
    public Long getTotal()
    {
        return  userService.getTotal();
    }
}
