package com.code.practice.sample.experiment;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class SOAPClientSAAJ {

    /**
     * Starting point for the SAAJ - SOAP Client Testing
     */
    public static void main(String args[]) {
        try {
        	
        	//createSOAPRequest();
        	
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            //String url = "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx";
            String url = "https://demo2jp3prov.jopari.biz/joparisoap/claimvalidation";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

            // Process the SOAP Response
            printSOAPResponse(soapResponse);

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }

    public static final String SCHEMA = "S";
    public static final String SCHEMA_HEADER = "ns2";
    
    
	private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://schemas.xmlsoap.org/soap/envelope/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.setPrefix(SCHEMA);
        envelope.addNamespaceDeclaration(SCHEMA, serverURI);
        
        /*envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");*/
        
        /*
        Constructed SOAP Request Message:
        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
            <SOAP-ENV:Header/>
            <SOAP-ENV:Body>
                <example:VerifyEmail>
                    <example:email>mutantninja@gmail.com</example:email>
                    <example:LicenseKey>123</example:LicenseKey>
                </example:VerifyEmail>
            </SOAP-ENV:Body>
        </SOAP-ENV:Envelope>
         */

        // SOAP Body
        /*SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
        soapBodyElem1.addTextNode("mutantninja@gmail.com");
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
        soapBodyElem2.addTextNode("123");*/

       /* SOAPHeader soapHeader = envelope.getHeader();
        soapHeader.addNamespaceDeclaration("", "");
        SOAPElement soapHeaderElem = soapHeader.addChildElement("Username");
        soapHeaderElem.addNamespaceDeclaration("xmlns:wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        soapHeaderElem.addTextNode("ecw");
        SOAPElement soapHeaderElem2 = soapHeader.addChildElement("Password");
        soapHeaderElem.addNamespaceDeclaration("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
        soapHeaderElem2.addTextNode("ecw");*/
        
        SOAPHeader soapHeader = envelope.getHeader();
        soapMessage.getSOAPHeader().setPrefix("S");
        
        SOAPHeaderElement security = soapHeader.addHeaderElement(new QName("http://schemas.xmlsoap.org/soap/envelope/", "AUTH", "S"));
        //security.addNamespaceDeclaration(SCHEMA,"http://schemas.xmlsoap.org/soap/envelope/");
        security.addAttribute(new QName("http://schemas.xmlsoap.org/soap/actor/next", "actor", SCHEMA), "http://schemas.xmlsoap.org/soap/actor/next");
        //security.setPrefix("S");
        //security.addNamespaceDeclaration("actor","");
        
        
        SOAPElement usernameElement = security.addChildElement("Username");
        SOAPElement passwordElement = security.addChildElement("Password");

        usernameElement.addTextNode("ECWUser@jqa.com");
        passwordElement.addTextNode("jopari123");
        
        /*usernameElement.addTextNode("kbohra@jopari.com");
        passwordElement.addTextNode("abcd1234");*/
        
        
        SOAPBody soapBody = envelope.getBody();
        soapMessage.getSOAPBody().setPrefix("S");
        
        SOAPBodyElement soapBoadyTags = soapBody.addBodyElement(new QName("http://service.soap.jopari.com/", "validateClaim", "ns2"));
        SOAPElement attachElement = soapBoadyTags.addChildElement("Attachments");
        SOAPElement claimElement = soapBoadyTags.addChildElement("Claim");
        attachElement.addTextNode("true");
        claimElement.addTextNode("ISA*00*          *00*          *ZZ*043461392      *ZZ*200787505      *170719*1646*^*00501*000000177*0*P*:~GS*HC*043461392*200787505*20170719*1646*189*X*005010X222A1~ST*837*000000189*005010X222A1~BHT*0019*00*189*20170719*1646*CH~NM1*41*2*ECLINICALWORKS*****46*123123123~PER*IC*EDI SUPPORT*TE*5088363663~NM1*40*2*JOPARI SOLUTIONS*****46*200787505~HL*1**20*1~NM1*85*2*WESTBOROUGH MEMORIAL HOSPITAL OP*****XX*4545454545~N3*123 MAIN ST~N4*WESTBOROUGH*MA*015811234~REF*EI*9876543211~NM1*87*2~N3*123 MAIN ST~N4*WESTBOROUGH*MA*015816181~HL*2*1*22*0~SBR*S*18*******CI~NM1*IL*1*VANDEWATER*MARY****MI*132456~N3*2 WILDEBROOK RD.~N4*MEDWAY*MA*02053~DMG*D8*19690807*F~NM1*PR*2*AETNA*****PI*26337~N3*123 MAIN ST~N4*WESTBOROUGH*MA*01581~CLM*12880*80.00***11:B:1*Y*A*Y*Y~DTP*431*D8*20151006~REF*4N*5~REF*G1*192~HI*ABK:G932~NM1*DN*1*AAJA*KABUTAR****XX*1458562314~NM1*82*1*WILLIS*SAM****XX*1619916293~PRV*PE*PXC*103GC0700X~SBR*P*18*******CI~AMT*D*0.00~OI***Y***Y~NM1*IL*1*VANDEWATER*MARY****MI*ZGA1112222~N3*2 WILDEBROOK RD.~N4*MEDWAY*MA*02053~NM1*PR*2*BLUE CROSS BLUE SHIELD*****PI*12345~N3*PO BOX 123450~N4*WESTBOROUGH*MA*01581~LX*1~SV1*HC:99211*80.00*UN*1.0~DTP*472*RD8*20151006-20151006~LIN**N4*NDC01234567~CTP****10*ME~SE*45*000000189~GE*1*189~IEA*1*000000177~");
        
        /*SOAPElement soapBodyElem = soapBody.addChildElement("Submit837ForEdits", SCHEMA);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("request837", SCHEMA);
        soapBodyElem2.addTextNode("ISA*00*          *00*          *ZZ*1DKS           *ZZ*GATEWAYEDI     *170405*1800*^*00501*149250584*0*T*:~GS*HC*1DKS*GATEWAYEDI*20170405*1800*189249042*X*005010X222A1~ST*837*015755950*005010X222A1~BHT*0019*00*15995822*20170405*1800*CH~NM1*41*2*ECLINICALWORKS*****46*1DKS~PER*IC*EDI SUPPORT*TE*5088363663~NM1*40*2*GATEWAY ANSI*****46*GATEWAYEDI~HL*1**20*1~NM1*85*2*WESTBOROUGH MEMORIAL HOSPITAL OP*****XX*4545454545~N3*123 MAIN ST~N4*WESTBOROUGH*MA*015816181~REF*EI*9876543211~REF*OT*0000~HL*2*1*22*0~SBR*P*18*******MC~NM1*IL*1*SATHISH*ARUN***,,,,,,,*MI*123456~N3*123 MAIN ST~N4*WESTBOROUGH*MA*01581~DMG*D8*20010101*M~NM1*PR*2*MEDICAID OF MASSACHUSETTS*****PI*SB700~N3*PO BOX 2819~N4*BOSTON*MA*02298~CLM*13727*0.00***11:B:1*Y*A*Y*Y~REF*G1*12345~HI*ABK:I714~NM1*DN*1*DEBLANCE*ALYSSA****XX*1138592636~NM1*82*1*WILLIS*SAM****XX*1619916293~PRV*PE*PXC*103GC0700X~NM1*77*2*WESTBOROUGH MEMORIAL HOSPITAL OP*****XX*1234567890~N3*123 MAIN ST~N4*WESTBOROUGH*MA*015811234~SBR*S*18*******CI~OI***Y***Y~NM1*IL*1*SATHISH*ARUN***,,,,,,,*MI*1313213~N3*123 MAIN ST~N4*WESTBOROUGH*MA*01581~NM1*PR*2*21ST CENTURY INSURANCE SERVICES (MINNESO*****PI*51028~N3*PO BOX 29062~N4*PHOENIX*AZ*85038~LX*1~SV1*HC:H2035*0.00*UN*1.0***1~DTP*472*RD8*20160729-20160729~SE*41*015755950~GE*1*189249042~IEA*1*149250584~");*/
        
        /*MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "VerifyEmail");*/

        envelope.removeNamespaceDeclaration("SOAP-ENV");
        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        soapMessage.writeTo(byteArrayOutputStream);
        System.out.println(byteArrayOutputStream.toString());

        return soapMessage;
    }
	
	
	private static SOAPMessage createSOAPRequest2() {
    	
    	SOAPMessage message = null;
    	try {
            
    		MessageFactory messageFactory = MessageFactory.newInstance();
            message = messageFactory.createMessage();
            
            SOAPHeader header = message.getSOAPHeader();
            SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
            if (header == null) {
                header = envelope.addHeader();
            }
            envelope.addNamespaceDeclaration("gat", "http://schemas.datacontract.org/2004/07/Gateway.Servicios");

            QName passwordQname = header.createQName("Password", "gat");
            QName userQname = header.createQName("Username", "gat");

            // Here, I�m trying to add a QName with no namespace.
            QName qNameUserCredentials = new QName(XMLConstants.NULL_NS_URI, "MyHeader");
            SOAPHeaderElement userCredentials = header.addHeaderElement(qNameUserCredentials);

            SOAPHeaderElement password = header.addHeaderElement(passwordQname);
            password.addTextNode("Vg8b173G");

            SOAPHeaderElement username = header.addHeaderElement(userQname);
            username.addTextNode("ecwtest");

            userCredentials.addChildElement(password);
            userCredentials.addChildElement(username);
            message.saveChanges();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            message.writeTo(byteArrayOutputStream);
            System.out.println(byteArrayOutputStream.toString());
        } catch (SOAPException e) {
        	e.printStackTrace();
            System.out.println("Error occurred while adding credentials to SOAP header." + e.getMessage());
        } catch (IOException e) {
        	e.printStackTrace();
            System.out.println("Error occurred while writing message to output stream." + e.getMessage());
        }
    	
    	return message;
	}

    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }

}