package ro.devtester.sitemap;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import ro.devtester.sitemap.pojo.Url;
import ro.devtester.sitemap.pojo.Urlset;

import static org.hamcrest.CoreMatchers.containsString;
import static io.restassured.RestAssured.get;

public class SitemapTest {

    private static final Logger logger = LoggerFactory.getLogger(SitemapTest.class);
    String SITEMAP_STRING_VALIDATION = "Copyright Endava 2022.";


    @Before
    public void setUp() {
        RestAssured.baseURI = "https://www.endava.com/";
        RestAssured.defaultParser = Parser.XML;
    }

    @Test
    public void testSitemapGet() {
        
        Url[] listUrls = get("sitemap.xml")
                .as(Urlset.class).getUrl();
        
        for (Url url : listUrls) {
            logger.info("Checking sitemap url: " + url.getLoc());
            get(url.getLoc())
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.OK.value()).body(containsString(SITEMAP_STRING_VALIDATION));
        }
    }
}
