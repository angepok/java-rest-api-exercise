package com.cbfacademy.restapiexercise.ious;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api/ious")

public class IOUController {

    // constructor based dependency injection
    public final IOUService iouService;

    public IOUController(IOUService iouService){
    this.iouService = iouService;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public IOU findIOUById(@PathVariable int id) {
        return iouService.getIOU(null);
    }

    @GetMapping("/all")
    public List<IOU> getAllIOUs(){
        return getAllIOUs();
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public IOU updateIOU(@PathVariable int id, @RequestBody IOU updatedIOU)
    {
        IOU originalIOU = findIOUById(id);

        //Update the original IOU with values from updatedIOU
        originalIOU.setAmount(updatedIOU.getAmount());

        return updateIOU(id, updatedIOU);
        //return updateIOU(originalIOU, updatedIOU); doesnt work , 
        //method abouve takes param id and IOU
    }

    @PostMapping(produces = "application/json")
    public IOU createIOU(@RequestBody IOU newIOU)
    {
        return createIOU(newIOU);
    }

    @DeleteMapping("/{id}")
    public void deleteIOUById(@PathVariable int id){

    };
    }

