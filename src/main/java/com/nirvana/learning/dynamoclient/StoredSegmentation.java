package com.nirvana.learning.dynamoclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoredSegmentation {

    private String company_Id;

    private Date as_of_date;

    private String currency_id;

    /**
     * This Map contains SegmentType as Key and Segmentation Data as value
     */
    private Map<String, List<SegmentationData>> segmentationData;

}
