package CNJV.lab10.Controller;
import CNJV.lab10.Service.BillDetailService;
import CNJV.lab10.Service.BillService;
import CNJV.lab10.Service.CartManagementService;
import CNJV.lab10.Service.ProductService;
import CNJV.lab10.model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BillController {
    @Autowired
    CartManagementService cartManagementService;
    @Autowired
    ProductService productService;
    @Autowired
    BillDetailService billDetailService;
    @Autowired
    BillService billService;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/order")
    public String getOrder(Model model){
        Account account = (Account) session.getAttribute("account");
        double total = 0;
        List<CartManagement> cartManagementList = cartManagementService.getAllCartManagementByUserAccount(account.getUsername());
        for (CartManagement cartManagement : cartManagementList) {
            Product product = productService.getProductById(cartManagement.getSanPhamId());
            total += cartManagement.getTongTien();
        }

        Bill billAddLast = billService.save(new Bill(LocalDate.now(),total, account));

        List<BillDetail> billDetailList = new ArrayList<>();
        for (CartManagement cartManagement : cartManagementList) {
            Product product = productService.getProductById(cartManagement.getSanPhamId());
            BillDetail billDetail = new BillDetail(product.getPrice(),cartManagement.getSoLuong(),cartManagement.getTongTien(),product, billAddLast);
            billDetailService.save(billDetail);
            billDetailList.add(billDetail);

        }

        for (CartManagement cartManagement : cartManagementList) {
            cartManagementService.deleteCartManagement(cartManagement);
        }

        model.addAttribute("billDetailList", billDetailList);
        model.addAttribute("billInfor", billAddLast);
        model.addAttribute("fullname", request.getParameter("fullname"));
        model.addAttribute("address", request.getParameter("address"));
        model.addAttribute("phonenumber", request.getParameter("phonenumber"));
        return "order";
    }
}

