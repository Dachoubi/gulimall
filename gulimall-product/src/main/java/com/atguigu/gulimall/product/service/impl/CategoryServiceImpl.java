package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /** 
     * @Description: TODO 查询类别用树的方式
     * @Author: qiaotao 
     * @Date: 2023/9/27 9:52
     */
    @Override
    public List<CategoryEntity> listWithTree(Map<String, Object> params) {

        //用selectList来查询所有数据
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        //流式编程
        List<CategoryEntity> collect = categoryEntities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu) -> {
            menu.setChildren(getChildren(menu, categoryEntities));
            return menu;
        }).sorted((menu1,menu2) -> { //利用减法，进行asc排序
            return (menu1.getSort() == null ? 0 : menu1.getSort()) -  (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return collect;
    }

    /** 
     * @Description: TODO 逻辑删除
     * @Author: qiaotao 
     * @Date: 2023/9/27 21:46
     */
    @Override
    public void removeLogicByIds(List<Long> list) {

        //TODO 检查当前的菜单,是否被别的地方引用。

        int i = baseMapper.deleteBatchIds(list);
    }

    /** 
     * @Description: TODO 得到子菜单集合
     * @Author: qiaotao 
     * @Date: 2023/9/27 10:15
     */
    private List<CategoryEntity> getChildren(CategoryEntity parent,List<CategoryEntity> all){

//        if(parent.getCatLevel() == 3){
//            System.out.println("断点");
//        }

        List<CategoryEntity> collect = all.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == parent.getCatId();
        }).map((menu) -> {  //如果filter操作没有任何返回的话，就不进入map()方法了
            menu.setChildren(getChildren(menu, all));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) -  (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return collect;
    }

}