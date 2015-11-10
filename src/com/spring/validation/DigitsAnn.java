package com.spring.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


//"@interface" becomes an annotation
@Documented //@DigitsAnn annotation will be included in javadoc of your application
@Target({ElementType.METHOD, ElementType.FIELD}) //this annotation can be usd on a function as weel as a field
@Constraint(validatedBy={DigitValidator.class})  //this class is used to implement the constraints of annotations
@Retention(RetentionPolicy.RUNTIME)  //It's for the spring framework
public @interface DigitsAnn {

	String message() default "{DigitsAnn}";
	
	//The 2 lines below are fixed for customized annotation
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
	
}
