package com.nirvana.learning.dynamoclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nirvana.learning.dynamoclient.SegmentationData;
import com.nirvana.learning.dynamoclient.StoredSegmentation;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class JSONCreator {

    public static void main(String[] args) {
        try {
            StoredSegmentation storedSegmentation = new StoredSegmentation();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
            String dateString = "2018-09-30";
            Date date;
            date = dateFormat.parse(dateString);
            storedSegmentation.setCompany_Id("0C00000ADA");
            storedSegmentation.setAs_of_date(date);
            SegmentationData segmentationData = new SegmentationData();
            storedSegmentation.setCurrency_id("USD");
            segmentationData.setSegment_name("iPad");
            segmentationData.setOperating_income(BigDecimal.valueOf(166699000000.00));
            segmentationData.setRevenue(BigDecimal.valueOf(18805000000.00));
            Map<String, List<SegmentationData>> segmentationDataMap = new HashMap<>();
            segmentationDataMap.put("Business", Arrays.asList(segmentationData));
            storedSegmentation.setSegmentationData(segmentationDataMap);
            Gson gsonBuilder = new GsonBuilder().create();
            String jsonFromPojo = gsonBuilder.toJson(storedSegmentation);
            System.out.println(jsonFromPojo);
        } catch (Exception e) {
            System.out.println("Exception while formatting date" + e);
        }
    }


}
