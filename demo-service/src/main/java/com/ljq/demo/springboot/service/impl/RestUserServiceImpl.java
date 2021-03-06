package com.ljq.demo.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.ljq.demo.springboot.baseweb.api.ApiResult;
import com.ljq.demo.springboot.baseweb.api.ResponseCode;
import com.ljq.demo.springboot.baseweb.exception.ParamsCheckException;
import com.ljq.demo.springboot.common.page.QueryUtil;
import com.ljq.demo.springboot.dao.restuser.RestUserDao;
import com.ljq.demo.springboot.entity.RestUserEntity;
import com.ljq.demo.springboot.service.RestUserService;
import com.ljq.demo.springboot.vo.restuser.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * REST示例-用户表业务层具体实现类
 *
 * @author junqiang.lu
 * @date 2019-09-19 17:19:42
 */
@Service("restUserService")
@Transactional(rollbackFor = {Exception.class})
@Slf4j
public class RestUserServiceImpl implements RestUserService {

	@Autowired
	private RestUserDao restUserDao;

	/**
	 * 保存(单条)
	 *
	 * @param restUserSaveParam
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public ApiResult save(RestUserSaveParam restUserSaveParam) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(restUserSaveParam,restUserParam, CopyOptions.create()
				.setIgnoreNullValue(true).setIgnoreError(true));
		// 保存

		return ApiResult.success();
	}

	/**
	 * 查询详情(单条)
	 *
	 * @param restUserInfoParam
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult info(RestUserInfoParam restUserInfoParam) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(restUserInfoParam,restUserParam,CopyOptions.create()
				.setIgnoreNullValue(true).setIgnoreError(true));
		switch (restUserInfoParam.getId().intValue()) {
			case 1:
				throw new ParamsCheckException(ResponseCode.FAIL);
			case 2:
				throw new Exception(ResponseCode.UNKNOWN_ERROR.getMsg());
			default:
				break;
		}

		return ApiResult.success();
	}

	/**
	 * 查询列表
	 *
	 * @param restUserListParam
	 * @return
	 * @throws Exception
	 */
	@Override
	public ApiResult list(RestUserListParam restUserListParam) throws Exception {
		// 请求参数获取
		Map<String, Object> map = BeanUtil.beanToMap(restUserListParam);
		QueryUtil queryUtil = new QueryUtil(map);
			RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(restUserListParam, restUserParam,CopyOptions.create()
				.setIgnoreNullValue(true).setIgnoreError(true));
		// 分页查询


		return ApiResult.success();
	}

	/**
	 * 更新(单条)
	 *
	 * @param restUserUpdateParam
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public ApiResult update(RestUserUpdateParam restUserUpdateParam) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParam = new RestUserEntity();
		restUserParam.setId(restUserUpdateParam.getId());

		// 判断对象是否存在

		// 更新对象

		return ApiResult.success();
	}

	/**
	 * 删除(单条)
	 *
	 * @param restUserDeleteParam
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public ApiResult delete(RestUserDeleteParam restUserDeleteParam) throws Exception {
		// 请求参数获取
		RestUserEntity restUserParam = new RestUserEntity();
		BeanUtil.copyProperties(restUserDeleteParam, restUserParam,CopyOptions.create()
				.setIgnoreNullValue(true).setIgnoreError(true));
		// 判断对象是否存在

		// 更新对象

		return ApiResult.success();
	}
	

	
}
