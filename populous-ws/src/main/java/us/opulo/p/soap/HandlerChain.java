package us.opulo.p.soap;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.hibernate.SessionManager;

public class HandlerChain implements SOAPHandler<SOAPMessageContext>{

	private static final Logger log = LoggerFactory.getLogger(HandlerChain.class);
	
	@Override
	public void close(MessageContext arg0) {
		log.info("Closing session...");
		SessionManager.close();
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext arg0) {
		
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}
}
 