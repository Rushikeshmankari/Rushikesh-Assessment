package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.entity.PortfolioClass;
import com.example.entity.ShareClass;

@org.springframework.stereotype.Service
public interface Service {

	public PortfolioClass createPortfolio(PortfolioClass p);

	public List<PortfolioClass> showPortfolio();

	public boolean buyShare(Integer shareId, Integer portfolioId);

	public boolean sellShare(Integer shareId, Integer portfolioId);

	public List<ShareClass> showShare();

	public ShareClass createShare(ShareClass s);

}
