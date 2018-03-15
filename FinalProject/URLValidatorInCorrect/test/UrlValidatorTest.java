
import junit.framework.TestCase;


public class UrlValidatorTest extends TestCase {

   public UrlValidatorTest(String testName) {
       super(testName);
   }

   public void testManualTest()
   {
      //Varible that holds the test result
      boolean retResult;

      //You can use this function to implement your manual testing
      //Create a UrlValidator object 
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      //Manual tests, by using console screen to print the return value of "isValid"
      retResult = urlVal.isValid("http://www.google.com:27951");
      System.out.println(retResult);

      retResult = urlVal.isValid("http://www.google.com");
      System.out.println(retResult);

      retResult = urlVal.isValid("http://192.168.1.168");
      System.out.println(retResult);

   }


    //Minimal URL. Valid scheme and authority. Use "http://" scheme.
    public void testPartition1()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Minimal URL. Valid scheme and authority. Use "ftp://" scheme.
    public void testPartition2()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "ftp://www.google.com";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Minimal URL. Valid scheme and authority. Use "h3t://" scheme.
    public void testPartition3()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "h3t://www.google.com";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Valid scheme, valid authority, valid port
    public void testPartition4()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com:80";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Valid scheme, valid authority, valid path
    public void testPartition5()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com/path";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Valid scheme, valid authority, valid query
    public void testPartition6()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com?action=view";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //All parts in URL are present and valid.
    public void testPartition7()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com:80/test1?action=view";
        boolean expected = true;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Invalid scheme.
    public void testPartition8()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "://www.google.com:80/test1?action=view";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Invalid authority.
    public void testPartition9()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://aaa:80/test1?action=view";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Invalid port.
    public void testPartition10()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com:-1/test1?action=view";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Invalid path.
    public void testPartition11()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com:80/..?action=view";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Two URL parts invalid.
    public void testPartition12(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://aaa:80/..";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Three URL parts invalid.
    public void testPartition13(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "://aaa:80/..";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }
    
    //Four URL parts invalid.
    public void testPartition14(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "://aaa:-1/..";
        boolean expected = false;
        boolean result = urlVal.isValid(url);
        System.out.println("url = " + url + ", expected = " + expected + ", result = " + result);
        assertEquals(url, expected, result);
    }

   public void testIsValid()
   {
       UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       int count = 0;
       String url;
       boolean expected, result;

       for (ResultPair scheme: testUrlParts[0]) {
           for (ResultPair authority: testUrlParts[1]) {
               for (ResultPair port: testUrlParts[2]) {
                   for (ResultPair path: testUrlParts[3]) {
                       for (ResultPair query: testUrlParts[4]) {
                           count++;

                           url = String.join("", scheme.item, authority.item, port.item, path.item, query.item);
                           result = validator.isValid(url);
                           expected = scheme.valid & authority.valid & port.valid & path.valid & query.valid;

                           if (expected != result)
                               System.out.println("FAILED: testIsValid(): " + url);

                           assertEquals(url, expected, result);
                       }
                   }
               }
           }
       }

       System.out.println("PASSED: testIsValid()");

   }

   //-------------------- Test data for creating a composite URL
   ResultPair[] testUrlScheme = { new ResultPair("http://", true),
                                  new ResultPair("ftp://", true),
                                  new ResultPair("h3t://", true),
                                  new ResultPair("3ht://", false),
                                  new ResultPair("http:/", false),
                                  new ResultPair("http:", false),
                                  new ResultPair("http/", false),
                                  new ResultPair("://", false) };

   ResultPair[] testUrlAuthority = { new ResultPair("www.google.com", true),
                                     new ResultPair("go.com", true),
                                     new ResultPair("go.au", true),
                                     new ResultPair("0.0.0.0", true),
                                     new ResultPair("255.255.255.255", true),
                                     new ResultPair("256.256.256.256", false),
                                     new ResultPair("255.com", true),
                                     new ResultPair("1.2.3.4.5", false),
                                     new ResultPair("1.2.3.4.", false),
                                     new ResultPair("1.2.3", false),
                                     new ResultPair(".1.2.3.4", false),
                                     new ResultPair("go.a", false),
                                     new ResultPair("go.a1a", false),
                                     new ResultPair("go.1aa", false),
                                     new ResultPair("aaa.", false),
                                     new ResultPair(".aaa", false),
                                     new ResultPair("aaa", false),
                                     new ResultPair("", false) };

   ResultPair[] testUrlPort = { new ResultPair(":80", true),
                                new ResultPair(":65535", true),
                                new ResultPair(":0", true),
                                new ResultPair("", true),
                                new ResultPair(":-1", false),
                                new ResultPair(":65636",false),
                                new ResultPair(":65a", false) };

   ResultPair[] testPath = { new ResultPair("/test1", true),
                             new ResultPair("/t123", true),
                             new ResultPair("/$23", true),
                             new ResultPair("/..", false),
                             new ResultPair("/../", false),
                             new ResultPair("/test1/", true),
                             new ResultPair("", true),
                             new ResultPair("/test1/file", true),
                             new ResultPair("/..//file", false),
                             new ResultPair("/test1//file", false) };

   ResultPair[] testUrlQuery = { new ResultPair("?action=view", true),
                                 new ResultPair("?action=edit&mode=up", true),
                                 new ResultPair("", true) };

   ResultPair[][] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};

}
