package com.example.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.app.Model.BiddingWarsModel;
import com.example.app.Repository.BiddingWarsRepository;

import jakarta.transaction.Transactional;


@Service
public class BiddingWarsService
{
	@Autowired
	BiddingWarsRepository br;
	
	public List<BiddingWarsModel> getLapDetails()
	{
		return br.findAll();
	}
	
	public BiddingWarsModel saveDetails(BiddingWarsModel s)
	{
		return br.save(s);
	}
	public BiddingWarsModel updateDetails(BiddingWarsModel r)
	{
		return br.save(r);
	}
	public BiddingWarsModel editDetails(BiddingWarsModel custid)
	{
		 return br.save(custid);
	}
	public void deleteDetails(int custid)
	{
		 br.deleteById(custid);
	}
	public BiddingWarsModel findLapById(int custid)
	{
		return br.findById(custid).orElse(null);
	}
	public List<BiddingWarsModel> sortproduct(String field)
	{
		return br.findAll(Sort.by(field));
	}
//	return lr.findAll(Sort.by(Direction.DESC, field));

	public List<BiddingWarsModel> subsort(String field1, String field2) {
		
		return br.findAll(Sort.by(field1).and (Sort.by(field2)));
	}
	public List<BiddingWarsModel> pagingproduct(int offset,int pagesize)
	{
		Page<BiddingWarsModel> paging=br.findAll(PageRequest.of(offset, pagesize));
		
		return paging.getContent();
	}
	public Page<BiddingWarsModel> pagingproduct1(int offset,int pagesize)
	{
		Page<BiddingWarsModel> page=br.findAll(PageRequest.of(offset, pagesize));
		
		return page;
	}
	public List<BiddingWarsModel> pagesortproduct(int offset,int pagesize,String field)
	{
		Page<BiddingWarsModel> paging=br.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
		
		return paging.getContent();
	}
	public List<BiddingWarsModel> getByProductname(String prefix)
	{
		return br.findByProductnameStartingWith(prefix);
	}
	public List<BiddingWarsModel> get1ByProductname(String suffix)
	{
		return br.findByProductnameEndingWith(suffix);
	}
	public List<BiddingWarsModel> getByProductcolour(String productcolour)
	{
		return br.findByProductcolour(productcolour);
	}
	public List<BiddingWarsModel> getByProduct(String productname,String productcolour)
	{
		return br.getByProductname(productname,productcolour);
	}
	public List<BiddingWarsModel> getByModel(String productname)
	{
		return br.getByProductname(productname);
	}
	@Transactional
	public int deleteProductname(String productname)
	{
		return br.deleteByProductname(productname);
	}
	@Transactional
	public int updateCustname(String custname,int custid)
	{
		return br.updateByCustname(custname,custid);
	}

	public BiddingWarsModel getProductById(int custid) {
		
		return br.findById(custid).orElse(null);
	}
}
