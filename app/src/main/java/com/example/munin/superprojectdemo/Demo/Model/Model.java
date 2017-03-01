package com.example.munin.superprojectdemo.Demo.Model;

import java.util.List;

/**
 * Created by Munin on 2017/3/1.
 */
public class Model {


    /**
     * return_code : 1
     * message : SUCCESS
     * result : [{"id":"4","title":"夺宝规则","link":"http://home.dodochong.com/image/0yuanduobaoguize.jpg","img":"http://onebuy.dodochong.com/statics/uploads/banner/20170227/25360073190470.jpg","color":"#df4f66"},{"id":"8","title":"秘籍攻略","link":"http://home.dodochong.com/image/mijigongluo.jpg","img":"http://onebuy.dodochong.com/statics/uploads/banner/20170227/73244376190489.jpg","color":""}]
     */

    private String return_code;
    private String message;
    private List<ResultBean> result;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "return_code='" + return_code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        /**
         * id : 4
         * title : 夺宝规则
         * link : http://home.dodochong.com/image/0yuanduobaoguize.jpg
         * img : http://onebuy.dodochong.com/statics/uploads/banner/20170227/25360073190470.jpg
         * color : #df4f66
         */

        private String id;
        private String title;
        private String link;
        private String img;
        private String color;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", link='" + link + '\'' +
                    ", img='" + img + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
