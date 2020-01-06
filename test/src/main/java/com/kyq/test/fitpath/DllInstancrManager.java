package com.kyq.test.fitpath;


import com.sun.jna.Native;

public class DllInstancrManager {

    private static FeeCalDll feeCalDll = null;
    private static PathFittingDll pathFittingDll = null;

    public static void doPathFitInstance(String dllPath){
        pathFittingDll = Native.load(dllPath, PathFittingDll.class);
    }

    public static void doFeeCalInstance(String dllPath){
        feeCalDll = Native.load(dllPath, FeeCalDll.class);
    }

    public static FeeCalDll getFeeCalInstance(){
        return feeCalDll;
    }

    public static PathFittingDll getFitPathInstance(){
        return pathFittingDll;
    }
}
