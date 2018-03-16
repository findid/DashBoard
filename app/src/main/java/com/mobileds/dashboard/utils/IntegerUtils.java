package com.mobileds.dashboard.utils;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

public class IntegerUtils {

    /**
     * 得到整数
     *
     * @param data
     * @return
     */
    public static float handle1Data(String data) {
        if (!data.contains(".")) {
            return Float.parseFloat(data + ".0");
        } else if (data.length() == (data.indexOf(".") + 1)) {
            return Float.parseFloat(data);
        } else {
            return Float.parseFloat(data.substring(0, data.indexOf(".") + 1));
        }
    }

    /**
     * 传入0.25689 出 25.6%
     *
     * @param ddata
     * @return
     */
    public static String handle1To1PerData(Double ddata) {
        DecimalFormat percentFormat = new DecimalFormat();
        percentFormat.applyPattern("#0.0%");
        System.out.println();
        return percentFormat.format(ddata);
    }

    /**
     * 传入0.25689 出 25.6%
     *
     * @param ddata
     * @return
     */
    public static String handleDouble12Bit(Double ddata) {
        DecimalFormat percentFormat = new DecimalFormat();
        percentFormat.applyPattern("#0.00");
        System.out.println();
        return percentFormat.format(ddata);
    }


    /**
     * 传入0.25689 出 0.25
     *
     * @param ddata
     * @return
     */
    public static double handleDouble12BitD(Double ddata) {
        DecimalFormat percentFormat = new DecimalFormat();
        percentFormat.applyPattern("#0.00");
        return Double.parseDouble(percentFormat.format(ddata));
    }

    /**
     * @param data
     * @return
     */
    public static float handleFloat(String data) {
        if (data.isEmpty() || data == null) {
            data = "0";
        }
        return Float.parseFloat(data);
    }


}
