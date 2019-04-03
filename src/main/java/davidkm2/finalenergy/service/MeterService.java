package davidkm2.finalenergy.service;

import davidkm2.finalenergy.model.Meter;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public interface MeterService {
    Double getMetersbyYear(int givenyear);
    Map<String, Double> findAllMonthbyYear (int givenyear);
    List<Double> honapadatok (int givenyear);
    double third(int givenyear, String givenmonth);
    Meter newmeter(Meter newMeter);
    boolean IsExistAlready(int givenyear, int givenmonth);
    List<Meter> findAll();
}
