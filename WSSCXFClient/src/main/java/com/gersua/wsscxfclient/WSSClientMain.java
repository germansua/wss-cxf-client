package com.gersua.wsscxfclient;

import java.util.HashMap;
import java.util.Map;
import org.apache.ws.security.handler.WSHandlerConstants;

/**
 *
 * @author gersuare
 */
public class WSSClientMain {

    /* Parts and namespaces */
    final static String timestampSignPart = "{Content}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp";
    final static String bodySignPart = "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body";
    final static String bstSignPart = "{Content}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}BinarySecurityToken";
    final static String signParts = timestampSignPart + ";" + bodySignPart + ";" + bstSignPart;

    public static void main(String[] args) {

        /* Output interceptor config Map */
        Map<String, Object> ouputWSSProperties = new HashMap<>();

        /* Indicates the WSS Action to execute */
        ouputWSSProperties.put(WSHandlerConstants.ACTION, WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.SIGNATURE);

        // Signature
        ouputWSSProperties.put(org.apache.wss4j.dom.handler.WSHandlerConstants.SIGNATURE_USER, "WSSClientJKSTest");
        ouputWSSProperties.put(org.apache.wss4j.dom.handler.WSHandlerConstants.SIG_PROP_FILE, "crypto.properties");

        // Includes a IssuerSerial signature
        ouputWSSProperties.put(org.apache.wss4j.dom.handler.WSHandlerConstants.SIG_KEY_ID, "IssuerSerial");

        // Includes a BinarySecurityToken
        ouputWSSProperties.put(org.apache.wss4j.dom.handler.WSHandlerConstants.INCLUDE_SIGNATURE_TOKEN, "true");

        // Sing Parts
        ouputWSSProperties.put(org.apache.wss4j.dom.handler.WSHandlerConstants.SIGNATURE_PARTS, signParts);

    }
}
