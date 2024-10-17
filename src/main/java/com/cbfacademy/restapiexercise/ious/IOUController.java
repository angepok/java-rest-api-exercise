package com.cbfacademy.restapiexercise.ious;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/api/ious")

public class IOUController {

    // constructor based dependency injection
    public final IOUService iouService;

    public IOUController(IOUService iouService){
    this.iouService = iouService;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public IOU findIOUById(@PathVariable UUID id ) {
        //@RequestParam(required = false) String borrower
        return iouService.getIOU(id);
    }

    @GetMapping
    public List<IOU> getAllIOUs(@RequestParam(required = false) String borrower ){
        if (borrower != null && !borrower.isEmpty()) {
            iouService.getIOUsByBorrower(borrower);
        }
        return iouService.getAllIOUs();
        
    }


    @PutMapping(value = "/{id}", produces = "application/json")
    public IOU updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU)
    {
        return iouService.updateIOU(id, updatedIOU);
        //method abouve takes param id and IOU
    } 


    @PostMapping(produces = "application/json")
    public IOU createIOU(@RequestBody IOU newIOU)
    {
        return iouService.createIOU(newIOU);
    }

    
    @DeleteMapping("/{id}")
    public void deleteIOUById(@PathVariable(value = "id") UUID id){
        iouService.deleteIOU(id);
        }


    @GetMapping("/high")
    public List<IOU> getHighIous(){

        return iouService.getHighValueIous();
    }
    
    @GetMapping("/low")
    public List<IOU> getLowIous(){

        return iouService.getLowValueIous();
    }
    }

