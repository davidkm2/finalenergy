package davidkm2.finalenergy.repository;

import davidkm2.finalenergy.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface MeterRepository extends JpaRepository<Meter,Long> {
    @Transactional
            @Query(value = "SELECT SUM(consumption) FROM Meter WHERE year(meterdate) = :givenyear",nativeQuery = true)
    Double findByYear(@Param("givenyear") int givenyear);
    @Transactional
            @Query(value = "SELECT monthname(meterdate), consumption FROM Meter WHERE year(meterdate) = :givenyear GROUP BY monthname(meterdate)",nativeQuery = true)
    Map<String, Double> findAllMonthbyYear(@Param("givenyear") int givenyear);




}
