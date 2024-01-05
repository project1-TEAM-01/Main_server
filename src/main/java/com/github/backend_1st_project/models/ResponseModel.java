package com.github.backend_1st_project.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {
    public Boolean success;
    public String massage;
    public Object data = null;
    public Integer total = null;
}
