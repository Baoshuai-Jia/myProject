package jes.ioc.entity.rcpmis2;

public class rcpmis2RptFeedbackLog {
    private String orimsgno;

    private String orisendorgcode;

    private String orientrustdate;

    private String oripackno;

    private String allnum;

    private String allamt;

    private String succnum;

    private String succamt;

    private String failnum;

    private String failamt;

    private String addword;

    private String processCount;

    private String filename;

    private String sublistKey;

    public String getOrimsgno() {
        return orimsgno;
    }

    public void setOrimsgno(String orimsgno) {
        this.orimsgno = orimsgno == null ? null : orimsgno.trim();
    }

    public String getOrisendorgcode() {
        return orisendorgcode;
    }

    public void setOrisendorgcode(String orisendorgcode) {
        this.orisendorgcode = orisendorgcode == null ? null : orisendorgcode.trim();
    }

    public String getOrientrustdate() {
        return orientrustdate;
    }

    public void setOrientrustdate(String orientrustdate) {
        this.orientrustdate = orientrustdate == null ? null : orientrustdate.trim();
    }

    public String getOripackno() {
        return oripackno;
    }

    public void setOripackno(String oripackno) {
        this.oripackno = oripackno == null ? null : oripackno.trim();
    }

    public String getAllnum() {
        return allnum;
    }

    public void setAllnum(String allnum) {
        this.allnum = allnum == null ? null : allnum.trim();
    }

    public String getAllamt() {
        return allamt;
    }

    public void setAllamt(String allamt) {
        this.allamt = allamt == null ? null : allamt.trim();
    }

    public String getSuccnum() {
        return succnum;
    }

    public void setSuccnum(String succnum) {
        this.succnum = succnum == null ? null : succnum.trim();
    }

    public String getSuccamt() {
        return succamt;
    }

    public void setSuccamt(String succamt) {
        this.succamt = succamt == null ? null : succamt.trim();
    }

    public String getFailnum() {
        return failnum;
    }

    public void setFailnum(String failnum) {
        this.failnum = failnum == null ? null : failnum.trim();
    }

    public String getFailamt() {
        return failamt;
    }

    public void setFailamt(String failamt) {
        this.failamt = failamt == null ? null : failamt.trim();
    }

    public String getAddword() {
        return addword;
    }

    public void setAddword(String addword) {
        this.addword = addword == null ? null : addword.trim();
    }

    public String getProcessCount() {
        return processCount;
    }

    public void setProcessCount(String processCount) {
        this.processCount = processCount == null ? null : processCount.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getSublistKey() {
        return sublistKey;
    }

    public void setSublistKey(String sublistKey) {
        this.sublistKey = sublistKey == null ? null : sublistKey.trim();
    }
}