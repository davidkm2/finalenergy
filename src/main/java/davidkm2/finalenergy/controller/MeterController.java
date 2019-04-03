package davidkm2.finalenergy.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import davidkm2.finalenergy.exceptions.AlreadyExistException;
import davidkm2.finalenergy.exceptions.YearNotFoundException;
import davidkm2.finalenergy.model.FirstResponse;
import davidkm2.finalenergy.model.Meter;
import davidkm2.finalenergy.model.SecondResponse;
import davidkm2.finalenergy.model.ThirdResponse;
import davidkm2.finalenergy.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MeterController {
    private final MeterService mtrservice;
    @Autowired
    public MeterController(MeterService mtrservice) {
        this.mtrservice = mtrservice;
    }
    @RequestMapping(value = "/meter/first", method = RequestMethod.GET, produces = "application/json")
    public FirstResponse index(@RequestParam(value="givenyear") int givenyear) {

        if(mtrservice.findAll().isEmpty())
            throw new YearNotFoundException("year:" + givenyear);
        else
            return new FirstResponse(givenyear, mtrservice.getMetersbyYear(givenyear));


    }

    @RequestMapping(value ="/meter/second", method = RequestMethod.GET, produces = "application/json")
    public SecondResponse Index(@RequestParam(value = "givenyear") int givenyear){
        List<Double> result = new ArrayList<>();
        result = mtrservice.honapadatok(givenyear);
        return new SecondResponse(givenyear, result.get(0), result.get(1), result.get(2), result.get(3), result.get(4), result.get(5), result.get(6), result.get(7), result.get(8), result.get(9), result.get(10), result.get(11));

    }

    @RequestMapping(value = "/meter/third", params = { "givenyear", "givenmonth"}, method = RequestMethod.GET, produces = "application/json")
    public ThirdResponse Index(@RequestParam(value = "givenyear" ) int givenyear, @RequestParam(value = "givenmonth") String givenmonth){
        return new ThirdResponse(givenyear, givenmonth, mtrservice.third(givenyear, givenmonth));

    }

    @RequestMapping(value = "/meter/new", method = RequestMethod.POST)
    public Meter newmeter(@RequestBody Meter newMeter){
        if(mtrservice.IsExistAlready(newMeter.getMeterdate().getYear(), newMeter.getMeterdate().getMonth()))
            throw new AlreadyExistException();
        else
            return mtrservice.newmeter(newMeter);
    }




}