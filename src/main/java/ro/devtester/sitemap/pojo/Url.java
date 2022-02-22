package ro.devtester.sitemap.pojo;

public class Url {

    private String loc;
    private String priority;
    private String lastmod;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getLastmod() {
        return lastmod;
    }

    public void setLastmod(String lastmod) {
        this.lastmod = lastmod;
    }

    @Override
    public String toString() {
        return "ClassPojo [loc = " + loc + ", priority = " + priority + ", lastmod = " + lastmod + "]";
    }
}
