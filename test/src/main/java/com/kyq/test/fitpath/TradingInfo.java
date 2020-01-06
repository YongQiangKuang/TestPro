package com.kyq.test.fitpath;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class TradingInfo extends Structure {

    /**
     *
     * 1.	char curTollGantry[20]; //当前收费门架编码，当初始化函数中的当前门架编码为null时，应支持全省所有门架的费用查询（含代收）；初始化函数中的当前门架编码不为null时，该字段与初始化函数中的当前门架编码相等。
     * 2.	char curPassTime[20];   //当前收费门架经过时间，如：“2019-08-17T15:32:58“
     * 3.	int laneStatus; //卡片或标签上获得的出入口车道状态，0x00-保留，0x 01-封闭E/M混合入口，0x02-封闭E/M混合出口，0x03-封闭ETC入口，0x04-封闭ETC出口，0x05-E/M混合开放式，0x06-ETC开放式，0x07～0F自定义，0x10-自助发卡，0x11～FF保留给未来使用，十六进制编码。
     * 4.	char enTollStationHex[9];    //卡片或标签上获得的入口站Hex编码，如：“1101ABCD”
     * 5.	char enPassTime[20];              //入口时间
     * 6.	char lastGantryHex[7];//卡片或标签上获得的上一收费门架的HEX编码，如“1101AB”。（同一个收费单元的前后两个门架的HEX编码是相同的，所以实际上HEX编码与收费单元一一对应。）
     * 7.	char lastPasstime[20];//卡片或标签上获得的经过上一收费门架的时间
     * 8.	char issuerId[7];       //发行服务机构编码，如四川工行：“510102”
     * 9.	char cardNetwork[5];        //卡网络编号：如“4401”
     * 10.	int vehicleUserType;        //车辆用户类型（CPU卡0015文件或单片式标签EF01） 0-普通车；6-公务车；8-军警车；10-紧急车；--12-免费；14-车队；0～20内其他：自定义；应急救援车辆定义为:OxlA; 货车列车或半挂汽车列车定义为:OxlB。
     * 11.	int axleCount;      //车辆轴数
     *      int enAxleCount;    //入口车辆轴数，入口写入的车辆轴数。CPC卡从DF01目录EF01获取；单片式标签从EF02获取，双片式标签从CPU卡0019文件获取。
     * 12.	int tagType;            //0-单片式标签 1-双片式ETC卡 2-CPC卡
     * 13.	int cardType;       //卡片类型，见CPU卡0015文件第9字节。非双片式时填0。如：储值卡为22。
     * 14.	int cardVer;    //卡片版本号，见CPU卡0015文件第10字节。非双片式时填0。如：0x04。
     * 15.	char obuSn[17];     //OBU ID号：4401123456789012
     * 16.	char cpuCardId[21];    // 双片式ETC卡号或CPC卡ID号，如CPU卡：44011234567890123456
     * 17.	char plateHex[25]; //车牌号，全牌照信息，采用字符型存储，汉字采用GB2312码，如：“京“编码为"BEA9"; 牌照信息不足20字节，后补OxOO。
     * 18.	unsigned short plateColor; //车牌颜色：高字节：0x00 低字节：0x00 –蓝色；0x01–黄色；0x02 –黑色；  0x03 –白色；0x04-渐变绿色；0x05-黄绿双拼色； 0x06-蓝白渐变；0x07～0xFF保留。如0x0001表示黄色。
     * 19.	int vehicleType;    //车型，见注1
     *      int enVehicleType;  //入口信息中的车型，双片式标签从0019文件获得，单片式标签从EF02文件获得，CPC从DF01目录下的EF01文件获得。
     * 20.	int vehicleClass;   //车种 0-普通车；6-公务车；8-军警车；10-紧急车；12-免费；14-车队；0~20内其他：自定义应用； 21-绿通车；22-联合收割机 23-抢险救灾24-集装箱车 25-大件运输 26-应急保障车 27-货车列车或半挂汽车列车；28~255保留。
     * 21.	int feeSumLocal;    //CPC卡本省费用累计，单位：分
     * 22.	int vehicleLength;  //车长，单位dm，双片式从0019文件获得，单片式标签从EF02文件获得，CPC卡填0。
     * 23.	int vehicleWidth;   //车宽，单位dm，双片式从0019文件获得，单片式标签从EF02文件获得，CPC卡填0。
     * 24.	int vehicleHight;   //车高，单位dm，双片式从0019文件获得，单片式标签从EF02文件获得，CPC卡填0。
     * 25.	int vehicleWeightLimits;    //车辆限定载重/座位数。由电子标签EFO1中相应字段获得，载重时单位为kg。CPC卡填0。
     * 26.	int totalWeight;//货车总重，单位：kg。无总重信息时（如客车）填0。  }
     *
     * */

    public String curTollGantry;
    public String curPassTime;
    public Integer laneStatus;
    public String enTollStationHex;
    public String enPassTime;
    public String lastGantryHex;
    public String lastPasstime;
    public String issuerId;
    public String cardNetwork;
    public Integer vehicleUserType;
    public Integer axleCount;
    public Integer enAxleCount;
    public Integer tagType;
    public Integer cardType;
    public Integer cardVer;
    public String obuSn;
    public String cpuCardId;
    public String plateHex;
    public String plateColor;
    public Integer vehicleType;
    public Integer enVehicleType;
    public Integer vehicleClass;
    public Integer feeSumLocal;
    public Integer vehicleWeightLimits;
    public Integer totalWeight;
    public String vehicleStatusFlag;

    @Override
    protected List getFieldOrder() {
        List field = new ArrayList();
        field.add("curTollGantry");
        field.add("curPassTime");
        field.add("laneStatus");
        field.add("enTollStationHex");
        field.add("enPassTime");
        field.add("lastGantryHex");
        field.add("lastPasstime");
        field.add("issuerId");
        field.add("cardNetwork");
        field.add("vehicleUserType");
        field.add("axleCount");

        field.add("enAxleCount");
        field.add("tagType");
        field.add("cardType");
        field.add("cardVer");
        field.add("obuSn");
        field.add("cpuCardId");
        field.add("plateHex");
        field.add("plateColor");
        field.add("vehicleType");

        field.add("enVehicleType");
        field.add("vehicleClass");
        field.add("feeSumLocal");
        field.add("vehicleWeightLimits");
        field.add("totalWeight");
        field.add("vehicleStatusFlag");
        return field;
    }

    public String getCurTollGantry() {
        return curTollGantry;
    }

    public void setCurTollGantry(String curTollGantry) {
        this.curTollGantry = curTollGantry;
    }

    public String getCurPassTime() {
        return curPassTime;
    }

    public void setCurPassTime(String curPassTime) {
        this.curPassTime = curPassTime;
    }

    public Integer getLaneStatus() {
        return laneStatus;
    }

    public void setLaneStatus(Integer laneStatus) {
        this.laneStatus = laneStatus;
    }

    public String getEnTollStationHex() {
        return enTollStationHex;
    }

    public void setEnTollStationHex(String enTollStationHex) {
        this.enTollStationHex = enTollStationHex;
    }

    public String getEnPassTime() {
        return enPassTime;
    }

    public void setEnPassTime(String enPassTime) {
        this.enPassTime = enPassTime;
    }

    public String getLastGantryHex() {
        return lastGantryHex;
    }

    public void setLastGantryHex(String lastGantryHex) {
        this.lastGantryHex = lastGantryHex;
    }

    public String getLastPasstime() {
        return lastPasstime;
    }

    public void setLastPasstime(String lastPasstime) {
        this.lastPasstime = lastPasstime;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(String cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public Integer getVehicleUserType() {
        return vehicleUserType;
    }

    public void setVehicleUserType(Integer vehicleUserType) {
        this.vehicleUserType = vehicleUserType;
    }

    public Integer getAxleCount() {
        return axleCount;
    }

    public void setAxleCount(Integer axleCount) {
        this.axleCount = axleCount;
    }

    public Integer getTagType() {
        return tagType;
    }

    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getCardVer() {
        return cardVer;
    }

    public void setCardVer(Integer cardVer) {
        this.cardVer = cardVer;
    }

    public String getObuSn() {
        return obuSn;
    }

    public void setObuSn(String obuSn) {
        this.obuSn = obuSn;
    }

    public String getCpuCardId() {
        return cpuCardId;
    }

    public void setCpuCardId(String cpuCardId) {
        this.cpuCardId = cpuCardId;
    }

    public String getPlateHex() {
        return plateHex;
    }

    public void setPlateHex(String plateHex) {
        this.plateHex = plateHex;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(Integer vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public Integer getFeeSumLocal() {
        return feeSumLocal;
    }

    public void setFeeSumLocal(Integer feeSumLocal) {
        this.feeSumLocal = feeSumLocal;
    }

    public Integer getVehicleWeightLimits() {
        return vehicleWeightLimits;
    }

    public void setVehicleWeightLimits(Integer vehicleWeightLimits) {
        this.vehicleWeightLimits = vehicleWeightLimits;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getEnAxleCount() {
        return enAxleCount;
    }

    public void setEnAxleCount(Integer enAxleCount) {
        this.enAxleCount = enAxleCount;
    }

    public Integer getEnVehicleType() {
        return enVehicleType;
    }

    public void setEnVehicleType(Integer enVehicleType) {
        this.enVehicleType = enVehicleType;
    }


    public String getVehicleStatusFlag() {
        return vehicleStatusFlag;
    }

    public void setVehicleStatusFlag(String vehicleStatusFlag) {
        this.vehicleStatusFlag = vehicleStatusFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.append(curTollGantry == null ? "" : curTollGantry).append("#")
                .append(curPassTime == null ? "" : curPassTime).append("#")
                .append(laneStatus == null ? "" : laneStatus).append("#")
                .append(enTollStationHex == null ? "" : enTollStationHex).append("#")
                .append(enPassTime == null ? "" : enPassTime).append("#")
                .append(lastGantryHex == null ? "" : lastGantryHex).append("#")
                .append(lastPasstime == null ? "" : lastPasstime).append("#")
                .append(issuerId == null ? "" : issuerId).append("#")
                .append(cardNetwork == null ? "" : cardNetwork).append("#")
                .append(vehicleUserType == null ? "" : vehicleUserType).append("#")
                .append(axleCount == null ? "" : axleCount).append("#")
                .append(enAxleCount == null ? "" : enAxleCount).append("#")
                .append(tagType == null ? "" : tagType).append("#")
                .append(cardType == null ? "" : cardType).append("#")
                .append(cardVer == null ? "" : cardVer).append("#")
                .append(obuSn == null ? "" : obuSn).append("#")
                .append(cpuCardId == null ? "" : cpuCardId).append("#")
                .append(plateHex == null ? "" : plateHex).append("#")
                .append(plateColor == null ? "" : plateColor).append("#")
                .append(vehicleType == null ? "" : vehicleType).append("#")
                .append(enVehicleType == null ? "" : enVehicleType).append("#")
                .append(vehicleClass == null ? "" : vehicleClass).append("#")
                .append(feeSumLocal == null ? "" : feeSumLocal).append("#")
                .append(vehicleWeightLimits == null ? "" : vehicleWeightLimits).append("#")
                .append(totalWeight == null ? "" : totalWeight).append("#")
                .append(vehicleStatusFlag == null ? "" : vehicleStatusFlag).toString();
    }
}
