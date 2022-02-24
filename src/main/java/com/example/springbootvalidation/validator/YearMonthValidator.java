package com.example.springbootvalidation.validator;

import com.example.springbootvalidation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 매개변수로 받은 s가 yyyyMM 값이다.
        try{
            LocalDate localDate = LocalDate.parse(s+"01", DateTimeFormatter.ofPattern(this.pattern));   // annotation에서 지정한 pattern값대로 s가 잘 들어가 있는지 확인해준다.
        } catch(Exception e){
            return false;
        }
        return true;    // return값이 true이면 정상인 것이다.
    }
}
