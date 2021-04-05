package com.ju.easyexcel_dome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {

    private Integer status;
    private String msg;
    private Object data;

    public static ResultResponse fail(){

        return new ResultResponse(201,"业务调用失败",null);
    }

    public static ResultResponse fail(String msg){

        return new ResultResponse(201,msg,null);
    }

    public static ResultResponse success(){

        return new ResultResponse(200,"业务调用成功",null);
    }

    public static ResultResponse success(Object data){

        return  new ResultResponse(200,"业务调用成功",data);
    }

    public static ResultResponse success(String msg,Object data){

        return new ResultResponse(200,msg,data);
    }

}
