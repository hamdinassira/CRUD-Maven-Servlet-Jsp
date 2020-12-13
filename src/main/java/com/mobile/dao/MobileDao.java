package com.mobile.dao;

import java.util.List;

import com.mobile.domain.Mobile;

public interface MobileDao {
	void addMobile(Mobile mobile);

	void updateMobile(Mobile mobile);

	void deleteMobile(int id);

	Mobile findMobileById(int id);

	List<Mobile> findAllMobiles();
}
