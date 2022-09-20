package com.telstra.springbootdemo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.springbootdemo.exception.CricketerNotFoundException;
import com.telstra.springbootdemo.exception.DuplicateCricketerException;
import com.telstra.springbootdemo.model.Cricketer;

@RestController
@RequestMapping("/cricketer")
public class CricketerController {

	private static ArrayList<Cricketer> cricketers;
	static {
		cricketers=new ArrayList<>();
		cricketers.add(new Cricketer("Mithali Raj", "mithali",35, 40, 42, 0));
		cricketers.add(new Cricketer("Smriti Mandana","smriti", 56, 45, 4, 1));
		cricketers.add(new Cricketer("Pooja Vastrakar", "pooja",65, 50, 3, 2));
		cricketers.add(new Cricketer("Harmanpreet Kaur", "harmanpreet",112, 87, 6, 3));
		cricketers.add(new Cricketer("Sneha Rana", "sneha",89, 65, 6, 4));
	}
	@GetMapping("/{shortName}")
	public Cricketer getCricketer(@PathVariable String shortName) {
		
		for(Cricketer ck:cricketers) {
			if(ck.getShortName().equals(shortName)) {
				return ck;
			}
		}
		throw new CricketerNotFoundException();		//Exception 
		//return null;	
	}
	
	@GetMapping("/")
	public ArrayList<Cricketer> getAllCricketers(){
		return cricketers;
	}
	
	// REST end point localhost:8081/cricketer/add  -> Cricketer object to be sent along
	
	@PostMapping("/")
	public ResponseEntity<String> addCricketer(@RequestBody Cricketer ck) {
		
		for(Cricketer ckt:cricketers) {
			if(ckt.getShortName().equals(ck.getShortName())) {
				throw new DuplicateCricketerException();			// Throwing Exception
			}
		}
		cricketers.add(ck);
		return new ResponseEntity<String>("Cricketer data saved successfully with name:"+ck.getName(),HttpStatus.OK);
	
	}
	
	
	@DeleteMapping("/{shortName}")
	public ResponseEntity<String> deleteCricketer(@PathVariable String shortName) {	
		cricketers.remove(getCricketer(shortName));
		return new ResponseEntity<String>("Cricketer Deleted with shortName:"+shortName,HttpStatus.OK);
	}
	
	
	@PutMapping("/{shortName}")
	public ResponseEntity<String> updateCricketer(@PathVariable String shortName,@RequestBody Cricketer updatedCricketer) {
		double runRate = (double)updatedCricketer.getRuns()/(double)updatedCricketer.getBalls();
		updatedCricketer.setRunRate(runRate);
		int index=cricketers.indexOf(getCricketer(shortName));
		
		cricketers.get(index).setRuns(updatedCricketer.getRuns());
		cricketers.get(index).setBalls(updatedCricketer.getBalls());
		cricketers.get(index).setFours(updatedCricketer.getFours());
		cricketers.get(index).setSixes(updatedCricketer.getSixes());
		cricketers.get(index).setRunRate(updatedCricketer.getRunRate());
		
		/*
		 * cricketers.remove(getCricketer(shortName));
		 * cricketers.add(index,updatedCricketer);
		 */		
		return new ResponseEntity<String>("Cricketer Updated with shortName:"+shortName,HttpStatus.OK);
	}
	
	
	
}
