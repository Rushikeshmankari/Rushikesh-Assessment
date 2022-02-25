package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.PortfolioClass;
import com.example.entity.ShareClass;
import com.example.repository.PortfolioRepo;
import com.example.repository.ShareRepo;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Autowired
	private PortfolioRepo pRepo;

	@Autowired
	private ShareRepo sRepo;

	public PortfolioClass createPortfolio(PortfolioClass p) {//creates a repository for class Portfolio
		return pRepo.save(p);
	}

	public List<PortfolioClass> showPortfolio() {
		return pRepo.findAll();
	}
	
	public ShareClass createShare(ShareClass s) {//creates a repository for class Share
		return sRepo.save(s);
	}
	
	public List<ShareClass> showShare() {
		return sRepo.findAll();
	}

	public boolean buyShare(Integer shareId, Integer portfolioId) {
		PortfolioClass p = pRepo.findById(portfolioId).get();
		ShareClass s = sRepo.findById(shareId).get();
		p.setInvestment(p.getInvestment() + (s.getPrice()*s.getQuantity()));
		List<PortfolioClass> plist = new ArrayList<>();
		plist.add(p);
		List<ShareClass> slist = new ArrayList<>();
		slist.add(s);
		p.setShares(slist);
		s.setPortfolio(plist);
		pRepo.save(p);
		sRepo.save(s);
		return true;
	}

	public boolean sellShare(Integer shareId, Integer portfolioId) {
		PortfolioClass p = pRepo.findById(portfolioId).get();
		ShareClass s = sRepo.findById(shareId).get();
		p.setInvestment(p.getInvestment() - (s.getPrice()*s.getQuantity()));
		List<PortfolioClass> plist = new ArrayList<>();
		plist.add(p);
		List<ShareClass> slist = new ArrayList<>();
		slist.add(s);
		p.setShares(slist);
		s.setPortfolio(plist);
		pRepo.delete(p);
		sRepo.delete(s);
		return true;
	}

}