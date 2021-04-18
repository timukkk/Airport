package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


        Map<Fields, String> msg = Parser.parseSCR("SCR\n" +
                "/slots@xyairline.com\n" +
                "S18\n" +
                "20APR\n" +
                "PRG\n" +
                "NXY010 XY011 01MAY01MAY 0200000 168320 MANLHR1125 1215LHRMAN CC\n" +
                "SI YES ITS WORK!!!!!!\n"+
                "GI BLA BLA BLA");

        SCRMsg SCRmsg = new SCRMsg(msg);

        System.out.println("SUPPLEMENTARYINFORM: " + SCRmsg.getFieldValue(Fields.SUPPLEMENTARYINFORM));
        System.out.println("GENERALINFORM: " + SCRmsg.getFieldValue(Fields.GENERALINFORM));
        

    }
}
