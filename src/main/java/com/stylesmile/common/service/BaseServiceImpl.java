package com.stylesmile.common.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stylesmile.common.service.BaseService;

/**
 * @Description:
 * @Author: StyleSmile
 * @Date: 2019/1/8 /21:18
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

}
