package com.LT.restDummy.servises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Необходим для отображения через GUI*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewServiceData {
    private String serviceName;
    private String content;


}
