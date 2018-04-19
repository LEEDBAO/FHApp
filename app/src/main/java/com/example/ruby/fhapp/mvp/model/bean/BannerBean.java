package com.example.ruby.fhapp.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

public class BannerBean {

    /**
     * code : 0
     * msg : 成功获取轮播图
     * data : {"pc":{"1":{"id":1,"img_url":"/customise/images/pc_banner_1.jpg","href_url":""},"2":{"id":2,"img_url":"/customise/images/pc_banner_2.jpg","href_url":""},"3":{"id":3,"img_url":"/customise/images/pc_banner_3.jpg","href_url":""},"4":{"id":4,"img_url":"/customise/images/pc_banner_4.jpg","href_url":""},"5":{"id":5,"img_url":"/customise/images/pc_banner_5.jpg","href_url":""}},"mb":{"1":{"id":1,"img_url":"/customise/images/pc_banner_1.jpg","href_url":"/customise/wap/yd.html"},"2":{"id":2,"img_url":"/customise/images/pc_banner_2.jpg","href_url":""},"3":{"id":3,"img_url":"/customise/images/pc_banner_3.jpg","href_url":""},"4":{"id":4,"img_url":"/customise/images/pc_banner_4.jpg","href_url":""},"5":{"id":5,"img_url":"/customise/images/pc_banner_5.jpg","href_url":""}}}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pc : {"1":{"id":1,"img_url":"/customise/images/pc_banner_1.jpg","href_url":""},"2":{"id":2,"img_url":"/customise/images/pc_banner_2.jpg","href_url":""},"3":{"id":3,"img_url":"/customise/images/pc_banner_3.jpg","href_url":""},"4":{"id":4,"img_url":"/customise/images/pc_banner_4.jpg","href_url":""},"5":{"id":5,"img_url":"/customise/images/pc_banner_5.jpg","href_url":""}}
         * mb : {"1":{"id":1,"img_url":"/customise/images/pc_banner_1.jpg","href_url":"/customise/wap/yd.html"},"2":{"id":2,"img_url":"/customise/images/pc_banner_2.jpg","href_url":""},"3":{"id":3,"img_url":"/customise/images/pc_banner_3.jpg","href_url":""},"4":{"id":4,"img_url":"/customise/images/pc_banner_4.jpg","href_url":""},"5":{"id":5,"img_url":"/customise/images/pc_banner_5.jpg","href_url":""}}
         */

        private PcBean pc;
        private MbBean mb;

        public PcBean getPc() {
            return pc;
        }

        public void setPc(PcBean pc) {
            this.pc = pc;
        }

        public MbBean getMb() {
            return mb;
        }

        public void setMb(MbBean mb) {
            this.mb = mb;
        }

        public static class PcBean {
            /**
             * 1 : {"id":1,"img_url":"/customise/images/pc_banner_1.jpg","href_url":""}
             * 2 : {"id":2,"img_url":"/customise/images/pc_banner_2.jpg","href_url":""}
             * 3 : {"id":3,"img_url":"/customise/images/pc_banner_3.jpg","href_url":""}
             * 4 : {"id":4,"img_url":"/customise/images/pc_banner_4.jpg","href_url":""}
             * 5 : {"id":5,"img_url":"/customise/images/pc_banner_5.jpg","href_url":""}
             */

            @SerializedName("1")
            private _$1Bean _$1;
            @SerializedName("2")
            private _$2Bean _$2;
            @SerializedName("3")
            private _$3Bean _$3;
            @SerializedName("4")
            private _$4Bean _$4;
            @SerializedName("5")
            private _$5Bean _$5;

            public _$1Bean get_$1() {
                return _$1;
            }

            public void set_$1(_$1Bean _$1) {
                this._$1 = _$1;
            }

            public _$2Bean get_$2() {
                return _$2;
            }

            public void set_$2(_$2Bean _$2) {
                this._$2 = _$2;
            }

            public _$3Bean get_$3() {
                return _$3;
            }

            public void set_$3(_$3Bean _$3) {
                this._$3 = _$3;
            }

            public _$4Bean get_$4() {
                return _$4;
            }

            public void set_$4(_$4Bean _$4) {
                this._$4 = _$4;
            }

            public _$5Bean get_$5() {
                return _$5;
            }

            public void set_$5(_$5Bean _$5) {
                this._$5 = _$5;
            }

            public static class _$1Bean {
                /**
                 * id : 1
                 * img_url : /customise/images/pc_banner_1.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$2Bean {
                /**
                 * id : 2
                 * img_url : /customise/images/pc_banner_2.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$3Bean {
                /**
                 * id : 3
                 * img_url : /customise/images/pc_banner_3.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$4Bean {
                /**
                 * id : 4
                 * img_url : /customise/images/pc_banner_4.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$5Bean {
                /**
                 * id : 5
                 * img_url : /customise/images/pc_banner_5.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }
        }

        public static class MbBean {
            /**
             * 1 : {"id":1,"img_url":"/customise/images/pc_banner_1.jpg","href_url":"/customise/wap/yd.html"}
             * 2 : {"id":2,"img_url":"/customise/images/pc_banner_2.jpg","href_url":""}
             * 3 : {"id":3,"img_url":"/customise/images/pc_banner_3.jpg","href_url":""}
             * 4 : {"id":4,"img_url":"/customise/images/pc_banner_4.jpg","href_url":""}
             * 5 : {"id":5,"img_url":"/customise/images/pc_banner_5.jpg","href_url":""}
             */

            @SerializedName("1")
            private _$1BeanX _$1;
            @SerializedName("2")
            private _$2BeanX _$2;
            @SerializedName("3")
            private _$3BeanX _$3;
            @SerializedName("4")
            private _$4BeanX _$4;
            @SerializedName("5")
            private _$5BeanX _$5;

            public _$1BeanX get_$1() {
                return _$1;
            }

            public void set_$1(_$1BeanX _$1) {
                this._$1 = _$1;
            }

            public _$2BeanX get_$2() {
                return _$2;
            }

            public void set_$2(_$2BeanX _$2) {
                this._$2 = _$2;
            }

            public _$3BeanX get_$3() {
                return _$3;
            }

            public void set_$3(_$3BeanX _$3) {
                this._$3 = _$3;
            }

            public _$4BeanX get_$4() {
                return _$4;
            }

            public void set_$4(_$4BeanX _$4) {
                this._$4 = _$4;
            }

            public _$5BeanX get_$5() {
                return _$5;
            }

            public void set_$5(_$5BeanX _$5) {
                this._$5 = _$5;
            }

            public static class _$1BeanX {
                /**
                 * id : 1
                 * img_url : /customise/images/pc_banner_1.jpg
                 * href_url : /customise/wap/yd.html
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$2BeanX {
                /**
                 * id : 2
                 * img_url : /customise/images/pc_banner_2.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$3BeanX {
                /**
                 * id : 3
                 * img_url : /customise/images/pc_banner_3.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$4BeanX {
                /**
                 * id : 4
                 * img_url : /customise/images/pc_banner_4.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }

            public static class _$5BeanX {
                /**
                 * id : 5
                 * img_url : /customise/images/pc_banner_5.jpg
                 * href_url :
                 */

                private int id;
                private String img_url;
                private String href_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getHref_url() {
                    return href_url;
                }

                public void setHref_url(String href_url) {
                    this.href_url = href_url;
                }
            }
        }
    }
}
