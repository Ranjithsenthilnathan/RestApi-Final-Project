package com.example.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.app.Model.BiddingWarsModel;

@Repository
public interface BiddingWarsRepository extends JpaRepository<BiddingWarsModel,Integer>
{
	public List<BiddingWarsModel> findByProductnameStartingWith(String prefix);
	public List<BiddingWarsModel> findByProductnameEndingWith(String suffix);
	public List<BiddingWarsModel> findByProductcolour(String productcolour);
	//position parameter
	@Query("select l from BiddingWarsModel l where l.productname=?1 and l.productcolour=?2")
	public List<BiddingWarsModel> getByProductname(String productname,String productcolour);
	//named parameter
	@Query("select l from BiddingWarsModel l where l.productname=:productname")
	public List<BiddingWarsModel> getByProductname(String productname);
	//DML
	@Modifying
	@Query("delete from BiddingWarsModel l where l.productname=?1")
	public int deleteByProductname(String productname);
	@Modifying
	@Query("update BiddingWarsModel l set l.custname=?1 where l.custid=?2")
	public int updateByCustname(String custname,int custid);
}
