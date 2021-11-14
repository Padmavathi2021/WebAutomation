package dataProviders;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import managers.FileReaderManager;
import testDataTypes.FaceBook;
import testDataTypes.WalletHub;

public class JsonDataReader {

	private final String userFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ "FaceBook.json";

	private List<FaceBook> userList;
	

	public JsonDataReader() {
		userList = getCustomerData();
	}

	private List<FaceBook> getCustomerData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		FaceBook[] users = null;
		try {
			 users = objectMapper.readValue(new FileReader(userFilePath), FaceBook[].class);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + userFilePath);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Arrays.asList(users);
	}

	
	public final FaceBook getUserName(String userName) {
		for (FaceBook user : userList) {
			if (user.userName.contains(userName))
				return user;
		}
		return null;
	}
}
