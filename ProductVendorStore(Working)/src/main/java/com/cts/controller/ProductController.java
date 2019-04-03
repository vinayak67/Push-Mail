package com.cts.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

import com.cts.model.Product;
import com.cts.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

@Autowired
ProductService productService;


@GetMapping("/list")
public String getAllProducts(Model model)
{
	List<Product>lb=productService.getAllProducts();
	model.addAttribute("product",lb);
	return "productlist";
}

@GetMapping("/showForm")
public String showFormForAdd(Model model)
{
	Product theProduct=new Product();
	
	model.addAttribute("product",theProduct);
	return "addProduct";
}


@PostMapping("/saveProduct")
public String saveAProduct(@ModelAttribute("product") Product theProduct)
{
	productService.saveProduct(theProduct);
	return "redirect:/product/list";
}

@GetMapping("/updateForm")
public String showFormForUpdate(@RequestParam("productId") int theId , Model model)
{
	Product theProduct=productService.getProduct(theId);
	model.addAttribute("product",theProduct);

	return "addProduct";
}



@GetMapping("/view")
public String showProductDetails(@RequestParam("productId") int theId , Model model)
{
	
	Product theProduct=productService.getProduct(theId);
	model.addAttribute("product",theProduct);
	return "details";
}

@GetMapping("/back")
public String backPage()
{
	return "redirect:/product/list";
}

@GetMapping("/logout")
public String logoutPage(HttpServletRequest request,HttpServletResponse response)
{
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	
	if(auth!=null)
		new SecurityContextLogoutHandler().logout(request, response, auth);
	
	return "redirect:/login?logout=true";
}

/**************************************************************************************************/

	/*
	 * @GetMapping("/delete") public String deleteABook(@RequestParam("productId")
	 * int theId , Model model)throws AddressException, MessagingException {
	 * 
	 * String host = "smtp.gmail.com"; String Password = "qwerty@123"; String
	 * toAddress = "dev8enigma@gmail.com"; String from = "samultron2@gmail.com"; //
	 * to address String filename = "C:\\Users\\Vinayak\\Desktop\\Resume.pdf"; //
	 * attaching a file String sub="Welcome....."; //subject String
	 * body="Hi............\n\n\nRegards..\n";// body // Get system properties
	 * java.util.Properties props = System.getProperties();
	 * props.put("mail.smtp.host", host); props.put("mail.smtps.auth", "true");
	 * props.put("mail.smtp.starttls.enable", "true"); Session session =
	 * Session.getInstance(props, null); java.io.File file = new
	 * java.io.File(filename); long filesize = file.length(); long filesizeInKB =
	 * filesize / 1024; double megabytes = (filesizeInKB/ 1024);
	 * System.out.println("Size of File is: "+ filesizeInKB + " KB");
	 * System.out.println("Size of File is: "+ megabytes + " MB"); double
	 * size1=20.1; if(megabytes>size1) //file size must be below 20MB
	 * System.out.println("File Size Must Below 20 MB"); else {
	 * System.out.println("Hello"); javax.mail.internet.MimeMessage message = new
	 * javax.mail.internet.MimeMessage(session); message.setFrom(new
	 * InternetAddress(from)); message.setRecipients(Message.RecipientType.TO,
	 * toAddress); java.util.Calendar currentDate =
	 * java.util.Calendar.getInstance(); java.text.SimpleDateFormat formatter= new
	 * java.text.SimpleDateFormat("yyyy-MMM-dd HH:mm:ss a"); java.lang.String
	 * dateToday = formatter.format(currentDate.getTime()).toLowerCase();
	 * message.setSubject("Mail: "+dateToday+" "+sub); BodyPart messageBodyPart =
	 * new MimeBodyPart(); messageBodyPart.setText(body); Multipart multipart = new
	 * MimeMultipart(); multipart.addBodyPart(messageBodyPart); messageBodyPart =
	 * new MimeBodyPart(); javax.activation.DataSource source = new
	 * FileDataSource(filename); messageBodyPart.setDataHandler(new
	 * DataHandler(source)); messageBodyPart.setFileName(filename);
	 * multipart.addBodyPart(messageBodyPart); message.setContent(multipart);
	 * 
	 * try { javax.mail.Transport tr = session.getTransport("smtps");
	 * tr.connect(host, from, Password);
	 * System.out.println("Connected to Server......");
	 * System.out.println("Now Sending "+filename); tr.sendMessage(message,
	 * message.getAllRecipients());
	 * System.out.println("Mail Sent Successfully........"); tr.close();
	 * 
	 * } catch (javax.mail.SendFailedException sfe) {
	 * 
	 * System.out.println(sfe); }
	 * 
	 * } productService.deleteProduct(theId); return "redirect:/product/list"; }
	 */

@GetMapping("/delete") 
public String deleteABook(@RequestParam("productId")int theId , Model model)throws AddressException, MessagingException {
	try{
        String host ="smtp.gmail.com" ;
        String user = "dev8enigma@gmail.com";
        String pass = "qwerty@123";
        String to = "dev8enigma@gmail.com";
        String from = "samultron2@gmail.com";
        String subject = "Product Alert";
        String messageText = "Your Product has been deleted from the Database";
        boolean sessionDebug = false;

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");

        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject); msg.setSentDate(new Date());
        msg.setText(messageText);

       Transport transport=mailSession.getTransport("smtp");
       transport.connect(host, user, pass);
       transport.sendMessage(msg, msg.getAllRecipients());
       transport.close();
       System.out.println("message send successfully");
    }catch(Exception ex)
    {
        System.out.println(ex);
    }
	productService.deleteProduct(theId);
	return "redirect:/product/list";
}
}

