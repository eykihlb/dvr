package com.mydao.dvr.entrty;

public class SiteInfo {
    private String id;

    private String netSiteNo;

    private String siteDesc;

    private String status;

    private String ip;

    private String sitetype;

    private String fullNetNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNetSiteNo() {
        return netSiteNo;
    }

    public void setNetSiteNo(String netSiteNo) {
        this.netSiteNo = netSiteNo == null ? null : netSiteNo.trim();
    }

    public String getSiteDesc() {
        return siteDesc;
    }

    public void setSiteDesc(String siteDesc) {
        this.siteDesc = siteDesc == null ? null : siteDesc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getSitetype() {
        return sitetype;
    }

    public void setSitetype(String sitetype) {
        this.sitetype = sitetype == null ? null : sitetype.trim();
    }

    public String getFullNetNo() {
        return fullNetNo;
    }

    public void setFullNetNo(String fullNetNo) {
        this.fullNetNo = fullNetNo == null ? null : fullNetNo.trim();
    }
}