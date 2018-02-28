package com.aaron.demo.model;

import java.io.Serializable;

/**
 * Created by JiangHua
 * on 2018/2/26
 */

public class EditModel implements Serializable {
    private String label;
    private String inputContent;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    @Override
    public String toString() {
        return "EditModel{" +
                "label='" + label + '\'' +
                ", inputContent='" + inputContent + '\'' +
                '}';
    }
}
