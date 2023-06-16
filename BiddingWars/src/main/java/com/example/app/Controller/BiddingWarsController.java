package com.example.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Model.BiddingWarsModel;
import com.example.app.Service.BiddingWarsService;


@RestController
@CrossOrigin("http://localhost:3000")
public class BiddingWarsController
{
	@Autowired
	BiddingWarsService bs;
	@GetMapping("/productdetails")
    public List<BiddingWarsModel> getLapDetails()
    {
    	return bs.getLapDetails();
    }
	@GetMapping("/productdetails/{custid}")
    public BiddingWarsModel getProductById(@PathVariable int custid)
    {
    	return bs.getProductById(custid);
    }
	@PostMapping("/save")
    public String saveDetails(@RequestBody BiddingWarsModel s)
    {
    	BiddingWarsModel product= bs.saveDetails(s);
    	String result="false";
    	if(product!=null)
    	{
    		result="true";
    	}
    	return result;
    }
	@PutMapping("/update")
    public BiddingWarsModel updateDetails(@RequestBody BiddingWarsModel r)
    {
    	return bs.updateDetails(r);
    }
	@PutMapping("/edit/{custid}")
    public BiddingWarsModel editDetails(@RequestBody BiddingWarsModel custid)
    {
    	return bs.editDetails(custid);
    }
	@DeleteMapping("/delete/{custid}")
    public String deleteDetails(@PathVariable int custid)
    {
    	bs.deleteDetails(custid);
    	return "deleted";
    }
	//localhost:8080/lapdetail/?modelid=...
    @GetMapping("/productdetails/")
    public BiddingWarsModel findLapById(@RequestParam int custid)
    {
    	return bs.findLapById(custid);
    }
    @GetMapping("/sortdetail")
    public List<BiddingWarsModel> sortproduct(@RequestParam String field) 
    {
    	return bs.sortproduct(field);
    }
    @GetMapping("/subsort")
    public List<BiddingWarsModel> subsort(@RequestParam String field1,@RequestParam String field2){
    	
    	return bs.subsort(field1,field2);
    }
    //List
    @GetMapping("/pageable")
    public List<BiddingWarsModel> pagingproduct(@RequestParam int offset,@RequestParam int pagesize)
    {
    	return bs.pagingproduct(offset,pagesize);
    }
    //page
    @GetMapping("/page")
    public Page<BiddingWarsModel> pagingproduct1(@RequestParam int offset,@RequestParam int pagesize)
    {
    	return bs.pagingproduct1(offset,pagesize);
    }
    @GetMapping("/pagesort")
    public List<BiddingWarsModel> pagesortproduct(@RequestParam int offset,@RequestParam int pagesize,@RequestParam String field)
    {
    	return bs.pagesortproduct(offset,pagesize,field);
    }
    @GetMapping("/productnamestartingwith")
    public List<BiddingWarsModel> getByProductname(@RequestParam String prefix)
    {
    	return bs.getByProductname(prefix);
    }
    @GetMapping("/productnameendingwith")
    public List<BiddingWarsModel> get1ByProductname(@RequestParam String suffix)
    {
    	return bs.get1ByProductname(suffix);
    }
    @GetMapping("/colour")
    public List<BiddingWarsModel> getByProductcolour(@RequestParam String productcolour)
	{
		return bs.getByProductcolour(productcolour);
	}
    @GetMapping("/getByProductname")
    public List<BiddingWarsModel> getByProduct(@RequestParam String productname,@RequestParam String productcolour)
	{
		return bs.getByProduct(productname,productcolour);
	}
    @GetMapping("/get1ByProductname")
    public List<BiddingWarsModel> getProductname(@RequestParam String productname)
    {
    	return bs.getByModel(productname);
    }
    @DeleteMapping("/deletebyproductname")
    public String deleteproduct(@RequestParam String productname)
    {
    	int result= bs.deleteProductname(productname);
    	if(result>0)
    	{
    		return "Product Details Deleted";
    	}
    	else
    	{
    		return "Problem occured while deleting";
    	}		
    }
    @PutMapping("/updateCustname/{custname}/{custid}")
   	public String updatecustname(@PathVariable String custname,@PathVariable int custid)
   	{
   	     int result= bs.updateCustname(custname, custid);
   	     if(result>0)
   	     {
   	    	 return "Updated Successfully";
   	     }
   	     else
   	     {
   	    	 return "Problem occured while updating";
   	     }
   	}
}

