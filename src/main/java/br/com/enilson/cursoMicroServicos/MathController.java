package br.com.enilson.cursoMicroServicos;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.enilson.cursoMicroServicos.exception.handler.UnsupportedMathOperationException;

@RestController
public class MathController {
	//private static final String template
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value= "numberOne")String numberOne,
			@PathVariable(value= "numberTwo")String numberTwo			
			) throws Exception, UnsupportedMathOperationException{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
 		}
		return convertDouble(numberOne)+ convertDouble(numberTwo);
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}",
				method=RequestMethod.GET)
	public Double subtraction(
				@PathVariable(value= "numberOne")String numberOne,
				@PathVariable(value= "numberTwo")String numberTwo			
				) throws Exception, UnsupportedMathOperationException{
			if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
		
		   return convertDouble(numberOne)- convertDouble(numberTwo);
	}
	@RequestMapping(value="/division/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double division(
			@PathVariable(value= "numberOne")String numberOne,
			@PathVariable(value= "numberTwo")String numberTwo			
			) throws Exception, UnsupportedMathOperationException{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertDouble(numberOne)/ convertDouble(numberTwo);
	}
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value= "numberOne")String numberOne,
			@PathVariable(value= "numberTwo")String numberTwo			
			) throws Exception, UnsupportedMathOperationException{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertDouble(numberOne)* convertDouble(numberTwo);
	}

	private Double convertDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
