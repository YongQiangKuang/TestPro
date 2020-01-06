package com.kyq.test.fitpath;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * dll 路径拟合接口
 *
 * @author cnst
 */
public interface PathFittingDll extends Library {

    /**
     * 初始化dll
     *
     * @param feeDirStr 费率文件目录
     * @param logStr    日志输出目录
     * @return 是否成功
     */
    boolean Init(String feeDirStr, String logStr);

    /**
     * 路径拟合接口
     *
     * @param input  输入路径
     * @param result 返回结果
     * @return 是否成功
     */
    boolean GetThePath(String input, Pointer result);

    /**
     * 清除缓存
     *
     * @return 1成功 其他调用失败
     */
    int DeInit();

}
