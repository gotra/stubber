package oss.tgc.stubber.dao;

/**
 * Created by rajeevguru on 07/07/15.
 */
public final class JdbcQueries {



    public static final String addStub = "INSERT INTO STUBS (NAME, DESCRIPTION, URLPATH, HTTPMETHOD,HEADERS, RESPONSE) VALUES (?,?,?,?,?,?)";
    public static final String getStub = "SELECT * FROM STUBS WHERE id = ?";
    public static final String getStubList = "SELECT * FROM STUBS";
    public static final String deleteStub = "DELETE FROM STUBS WHERE id = ?";
    public static final String searcStub = "SELECT * from stubs where httpmethod = ? and urlpath = ?";

}
