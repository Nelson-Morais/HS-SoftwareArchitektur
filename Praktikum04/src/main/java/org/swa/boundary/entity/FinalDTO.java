package org.swa.boundary.entity;

import java.util.ArrayList;
import java.util.List;

public class FinalDTO {

    private List<TeamDataDTO> data = new ArrayList<>();

    public FinalDTO(){}

    public FinalDTO(List<TeamDataDTO> data){
        setData(data);
    }

    public List<TeamDataDTO> getData() {
        return data;
    }

    public void setData(List<TeamDataDTO> data) {
        this.data = data;
    }
}
