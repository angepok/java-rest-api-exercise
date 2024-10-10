package com.cbfacademy.restapiexercise.ious;


import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import jakarta.persistence.Id;


@Service

public class IOUService {

    //@Autowired

    public final IOURepository iouRepository;

    //instance of iou repo
    public IOUService(IOURepository iouRepository){
        this.iouRepository = iouRepository;
    }

    //List<IOU> getAllIOUs();
    //IOU getIOU(UUID id) throws NoSuchElementException;
   // IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException;
    //IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException;
    //void deleteIOU(UUID id);

    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
        
    }

    public IOU getIOU(UUID id) {
        return iouRepository.findById(id).get();
    }

    public IOU createIOU(IOU iou){
        return iouRepository.save(null);

    }

    public IOU updatedIOU(UUID id , IOU updatedIOU){
       // IOU iou = iouRepository.findById(id).orElseThrow().;
        return iouRepository.save(null);
       // return IOURepository.updateIOU();

    }

    void deleteIOU(UUID id){
        iouRepository.delete(null);
    }

}
  





    

 