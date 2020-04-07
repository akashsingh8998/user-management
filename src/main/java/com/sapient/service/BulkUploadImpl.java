package com.sapient.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sapient.model.Batch;
import com.sapient.model.Category;
import com.sapient.model.Role;
import com.sapient.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Service
public class BulkUploadImpl {

	
	@Autowired
	UserImpl userImpl;

	public ArrayList bulkUpload(MultipartFile uploadFile) 
    {
		ArrayList<BulkUploadObject> list = new ArrayList<>();
        try
        {
            InputStream file = uploadFile.getInputStream();
            //Create Workbook instance holding reference to .xlsx file
            
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int j=0;
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                User userr = new User();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int i=0;
                BulkUploadObject bulkUploadObject = new BulkUploadObject();
                for(int cn=0;cn<15;cn++)
                {
                	if(j!=0)
                	{
                		Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
                		final int type = cell.getCellType();
                      
                      if(i==1) {
                      	
                      	if(type == Cell.CELL_TYPE_BLANK)
                      	{
                      		bulkUploadObject.setMessage("One or more mandatory fields are empty.");
                      		ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
                      		errorfieldList.add("firstName");
                      		bulkUploadObject.setErrorFields(errorfieldList);
                      		userr.setFirstName(null);
                      	}
                      	else {
                      		String name = cell.getStringCellValue();
                      		userr.setFirstName(name);
                      	}
                      }
                      else if(i==2) {
                      	
                      	if(type == Cell.CELL_TYPE_BLANK)
                      	{
                      		bulkUploadObject.setMessage("One or more mandatory fields are empty.");
                      		ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
                      		errorfieldList.add("lastName");
                      		bulkUploadObject.setErrorFields(errorfieldList);
                      		userr.setLastName(null);
                      	}
                      	else {
                      		String lastName = cell.getStringCellValue();
                      		userr.setLastName(lastName);
                      	}
                      }
                      else if(i==3) {
                    	 
            	  		if(type == Cell.CELL_TYPE_BLANK)
            	  		{
            	  			bulkUploadObject.setMessage("One or more mandatory fields are empty.");
                      		ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
                      		errorfieldList.add("mobile");
                      		bulkUploadObject.setErrorFields(errorfieldList);
            	  			userr.setMobile(null);
            	  		}
            	  		else {
            	  			userr.setMobile((long)cell.getNumericCellValue());
            	  		}
                        	
                      		
                      	
                      }
                      else if(i==4) {
                    	  if(type == Cell.CELL_TYPE_BLANK)
	              	  		{
	              	  			bulkUploadObject.setMessage("One or more mandatory fields are empty.");
	                        	ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
	                        	errorfieldList.add("email");
	                        	bulkUploadObject.setErrorFields(errorfieldList);
	              	  			userr.setEmail(null);
	              	  		}
	              	  		else {
	              	  			userr.setEmail(cell.getStringCellValue());
	              	  		}
	                      	
                      }
//                      else if(i==5) {
//                    	  if(type == Cell.CELL_TYPE_BLANK)
//	              	  		{
//	              	  			bulkUploadObject.setMessage("One or more mandatory fields are empty.");
//	                        	ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
//	                        	errorfieldList.add("password");
//	                        	bulkUploadObject.setErrorFields(errorfieldList);
//	              	  			userr.setPassword(null);
//	              	  		}
//	              	  		else {
//	              	  		userr.setPassword(cell.getStringCellValue());
//	              	  		}
//                      	
//                      }
                      else if(i==5) {
                      	userr.setBirthdate(new Date());
                      }
                      else if(i==6) {
                      	userr.setJobLocation(cell.getStringCellValue());
                      }
//                      else if(i==7) {
//                    	  if(type == Cell.CELL_TYPE_BLANK)
//	              	  		{
//	              	  			bulkUploadObject.setMessage("One or more mandatory fields are empty.");
//	                        	ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
//	                        	errorfieldList.add("role");
//	                        	bulkUploadObject.setErrorFields(errorfieldList);
//	              	  			userr.setRole(null);
//	              	  		}
//	              	  		else {
//		              	  		Role role = new Role();///role
//		                      	role.setRoleIden((int)cell.getNumericCellValue());
//		                      	userr.setRole(role);
//	              	  		}
//                      	
//                      }
                      else if(i==7) {
                      	Batch batch = new Batch();
                      	batch.setBatchId((int)cell.getNumericCellValue());
                      	userr.setBatch(batch);
                      }
                      else if(i==8) {
                      	Category category = new Category();
                      	category.setCategoryId((int)cell.getNumericCellValue());
                      	userr.setCategory(category);
                      }
//                      else if(i==9) {
//                    	  if(type == Cell.CELL_TYPE_BLANK)
//	              	  		{
//	              	  			bulkUploadObject.setMessage("One or more mandatory fields are empty.");
//	                        	ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
//	                        	errorfieldList.add("institutionName");
//	                        	bulkUploadObject.setErrorFields(errorfieldList);
//	              	  			userr.setInstitutionName(null);
//	              	  		}
//	              	  		else {
//	              	  		userr.setInstitutionName(cell.getStringCellValue());
//	              	  		}
//                      	
//                      }
//                      else if(i==12) {
//                    	  if(type == Cell.CELL_TYPE_BLANK)
//	              	  		{
//	              	  			bulkUploadObject.setMessage("One or more mandatory fields are empty.");
//	                        	ArrayList<String> errorfieldList = bulkUploadObject.getErrorFields();
//	                        	errorfieldList.add("instituteAddress");
//	                        	bulkUploadObject.setErrorFields(errorfieldList);
//	              	  			userr.setInstitutionAddress(null);
//	              	  		}
//	              	  		else {
//	              	  			userr.setInstitutionAddress(cell.getStringCellValue());
//	              	  		}
//                      	
//                      }
                      else if(i==9) {
                      	userr.setResidentialAddress(cell.getStringCellValue());
                      }
                      else if(i==10) {
                      	userr.setActiveStatus(Boolean.parseBoolean(cell.getStringCellValue()));
                      }
                      i++;
                	}
                }
                if(j>0) {
                	
                	if(bulkUploadObject.getErrorFields().isEmpty() && userImpl.isUserValid(userr.getEmail()))
                	{
                		bulkUploadObject.setUser(userr);
                		bulkUploadObject.setValid(true);
                	}
                	else {
                		bulkUploadObject.setUser(userr);
                		bulkUploadObject.setValid(false);
                	}
                	list.add(bulkUploadObject);
                }
                j++;
                
            }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }

}
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class BulkUploadObject{
	private User user;
	private boolean isValid;
	private String message;
	private ArrayList<String> errorFields = new ArrayList<>();
}