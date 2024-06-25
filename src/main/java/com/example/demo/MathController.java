package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
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
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		Double result = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return result;
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		Double aux = Double.parseDouble(numberTwo);
		if(aux == 0 ) {
			throw new UnsupportedMathOperationException(
					"No number can be divided by zero"
			);
		}
		Double result = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return result;
	}
	
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		Double result = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		return result;
	}
	
	@GetMapping("/sqrt/{number}")
	public Double sqrtRoot(
			@PathVariable(value="number")String number
	)throws Exception{
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		Double result = Math.sqrt(convertToDouble(number));
		return result;
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
