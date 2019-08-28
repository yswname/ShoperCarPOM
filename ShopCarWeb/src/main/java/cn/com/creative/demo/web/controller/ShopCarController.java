package cn.com.creative.demo.web.controller;

import cn.com.creative.demo.entity.BookEntity;
import cn.com.creative.demo.service.IBookService;
import cn.com.creative.demo.service.IShopCar;
import cn.com.creative.demo.service.impl.ShopCarImpl;
import javafx.util.Pair;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/shopCar")
//@SessionAttributes("SHOP_CAR")
public class ShopCarController {
    @Autowired
    @Qualifier("bookService")
    private IBookService bookService;

    @RequestMapping("/showShopCar")
    public ModelAndView showShopCar(HttpSession session) {
        ModelAndView mv = new ModelAndView("shopCar");
        // 从session中获取购物车对象
        // 如果有，就直接调用购物车对应的方法
        // 如果没有，自己创建购物车对象，调用方法，把购物车对象放入session
        //    以备下一次操作购物车使用
        IShopCar shopCar = (IShopCar) session.getAttribute("SHOP_CAR");
        if(shopCar == null){
            shopCar = new ShopCarImpl();
            session.setAttribute("SHOP_CAR", shopCar);
        }
        List<Pair<BookEntity, Integer>> pairList = shopCar.viewShopCar();
        mv.addObject("pairList", pairList);
        return mv;
    }

    @RequestMapping("/addShopCar")
    public String addShopCar(int bkId, HttpSession session) {
        String result = "添加成功";
        // 根据bkId找到bk对象
        BookEntity book = this.bookService.findBookById(bkId);
        // 获取ShopCar对象
        IShopCar shopCar = (IShopCar) session.getAttribute("SHOP_CAR");
        if(shopCar == null){
            shopCar = new ShopCarImpl();
            session.setAttribute("SHOP_CAR", shopCar);
        }
        // 调用shopCar对象的方法，添加购物车
        boolean bool = shopCar.add(book);
        if (!bool) {
            result = "添加失败";
        }
        return result;
    }

    @RequestMapping("/editShopCount")
    public String editShopCount(int bkId, int count, HttpSession session) {
        String result = "修改成功";
        // 获取ShopCar对象
        IShopCar shopCar = (IShopCar) session.getAttribute("SHOP_CAR");
        if(shopCar == null){
            shopCar = new ShopCarImpl();
            session.setAttribute("SHOP_CAR", shopCar);
        }
        boolean bool = shopCar.edit(bkId, count);
        if (!bool) {
            result = "修改失败";
        }
        return result;
    }

    @RequestMapping("/deleteShop")
    public String deleteShop(int bkId, HttpSession session) {
        WebMvcConfigurationSupport t;
        String result = "forward:showShopCar";
        // 获取ShopCar对象
        IShopCar shopCar = (IShopCar) session.getAttribute("SHOP_CAR");
        if(shopCar == null){
            shopCar = new ShopCarImpl();
            session.setAttribute("SHOP_CAR", shopCar);
        }
        boolean bool = shopCar.remove(bkId);
        return result;
    }

    @RequestMapping("/clearShopCar")
    public String clearShopCar(HttpSession session) {
        String result = "forward:showShopCar";
        // 获取ShopCar对象
        IShopCar shopCar = (IShopCar) session.getAttribute("SHOP_CAR");
        if(shopCar == null){
            shopCar = new ShopCarImpl();
            session.setAttribute("SHOP_CAR", shopCar);
        }
        boolean bool = shopCar.clear();
        return result;
    }

    //@ModelAttribute("SHOP_CAR")
    public IShopCar createShopCar() {
        IShopCar shopCar = new ShopCarImpl();
        return shopCar;
    }
}
