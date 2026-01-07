package com.code.spring.app.app.features.format.dto;

public class FormatResponseDto {
    private Integer formatId;
    private String formatName;

    public FormatResponseDto(Integer formatId, String formatName){
        this.formatId=formatId;
        this.formatName=formatName;
    }

    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }
}
