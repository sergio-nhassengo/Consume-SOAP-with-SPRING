/**
 * 
 */
package com.example.SoapConsuming;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.thomas_bayer.blz.GetBankResponseType;

/**
 * @author snhassengo
 *
 */
public class SoapClient extends WebServiceGatewaySupport {
	public GetBankResponseType getBank(String url, Object request) {
		JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request);
		return (GetBankResponseType) res.getValue();
	}
}
