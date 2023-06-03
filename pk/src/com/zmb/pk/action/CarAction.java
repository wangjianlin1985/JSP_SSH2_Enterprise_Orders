package com.zmb.pk.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.zmb.pk.model.Car;
import com.zmb.pk.service.CarService;
import com.zmb.pk.util.Constants;
import com.zmb.pk.util.Page;


public class CarAction {
	private Car bean;
	private Page page;//分页
	private CarService carService ;//spring 注入
	private static final String car="car_";
	private String pkSeq;//生成的主键好
	private int maxSeq;//每条记录的序列号
	private InputStream excelFile;
	
	Logger log=Logger.getLogger(CarAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	
	//导出到Excel
	public void  ExcelFile() throws Exception {   
		HSSFWorkbook workbook = null;
		try { 
			workbook =   new HSSFWorkbook();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		HSSFSheet sheet = workbook.createSheet("车辆信息");
		HSSFRow row = sheet.createRow(0);
		row.createCell((short) 0).setCellValue("车辆编号");
		row.createCell((short)1).setCellValue("车牌号");
		row.createCell((short)2).setCellValue("车架号");
		row.createCell((short)3).setCellValue("颜色");
		row.createCell((short)4).setCellValue("吨位");
		row.createCell((short)5).setCellValue("当前状态");
		row.createCell((short)6).setCellValue("购买日期");
		row.createCell((short)7).setCellValue("描述信息");
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		List<Car> list = carService.excelList();
		for (int i = 1; i <= list.size(); i++) {
			Car car = list.get(i - 1);
			row = sheet.createRow(i);
			row.createCell((short)0).setCellValue(car.getCarId());
			row.createCell((short)1).setCellValue(car.getCarCard());
			row.createCell((short)2).setCellValue(car.getCarVIN());
		    row.createCell((short)3).setCellValue(car.getColor());
		    row.createCell((short)4).setCellValue(car.getTonnage());
		    row.createCell((short)5).setCellValue(car.getCarState());
		    row.createCell((short)6).setCellValue(car.getBuyDate());
		    row.createCell((short)7).setCellValue(car.getRemarks());
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			
			workbook.write(baos);
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] aa = baos.toByteArray();
		excelFile = new ByteArrayInputStream(aa,0,aa.length); 
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//导出到Excel
	 public String  excel() throws Exception{
		 log.info("=======执行导出到Excel========");
		 ExcelFile() ;
		 return "excel";
	 }
	//进入到添加页面
	public String init() throws Exception {
		StringBuffer id= new StringBuffer("00000");
		 int i = carService.getMaxSequence()+1;
		   log.info("最大的序列号："+i);
		   String num=String.valueOf(i);
		   id.setLength(id.length()-num.length());
		   id.append(num);
		   StringBuffer seq= new StringBuffer("car_");
		    seq.append(id);
	    log.info("拼接后的序列号："+seq.toString());
	    
          this.setPkSeq(seq.toString());	  
          this.setMaxSeq(i);
		return "add";
	}
	//1)查询员工列表
	public String list() throws Exception{
		log.info("=======查询车辆列表========");
		

    	if(page==null) {
			page = new Page(1,Constants.PAGESIZE);
		}
			page.setRscount(carService.recordCount());
			page.setList(carService.list(bean, page.getCurrentpage(), page.getPagesize()));
			System.out.println(page.getRscount()+"============");
			bean=null;//防止表单回填
		return  "list";
	}
	
	//2)添加车辆，然后跳转到车辆列表页面
	public String addOrUpdate() throws Exception{
		log.info("=======添加车辆========");
		carService.addOrUpdate(bean);
		bean=null;//防止表单回填
		return "tolist";
	}
	
	//3)修改前，获取到的车辆信息
	public String beforeUpdate() throws Exception{
		log.info("=======修改前，获取到的车辆信息========");
		bean=carService.beforeUpdate(bean);
		return "update";
	}
	
	//4)修改车辆
	public String update() throws Exception{
		log.info("=======修改车辆========");
		
		return list();
	}
	//5)车辆明细
	public String detail() throws Exception{
		log.info("=======车辆明细========");
		bean=carService.detail(bean);
		return "detail";
	}
	
	//删除车辆
	public String delete() throws Exception{
		log.info("=======删除车辆========");
		carService.delete(bean);
		return "del";
	}
	//=================setter()/getter()===================


	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public Car getBean() {
		return bean;
	}

	public void setBean(Car bean) {
		this.bean = bean;
	}

	public static String getCar() {
		return car;
	}
	public String getPkSeq() {
		return pkSeq;
	}
	public void setPkSeq(String pkSeq) {
		this.pkSeq = pkSeq;
	}
	public int getMaxSeq() {
		return maxSeq;
	}
	public void setMaxSeq(int maxSeq) {
		this.maxSeq = maxSeq;
	}
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}

	

}
