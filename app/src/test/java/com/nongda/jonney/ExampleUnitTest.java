package com.nongda.jonney;

import android.util.Xml;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        System.out.println("Begin:");
        InputStream paramInputStream =  new URL("http://app.hnis.org/NDAppWebService.asmx/GetTerm?dt=2016-2-19").openConnection().getInputStream();
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(paramInputStream, "UTF-8");
        int i = localXmlPullParser.getEventType();
        System.out.println("result:"+i);



        assertEquals(4, 2 + 2);
    }
}