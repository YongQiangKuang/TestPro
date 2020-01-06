package com.kyq.test.fitpath;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * dll 路径拟合接口
 *FeeCalDll
 * @author cnst
 */

public interface FeeCalDll extends Library {

    /**
     * 初始化dll
     *
     * @param currEntry 费率文件目录
     * @param libPath    参数目录
     * @return：NO_ERROR(0)，正常；
     * @return：<0 错误见函数返回值定义
     */
    int init(String currEntry, String libPath);


    /**
     * 清除缓存
     *
     * @return：NO_ERROR(0)，正常；
     * @return：<0 错误见函数返回值定义。
     */
    int deInit();

    /**
     * 获取计费模块版本
     *
     * @return：NO_ERROR(0)，正常；
     * @return：<0 错误见函数返回值定义。
     */
    int getLibVersion(byte[] version, Integer verLen, byte[] dataVersion, Integer dataVersionLen);

    /**
     * 获取参数版本
     *
     * @return：NO_ERROR(0)，正常；
     * @return：<0 错误见函数返回值定义。
     */
    int getFeeDataVersion(byte[] version, Integer verLen);


    /**
     * 按门架查询费用
     *
     * @return 1成功 其他调用失败
     */
    int getFee(TradingInfo tradingInfo, FeeInfo feeInfo);

    /**
     * 按门架查询费用，返回指针
     *
     * @return 1成功 其他调用失败
     */
    int getFeeString(String tradingInfo, Pointer pointer);

    /**
     * 查询多个收费单元的费用
     *
     * @return 1成功 其他调用失败
     */
    int getFees(TradingInfo tradingInfo, FeeInfo feeInfo);

    /**
     * 查询多个收费单元的费用
     *
     * @return 1成功 其他调用失败
     */
    int getFeesByGantry(TradingInfo tradingInfo, FeeInfo feeInfo);
    /**
     * 查询多个收费单元的费用，返回指针
     *
     * @return 1成功 其他调用失败
     */
    int getFeesString(String tradingInfo, Pointer pointer);

    /**
     * 查询多个收费单元的费用，返回指针
     *
     * @return 1成功 其他调用失败
     */
    int getFeesStringByGantry(String tradingInfo, Pointer pointer);

    /**
     * 先调用路径拟合，再计算费用
     *
     * @return 1成功 其他调用失败
     */
    int getFeeWithPathFit(TradingInfo tradingInfo, FeeInfo feeInfo);

    /**
     * 先调用路径拟合，再计算费用，返回指针
     *
     * @return 1成功 其他调用失败
     */
    int getFeeWithPathFitString(String tradingInfo, Pointer pointer);
}
