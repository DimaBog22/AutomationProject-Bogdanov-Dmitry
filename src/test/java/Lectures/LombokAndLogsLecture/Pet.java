package Lectures.LombokAndLogsLecture;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Pet {

    private String name;
    private String type;
    private Integer age;

}
