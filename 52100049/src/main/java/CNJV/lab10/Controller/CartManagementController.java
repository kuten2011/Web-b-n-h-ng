package CNJV.lab10.Controller;

import CNJV.lab10.Service.CartManagementService;
import CNJV.lab10.Service.ProductService;
import CNJV.lab10.model.Account;
import CNJV.lab10.model.CartManagement;
import CNJV.lab10.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartManagementController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    CartManagementService cartManagementService;
    @Autowired
    HttpSession httpSession;
    @Autowired
    ProductService productService;

    @PostMapping("/cart")
    public String addToCart(Model model) {
        // Check login
        double total = 00.;
        if (httpSession.getAttribute("account") != null) {
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            Long sanPhamId = Long.valueOf(request.getParameter("sanPhamId"));
            double tongTien = Double.valueOf(request.getParameter("tongTien"));
            Account account = (Account) httpSession.getAttribute("account");

            CartManagement cart = cartManagementService.findBySanPhamIdAndUserAccount(sanPhamId, account);
            if (cart != null) {
                tongTien=tongTien*soLuong;
                cart.setSoLuong(cart.getSoLuong() + soLuong);
                cart.setTongTien(cart.getTongTien() + tongTien);
                cartManagementService.save(cart);
            } else {
                tongTien=tongTien*soLuong;
                cartManagementService.save(new CartManagement(sanPhamId, soLuong, tongTien, account));
            }

            List<CartManagement> cartManagementList = cartManagementService.getAllCartManagementByUserAccount(account.getUsername());
            List<Product> productList = new ArrayList<>();
            for (CartManagement cartManagement : cartManagementList) {
                Product product = productService.getProductById(cartManagement.getSanPhamId());
                productList.add(product);
                total += cartManagement.getTongTien();
            }
            model.addAttribute("listProductOnCart", productList);
            model.addAttribute("cartManagementList", cartManagementList);
            model.addAttribute("totalBill", total);
            return "cart";
        }
        return "/login";
//        return "cart";
    }
    @GetMapping("/cart")
    public String getAllCart(Model model){
        Account account = (Account) httpSession.getAttribute("account");
        double total = 00.;
        if(account!=null){
            List<CartManagement> cartManagementList = cartManagementService.getAllCartManagementByUserAccount(account.getUsername());
            List<Product> productList = new ArrayList<>();
            for (CartManagement cartManagement : cartManagementList) {
                Product product = productService.getProductById(cartManagement.getSanPhamId());
                productList.add(product);
                total += cartManagement.getTongTien();
            }
            model.addAttribute("listProductOnCart",productList);
            model.addAttribute("cartManagementList", cartManagementList);
        }
        model.addAttribute("totalBill",total);
        return "cart";
    }
    @PostMapping("/cart/{id}")
    public String deleteProductOnCart(@PathVariable("id") Long productID, Model model){
        Account account = (Account) httpSession.getAttribute("account");
        double total = 00.;
        CartManagement cartManagement = cartManagementService.findBySanPhamIdAndUserAccount(productID,account);
        if(cartManagement!=null){
            cartManagementService.deleteCartManagement(cartManagement);
        }
        List<CartManagement> cartManagementList = cartManagementService.getAllCartManagementByUserAccount(account.getUsername());
        List<Product> productList = new ArrayList<>();
        for (CartManagement cartManagementValue : cartManagementList) {
            Product product = productService.getProductById(cartManagementValue.getSanPhamId());
            productList.add(product);
            total += cartManagementValue.getTongTien();
        }
        model.addAttribute("listProductOnCart", productList);
        model.addAttribute("cartManagementList", cartManagementList);
        model.addAttribute("totalBill", total);
        return "redirect:/cart";
    }

}
