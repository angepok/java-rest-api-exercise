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
import com.cbfacademy.restapiexercise.*;


@RestController
@RequestMapping("/api/ious")

public class IOUController {



    @GetMapping("/{id}", produces = "application/json")
    public IOU findIOUById(@PathVariable int id) {
        return findIOUById(id);
    }

    @GetMapping("/all")
    public List<IOU> getAllIOUs(){
        return getAllIOUs();
    }

    @PutMapping("/{id}", produces = "application/json")
    public IOU updateIOU(@PathVariable int id, @RequestBody IOU updatedIOU)
    {
        IOU originalIOU = findIOUById(id);

        return updateIOU(originalIOU, updatedIOU);
    }

    @PostMapping("/{id}", produces = "application/json")
    public IOU postIOU(@PathVariable int id, @RequestBody IOU newIOU)
    {
        IOU newIOU = IOU(id);
        return postIOU(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIOUById(@PathVariable int id){

    };
    }

