package com.ashok.whiteboard.model;

import lombok.Data;

@Data
public class DrawAction {
    private String type; // "begin", "draw", "end"
    private double x;
    private double y;
    private String color;
    private double lineWidth;


}
