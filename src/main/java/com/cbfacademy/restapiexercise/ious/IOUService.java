package com.cbfacademy.restapiexercise.ious;


import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.List;


import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

//import jakarta.persistence.Id;


@Service

public class IOUService {


    public final IOURepository iouRepository;

    //instance of iou repo
    public IOUService(IOURepository iouRepository){
        this.iouRepository = iouRepository;
    }

    //List<IOU> getAllIOUs();
    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
        
    }

    //IOU getIOU(UUID id) throws NoSuchElementException;
    public IOU getIOU(UUID id) throws NoSuchElementException {
        return iouRepository.findById(id).orElseThrow(() -> new NoSuchElementException("\"IOU with id \" + id + \" not found\""));
    }

    // IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException;
    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        if (iou.getId() != null) {
            throw new IllegalArgumentException("New IOU should not have an existing ID");
        } try {
        return iouRepository.save(null);
     } catch (OptimisticLockingFailureException e) {
        throw new OptimisticLockingFailureException("Failed to create IOU due to optimistic locking");
    }
}
    //IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException;
    public IOU updateIOU(UUID id , IOU updatedIOU) throws NoSuchElementException{
    
       IOU originalIOU = iouRepository.findById(id).orElseThrow(() -> new NoSuchElementException("IOU with id " + id + " not found"));

        // Update the existing IOU with values from updatedIOU (depends on your model fields)
        originalIOU.setBorrower(updatedIOU.getBorrower());
        originalIOU.setAmount(updatedIOU.getAmount());  // Assuming there is an amount field
        // Set any other updatable fields...

        return iouRepository.save(originalIOU);  // save will perform both create and update
    }
    
    //void deleteIOU(UUID id);
    void deleteIOU(UUID id){
        if (!iouRepository.existsById(id)) {
            throw new NoSuchElementException("IOU with id " + id + " not found");
        }
        iouRepository.deleteById(id);
        //iouRepository.delete(null);
    }

}
  





    

 