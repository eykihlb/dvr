package com.mydao.dvr.entrty;

public class DataSnap extends BaseEntity{
    private String id;

    private String cameraIp;

    private String picUrl;

    private String createTime;

    private String plateNo;

    private String plateColorCode;

    private String carId;
    private String state;
    private String dvrName;
    private String dvrDesc;
    private String fileName;
    private String filePath;
    private String fileSize;
    private String extensionName;
    private String netSiteNo;
    private String siteDesc;
    private String sitetype;
    private String fullNetNo;
    private String start;
    private String end;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDvrName() {
        return dvrName;
    }

    public void setDvrName(String dvrName) {
        this.dvrName = dvrName;
    }

    public String getDvrDesc() {
        return dvrDesc;
    }

    public void setDvrDesc(String dvrDesc) {
        this.dvrDesc = dvrDesc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public String getNetSiteNo() {
        return netSiteNo;
    }

    public void setNetSiteNo(String netSiteNo) {
        this.netSiteNo = netSiteNo;
    }

    public String getSiteDesc() {
        return siteDesc;
    }

    public void setSiteDesc(String siteDesc) {
        this.siteDesc = siteDesc;
    }

    public String getSitetype() {
        return sitetype;
    }

    public void setSitetype(String sitetype) {
        this.sitetype = sitetype;
    }

    public String getFullNetNo() {
        return fullNetNo;
    }

    public void setFullNetNo(String fullNetNo) {
        this.fullNetNo = fullNetNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCameraId() {
        return cameraIp;
    }

    public void setCameraId(String cameraIp) {
        this.cameraIp = cameraIp == null ? null : cameraIp.trim();
    }

    public String getPicId() {
        return picUrl;
    }

    public void setPicId(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getPlateColorCode() {
        return plateColorCode;
    }

    public void setPlateColorCode(String plateColorCode) {
        this.plateColorCode = plateColorCode == null ? null : plateColorCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}