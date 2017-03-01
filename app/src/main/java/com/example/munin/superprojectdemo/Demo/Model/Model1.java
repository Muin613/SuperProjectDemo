package com.example.munin.superprojectdemo.Demo.Model;

/**
 * Created by Munin on 2017/3/1.
 */
public class Model1 {

    /**
     * return_code : 1
     * message : success
     * result : {"info":{"sex":"2","age":"2016","email":"2016","vocation":"103330eee","hobby":"2016"}}
     */

    private String return_code;
    private String message;
    private ResultBean result;

    @Override
    public String toString() {
        return "Model1{" +
                "return_code='" + return_code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * info : {"sex":"2","age":"2016","email":"2016","vocation":"103330eee","hobby":"2016"}
         */

        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * sex : 2
             * age : 2016
             * email : 2016
             * vocation : 103330eee
             * hobby : 2016
             */

            private String sex;
            private String age;
            private String email;
            private String vocation;
            private String hobby;

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getVocation() {
                return vocation;
            }

            public void setVocation(String vocation) {
                this.vocation = vocation;
            }

            public String getHobby() {
                return hobby;
            }

            public void setHobby(String hobby) {
                this.hobby = hobby;
            }

            @Override
            public String toString() {
                return "InfoBean{" +
                        "sex='" + sex + '\'' +
                        ", age='" + age + '\'' +
                        ", email='" + email + '\'' +
                        ", vocation='" + vocation + '\'' +
                        ", hobby='" + hobby + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "info=" + info +
                    '}';
        }
    }
}
