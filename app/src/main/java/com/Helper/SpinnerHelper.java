package com.Helper;

import org.angmarch.views.NiceSpinner;

import java.util.LinkedList;
import java.util.List;

public class SpinnerHelper {
    public static void set(List<String> dataList, NiceSpinner niceSpinner){
        List<String> data = new LinkedList<>(dataList);
        niceSpinner.attachDataSource(data);
    }
}
