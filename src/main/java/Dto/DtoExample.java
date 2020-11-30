package Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DtoExample implements Serializable {
    public int id = 1;
    public String name = "example";
    public  final List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(5,3,3,1,0));
    public InnerDto innerDto = new InnerDto();
}
