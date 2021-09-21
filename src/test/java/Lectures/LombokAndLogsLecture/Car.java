package Lectures.LombokAndLogsLecture;

import lombok.Data;
// @Data can replace @Getter,@Setter, @ToString
@Data
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
// how to add getters and setters to all of parameters!!!
//@Getter
//@Setter
//@ToString
public class Car {

// how to evoid creating getters and setters manually
//  @Getter @Setter
    private String model;
    private Double engine;
    private Integer maxSpeed;

}
