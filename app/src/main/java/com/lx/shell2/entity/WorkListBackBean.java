package com.lx.shell2.entity;

import java.util.List;

/**
 * @auther lixu
 * Created by lixu on 2018/8/17.
 */
public class WorkListBackBean {

    private boolean result;
    private PageBean page;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {

        private int start;
        private int totalSize;
        private int pageSize;
        private int size;
        private int startOfNextPage;
        private int startOfPreviousPage;
        private int pageCount;
        private int curPageNum;
        private List<ResultListBean> resultList;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartOfNextPage() {
            return startOfNextPage;
        }

        public void setStartOfNextPage(int startOfNextPage) {
            this.startOfNextPage = startOfNextPage;
        }

        public int getStartOfPreviousPage() {
            return startOfPreviousPage;
        }

        public void setStartOfPreviousPage(int startOfPreviousPage) {
            this.startOfPreviousPage = startOfPreviousPage;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCurPageNum() {
            return curPageNum;
        }

        public void setCurPageNum(int curPageNum) {
            this.curPageNum = curPageNum;
        }

        public List<ResultListBean> getResultList() {
            return resultList;
        }

        public void setResultList(List<ResultListBean> resultList) {
            this.resultList = resultList;
        }

        public static class ResultListBean {
            /**
             * intId : -360219126
             * modifyBy : null
             * modifyDate : null
             * createBy : null
             * createDate : null
             * stateflag : 0
             * zhLabel : WX陈塘自然村
             * cityId : 2002
             * countyId : 1000157
             * townId : -360218008
             * roadId : -360218136
             * cellId : -360219126
             * communityType : null
             * roomCount : null
             * coverType : FTTH
             * fgMethod : 二级分光
             * raceInfo : 竞争对手未进驻
             * longtitude : 113.12331
             * latitude : 28.212326
             * jsStatus : 未建
             * qcStatus : null
             * roadName : 陈塘行政村
             * cellName : WX陈塘自然村
             */

            private int intId;
            private Object modifyBy;
            private Object modifyDate;
            private Object createBy;
            private Object createDate;
            private int stateflag;
            private String zhLabel;
            private int cityId;
            private int countyId;
            private int townId;
            private int roadId;
            private int cellId;
            private Object communityType;
            private Object roomCount;
            private String coverType;
            private String fgMethod;
            private String raceInfo;
            private String longtitude;
            private String latitude;
            private String jsStatus;
            private Object qcStatus;
            private String roadName;
            private String cellName;

            public int getIntId() {
                return intId;
            }

            public void setIntId(int intId) {
                this.intId = intId;
            }

            public Object getModifyBy() {
                return modifyBy;
            }

            public void setModifyBy(Object modifyBy) {
                this.modifyBy = modifyBy;
            }

            public Object getModifyDate() {
                return modifyDate;
            }

            public void setModifyDate(Object modifyDate) {
                this.modifyDate = modifyDate;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateDate() {
                return createDate;
            }

            public void setCreateDate(Object createDate) {
                this.createDate = createDate;
            }

            public int getStateflag() {
                return stateflag;
            }

            public void setStateflag(int stateflag) {
                this.stateflag = stateflag;
            }

            public String getZhLabel() {
                return zhLabel;
            }

            public void setZhLabel(String zhLabel) {
                this.zhLabel = zhLabel;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getCountyId() {
                return countyId;
            }

            public void setCountyId(int countyId) {
                this.countyId = countyId;
            }

            public int getTownId() {
                return townId;
            }

            public void setTownId(int townId) {
                this.townId = townId;
            }

            public int getRoadId() {
                return roadId;
            }

            public void setRoadId(int roadId) {
                this.roadId = roadId;
            }

            public int getCellId() {
                return cellId;
            }

            public void setCellId(int cellId) {
                this.cellId = cellId;
            }

            public Object getCommunityType() {
                return communityType;
            }

            public void setCommunityType(Object communityType) {
                this.communityType = communityType;
            }

            public Object getRoomCount() {
                return roomCount;
            }

            public void setRoomCount(Object roomCount) {
                this.roomCount = roomCount;
            }

            public String getCoverType() {
                return coverType;
            }

            public void setCoverType(String coverType) {
                this.coverType = coverType;
            }

            public String getFgMethod() {
                return fgMethod;
            }

            public void setFgMethod(String fgMethod) {
                this.fgMethod = fgMethod;
            }

            public String getRaceInfo() {
                return raceInfo;
            }

            public void setRaceInfo(String raceInfo) {
                this.raceInfo = raceInfo;
            }

            public String getLongtitude() {
                return longtitude;
            }

            public void setLongtitude(String longtitude) {
                this.longtitude = longtitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getJsStatus() {
                return jsStatus;
            }

            public void setJsStatus(String jsStatus) {
                this.jsStatus = jsStatus;
            }

            public Object getQcStatus() {
                return qcStatus;
            }

            public void setQcStatus(Object qcStatus) {
                this.qcStatus = qcStatus;
            }

            public String getRoadName() {
                return roadName;
            }

            public void setRoadName(String roadName) {
                this.roadName = roadName;
            }

            public String getCellName() {
                return cellName;
            }

            public void setCellName(String cellName) {
                this.cellName = cellName;
            }
        }
    }
}
