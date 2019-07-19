package com.nirvana.learning.dynamoclient;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class SegmentationData {

    private String segment_name;

    private BigDecimal revenue;

    private BigDecimal operating_income;

}
