package ro.devtester.sitemap.pojo;

public class Urlset {

    private String xmlns;
    private Url[] url;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public Url[] getUrl() {
        return url;
    }

    public void setUrl(Url[] url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPojo [xmlns = " + xmlns + ", url = " + url + "]";
    }
}