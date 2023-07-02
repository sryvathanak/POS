package com.pos.controller;

//import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


//import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pos.config.FileUploadUtil;
import com.pos.model.Category;
import com.pos.model.Product;
import com.pos.service.CategoryServiceImp;
import com.pos.service.ProductServiceImp;



@Controller
@RequestMapping("")
public class ProductController {
	
	@Autowired
	private ProductServiceImp productServiceImp;
	
	@Autowired
	private CategoryServiceImp categoryServiceImp;
	@GetMapping("/products")
	  public String searproducts(Model model,@Param("keyword") String keyword) {
		List<Product> listProduct = productServiceImp.listAll(keyword);
			model.addAttribute("products", listProduct);
			model.addAttribute("keyword", keyword);
		
	    return "products";
	  }
	
	
	@GetMapping("/products/new")
	public String createProduct(Model model) {	
		Product product = new Product();
		List<Category>listCategory = categoryServiceImp.getAllCategorys();
		model.addAttribute("categorys",listCategory );
		model.addAttribute("product", product);
		return "saveProduct";
		
	}
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

	//public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/productImage";
	@PostMapping("/products")
	public String saveProdct(@ModelAttribute("product") Product product,@RequestParam("image") MultipartFile file) throws IOException
	{
//		StringBuilder fileNames = new StringBuilder();
//		String filename=product.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
//		Path fileNameAndPath =Paths.get(uploadDirectory,filename);
//		try {
//			Files.write(fileNameAndPath, file.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        product.setProduct_image(fileName);
        
		 StringBuilder fileNames = new StringBuilder();
	        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
	        fileNames.append(file.getOriginalFilename());
	        Files.write(fileNameAndPath, file.getBytes());
	        //.addAttribute("msg", "Uploaded images: " + fileNames.toString());
		productServiceImp.saveProduct(product);
		//String uploadDir = "product-photos/" + saveProduct.getId();
		 
       // FileUploadUtil.saveFile(uploadDir, fileName, file);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		model.addAttribute("product", productServiceImp.getProductById(id));
		List<Category>listCategory = categoryServiceImp.getAllCategorys();
		model.addAttribute("categorys",listCategory );
		return "updateProduct";
	}

	
	@PostMapping("/products/{id}")
	public String updateProdct(@PathVariable Long id,
			@ModelAttribute("product") Product product,
			Model model) {
		Product p = productServiceImp.getProductById(id);
		p.setId(id);
		p.setCode(product.getCode());
		p.setTitle(product.getTitle());
		p.setTitle_kh(product.getTitle_kh());
		p.setPrice(product.getPrice());
		p.setCategory(product.getCategory());
		productServiceImp.updateProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/{id}")
	public String deleteProduct(@PathVariable Long id,@ModelAttribute("product") Product product,
			Model model) {
		Product p = productServiceImp.getProductById(id);
		p.setStatus(1);
		productServiceImp.deleteProductById(p);
		return "redirect:/products";
	}
	
}
