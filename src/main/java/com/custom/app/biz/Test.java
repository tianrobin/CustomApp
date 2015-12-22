package com.custom.app.biz;

import java.io.IOException;
import java.io.InputStream;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

public class Test {

    public static void main(String[] args) throws MarshalException, ValidationException {
        //ClassLoader        .getSystemResourceAsStream("com/custom/app/biz/Custom.xml");
        InputStream xmlInputStream = null;
            xmlInputStream = ClassLoader.getSystemResourceAsStream("com/custom/app/biz/Custom.xml");

//                Custom.class.getClassLoader().getSystemResourceAsStream(
//            "Custom.xml");
        Unmarshaller unmarshaller = new Unmarshaller(Custom.class);
        InputSource inputSource = new InputSource(xmlInputStream);
        Custom person = (Custom) unmarshaller.unmarshal(inputSource);
        System.out.println(person.getAddress());
    }
}
