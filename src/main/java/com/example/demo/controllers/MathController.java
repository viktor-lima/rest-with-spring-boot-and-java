package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UnsupportedMathOperationException;
import com.example.demo.math.SimpleMath;
import com.example.demo.utils.NumberConverter;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
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
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(
			@PathVariable(value="numberOne")String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
	)throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/sqrt/{number}")
	public Double sqrtRoot(
			@PathVariable(value="number")String number
	)throws Exception{
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException(
					"Please set a numeric Value"
			);
		}
		return math.sqrtRoot(NumberConverter.convertToDouble(number));
	}


	
}
