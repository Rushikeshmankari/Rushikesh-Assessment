package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.PortfolioClass;

import com.example.entity.ShareClass;
import com.example.service.Service;

@RestController
public class ControllerClass {

	@Autowired(required = true)
	Service service;

	@RequestMapping("/makePortfolios")
	public ResponseEntity<PortfolioClass> createPortfolio(@RequestBody PortfolioClass p) {
		return new ResponseEntity<>(service.createPortfolio(p), HttpStatus.OK);
	}

	@RequestMapping("/makeShares")
	public ResponseEntity<ShareClass> createShare(@RequestBody ShareClass s) {
		return new ResponseEntity<>(service.createShare(s), HttpStatus.OK);
	}

	@RequestMapping("/buyShares/{shareId}/{portfolioId}")
	public boolean buyShare(@PathVariable Integer shareId, @PathVariable Integer portfolioId) {
		return service.buyShare(shareId, portfolioId);
	}

	@RequestMapping("/sellShares/{shareId}/{portfolioId}")
	public boolean sellShare(@PathVariable Integer shareId, @PathVariable Integer portfolioId) {
		return service.sellShare(shareId, portfolioId);
	}

	@RequestMapping("/displayPortfolios")
	public ResponseEntity<List<PortfolioClass>> showPortfolio() {
		return new ResponseEntity<>(service.showPortfolio(), HttpStatus.OK);
	}
}
