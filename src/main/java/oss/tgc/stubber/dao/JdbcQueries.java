package oss.tgc.stubber.dao;

/**
 * Created by rajeevguru on 07/07/15.
 */
public final class JdbcQueries {



    public static final String addStub = "INSERT INTO STUBS (URLPATH,HTTPMETHOD,HEADERS, RESPONSE) VALUES (?,?,?,?)";
    public static final String getStub = "SELECT ID,URLPATH,HTTPMETHOD,HEADERS, RESPONSE FROM STUBS WHERE id = ?";
    public static final String getStubList = "SELECT * FROM STUBS";
    public static final String deleteStub = "DELETE FROM STUBS WHERE id = ?";
    public static final String searchStub = "SELECT ID,URLPATH,HTTPMETHOD,HEADERS, RESPONSE from stubs where " +
            "httpmethod = ? and urlpath = ?";
    public static final String updateStub = "UPDATE STUBS SET URLPATH = ? , HTTPMETHOD = ? , HEADERS = ? , " +
            "RESPONSE = ? WHERE id = ?";

}
