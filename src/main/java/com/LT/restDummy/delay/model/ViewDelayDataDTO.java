package com.LT.restDummy.delay.model;

import java.util.ArrayList;
import java.util.List;

public class ViewDelayDataDTO {
    private List<ViewDelayData> viewData;

    public ViewDelayDataDTO() {
        this.viewData = new ArrayList<>();
    }

    public ViewDelayDataDTO(List<ViewDelayData> viewData) {
        this.viewData = viewData;
    }

    public void addViewDelayData(ViewDelayData data) {
        this.viewData.add(data);
    }

    public List<ViewDelayData> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDelayData> viewData) {
        this.viewData = viewData;
    }
}
