package com.cbfacademy.restapiexercise.ious;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface IOURepository extends ListCrudRepository<IOU, UUID>{
    public List<IOU> findByBorrower (String borrower);
    
    
    @Query("SELECT i FROM IOU i where i.amount > (SELECT AVG(i.amount) FROM IOU i)")
    public List<IOU> findHighValueIOUs();
    //public List<IOU> FindIOUsAboveAverageByAmount();
    //public List<IOU> FindIOUsAboveAverageByAmount(BigDecimal amount);

    @Query("SELECT i FROM IOU i where i.amount <= (SELECT AVG(i2.amount) FROM IOU i2)")
    public List<IOU> findLowValueIOUs();
}
