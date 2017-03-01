package com.example.munin.superprojectdemo.Demo.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Munin on 2017/3/1.
 */
public class Model2 {


    /**
     * return_code : 1
     * message : SUCCESS
     * result : {"appid":"wxbc373ea7200ca862","noncestr":"7pLRRxk0VN6YQKCObOJ625IdU97PrAZZ","package":"Sign=WXPay","partnerid":"1415885702","prepayid":"wx20161130162145407f4479730168392972","timestamp":1480494105,"sign":"875827F61E86047940B7B5D82CDF285A","order_num":"androidwx-20161130162144-872"}
     */

    private int return_code;
    private String message;
    private ResultBean result;

    @Override
    public String toString() {
        return "Model2{" +
                "return_code=" + return_code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public int getReturn_code() {
        return return_code;
    }

    public void setReturn_code(int return_code) {
        this.return_code = return_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * appid : wxbc373ea7200ca862
         * noncestr : 7pLRRxk0VN6YQKCObOJ625IdU97PrAZZ
         * package : Sign=WXPay
         * partnerid : 1415885702
         * prepayid : wx20161130162145407f4479730168392972
         * timestamp : 1480494105
         * sign : 875827F61E86047940B7B5D82CDF285A
         * order_num : androidwx-20161130162144-872
         */

        private String appid;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private int timestamp;
        private String sign;
        private String order_num;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "appid='" + appid + '\'' +
                    ", noncestr='" + noncestr + '\'' +
                    ", packageX='" + packageX + '\'' +
                    ", partnerid='" + partnerid + '\'' +
                    ", prepayid='" + prepayid + '\'' +
                    ", timestamp=" + timestamp +
                    ", sign='" + sign + '\'' +
                    ", order_num='" + order_num + '\'' +
                    '}';
        }
    }
}
