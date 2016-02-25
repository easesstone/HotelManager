package com.sydney.hotelmanager.dao;

import java.sql.SQLException;
import java.util.List;

import com.sydney.hotelmanager.entity.BusinessDetails;

public interface MoneyDao {
	public int currentDaysMoney()throws SQLException;//当天营业总金额
	public List<BusinessDetails> currentDaysDetails()throws SQLException;//
	public int currentMonthsMoney()throws SQLException;
	public List<BusinessDetails> currentMonthsDetails()throws SQLException;
	public int currentYearsMoney()throws SQLException;
	public List<BusinessDetails> currentYearsDetails()throws SQLException;
}
