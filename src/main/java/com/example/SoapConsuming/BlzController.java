/**
 * 
 */
package com.example.SoapConsuming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thomas_bayer.blz.DetailsType;
import com.thomas_bayer.blz.GetBankResponseType;
import com.thomas_bayer.blz.GetBankType;
import com.thomas_bayer.blz.ObjectFactory;

/**
 * @author snhassengo
 *
 */
@RestController
@RequestMapping("/")
public class BlzController {

	@Autowired
	private SoapClient client;
	
	@GetMapping
	public DetailsType sum(@RequestParam String code) {
		ObjectFactory objectFactory= new ObjectFactory();
		GetBankType type = new GetBankType();
		type.setBlz(code);
		
		GetBankResponseType response = client.getBank("http://www.thomas-bayer.com/axis2/services/BLZService", 
				objectFactory.createGetBank(type));
		return response.getDetails();
	}
}
