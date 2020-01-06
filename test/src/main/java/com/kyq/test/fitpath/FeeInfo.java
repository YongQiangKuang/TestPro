package com.kyq.test.fitpath;

import com.google.common.collect.Lists;
import com.sun.jna.Structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeeInfo extends Structure {

    public FeeInfo() {
        super(ALIGN_NONE);
    }

    public int payFee;

    public int discountFee;

    public int fee;

    public byte[] paramVersion = new byte[14];

    public int feeSpecial;

    public byte[] tollIntervalIDs = new byte[851];

    public byte[] payFeeGroup = new byte[401];

    public byte[] discountFeeGroup = new byte[401];

    public byte[] feeGroup = new byte[401];

    public byte[] feeInfo1 = new byte[401];

    public byte[] feeInfo2 = new byte[401];

    public byte[] feeInfo3 = new byte[401];

    public byte[] feeLogMsg = new byte[501];

    @Override
    protected List<String> getFieldOrder() {
        List<String> list = Lists.newArrayList();
        list.add("payFee");
        list.add("discountFee");
        list.add("fee");
        list.add("paramVersion");
        list.add("feeSpecial");
        list.add("tollIntervalIDs");
        list.add("payFeeGroup");
        list.add("discountFeeGroup");
        list.add("feeGroup");
        list.add("feeInfo1");
        list.add("feeInfo2");
        list.add("feeInfo3");
        list.add("feeLogMsg");
        return list;
    }

    public int getPayFee() {
        return payFee;
    }

    public int getDiscountFee() {
        return discountFee;
    }

    public int getFee() {
        return fee;
    }

    public String getParamVersion() {
        return paramVersion == null ? null : new String(paramVersion).trim();
    }

    public int getFeeSpecial() {
        return feeSpecial;
    }

    public String getTollIntervalIDs() {
        return tollIntervalIDs == null ? null : new String(tollIntervalIDs).trim();
    }

    public String getPayFeeGroup() {
        return payFeeGroup == null ? null : new String(payFeeGroup).trim();
    }

    public String getDiscountFeeGroup() {
        return discountFeeGroup == null ? null : new String(discountFeeGroup).trim();
    }

    public String getFeeGroup() {
        return feeGroup == null ? null : new String(feeGroup).trim();
    }

    public String getFeeInfo1() {
        return feeInfo1 == null ? null : new String(feeInfo1).trim();
    }

    public String getFeeInfo2() {
        return feeInfo2 == null ? null : new String(feeInfo2).trim();
    }

    public String getFeeInfo3() {
        return feeInfo3 == null ? null : new String(feeInfo3).trim();
    }

    public String getFeeLogMsg() {
        return feeLogMsg == null ? null : new String(feeLogMsg).trim();
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("payFee", getPayFee());
        map.put("discountFee", getDiscountFee());
        map.put("fee", getFee());
        map.put("paramVersion", getParamVersion());
        map.put("feeSpecial", getFeeSpecial());
        map.put("tollIntervalIDs", getTollIntervalIDs());
        map.put("payFeeGroup", getPayFeeGroup());
        map.put("discountFeeGroup", getDiscountFeeGroup());
        map.put("feeGroup", getFeeGroup());
        map.put("feeInfo1", getFeeInfo1());
        map.put("feeInfo2", getFeeInfo2());
        map.put("feeInfo3", getFeeInfo3());
        map.put("feeLogMsg", getFeeLogMsg());
        return map;
    }
}
