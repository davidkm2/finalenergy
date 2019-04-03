package davidkm2.finalenergy.service;

import davidkm2.finalenergy.model.Meter;
import davidkm2.finalenergy.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MeterServiceImpl implements MeterService {

    private final MeterRepository mtrrepository;
    @Autowired
    public MeterServiceImpl(MeterRepository mtrrepository) {
        this.mtrrepository = mtrrepository;
    }

    public Double getMetersbyYear(int givenyear){
        return mtrrepository.findByYear(givenyear);
    }

    public Map<String, Double> findAllMonthbyYear (int givenyear){
        return mtrrepository.findAllMonthbyYear(givenyear);
    }

    public List<Double> honapadatok(int givenyear){
        //LinkedHashMap<String, Integer> eredmeny = new LinkedHashMap<>();
        List<Double> results = new ArrayList<>();
        List<Meter> onlygivenyearrecords = new ArrayList<>();
        onlygivenyearrecords = mtrrepository.findAll().stream().filter(x -> x.getMeterdate().getYear()+1900==givenyear).collect(Collectors.toList());
        for(int i=0; i<12; i++){
            double sum = 0;
            boolean existvalue = false;
            for(int j=0; j<onlygivenyearrecords.size(); j++){
                if(onlygivenyearrecords.get(j).getMeterdate().getMonth()==i)
                    existvalue = true;
            }
            if(!existvalue)
                results.add(new Double(0));
            else{
                for(Meter mtr : onlygivenyearrecords){
                    if(mtr.getMeterdate().getMonth()==i)
                        sum += mtr.getConsumption();
                }
            }
            results.add(sum);
        }
        return results;
    }





    @Override
    public double third(int givenyear, String givenmonth){
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July" );
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        int monthnumber = months.indexOf(givenmonth);
        int counter = 0;
        double sum = 0;
        for(int i=0; i<mtrrepository.findAll().size(); i++){
            if((mtrrepository.findAll().get(i).getMeterdate().getYear()+1900==givenyear) && (mtrrepository.findAll().get(i).getMeterdate().getMonth()==monthnumber))
                sum += mtrrepository.findAll().get(i).getConsumption();
        }
        return sum;
    }

    public Meter newmeter(Meter newMeter){
        return mtrrepository.save(newMeter);
    }

    public boolean IsExistAlready(int givenyear, int givenmonth){

        for(Meter record : mtrrepository.findAll()){
            if(record.getMeterdate().getYear() == givenyear && record.getMeterdate().getMonth()==givenmonth)
                return true;
        }
        return false;
    }

    public List<Meter> findAll(){
        return mtrrepository.findAll();
    }
}
