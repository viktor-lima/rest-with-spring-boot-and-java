package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double greeting(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		// BRL 10,25 but US 10.25
		String number = numberGlobal(strNumber);
		if(isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

	private String numberGlobal(String strNumber) {
		return strNumber.replaceAll(",", ".");
		
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = numberGlobal(strNumber);
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
