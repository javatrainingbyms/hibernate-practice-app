package in.serosoft;

import lombok.Data;

@Data
public class Summary {
	private String branch;
	private double average;
	private long total;
	private int maximum;
	private int minimum;
	private long count;
}
