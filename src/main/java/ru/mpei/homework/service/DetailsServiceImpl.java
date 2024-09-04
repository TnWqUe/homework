package ru.mpei.homework.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mpei.homework.model.Current;
import ru.mpei.homework.repository.CurrentRepository;


import java.util.List;

@Service
@Slf4j
public class DetailsServiceImpl implements DetailsService{

    //поле - уставка
    private double setPoint;
    @Autowired
    private CurrentRepository repo;
    @Override
    public void saveSetPoint(double e) {
        this.setPoint=e;
    }

    @Override
    public String findFault(long startIndex, long endIndex) {
        //получаю массив измерений
        List<Current> res=repo.findFault1(startIndex, endIndex);
        String s="";
        boolean flag=false;
        double shortCircuit=Math.sqrt(2)*setPoint;
        int i= 0;
        //проверка
        while ((!flag)&&(i<=endIndex-startIndex)){
            if (res.get(i).getIa()>shortCircuit){
                flag=true;
                s+='A';
            }
            else{
                i+=1;
            }
        }
        flag=false;
        i= 0;
        while ((!flag)&&(i<=endIndex-startIndex)){
            if (res.get(i).getIb()>shortCircuit){
                flag=true;
                s+='B';
            }
            else{
                i+=1;
            }
        }
        flag=false;
        i= 0;
        while ((!flag)&&(i<=endIndex-startIndex)){
            if (res.get(i).getIc()>shortCircuit){
                flag=true;
                s+='C';
            }
            else{
                i+=1;
            }
        }
        String f=s;
        return s;
    }
}
