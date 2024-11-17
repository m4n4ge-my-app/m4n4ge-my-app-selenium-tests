package m4n4ge.selenium_autotests.utils;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import m4n4ge.selenium_autotests.UserData;

public class JsonUtil {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static UserData getTestData(String path) {
    	try(InputStream stream = DataLoader.getResource(path)){
            return mapper.readValue(stream, UserData.class);
        }catch (Exception e){
        	logger.error("unable to read test data {}", path, e);
        }
        return null;
    }
}
