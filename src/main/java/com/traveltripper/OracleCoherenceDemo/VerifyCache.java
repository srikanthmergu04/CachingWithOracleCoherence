package com.traveltripper.OracleCoherenceDemo;

import java.util.Scanner;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.NamedCache;

public class VerifyCache {

	public void verifyCacheByCacheName(NamedCache cache) {
		
		CacheFactory.ensureCluster();
		Scanner scanner = new Scanner(System.in);
		//NamedCache cache = CacheFactory.getCache(cacheName);
		
		String status;
		
		do{
			
			
			System.out.println("Enter Key to get the Value from Cache");
			String key = scanner.next();
			System.out.println("Value = "+cache.get(key));
			System.out.println("Do you want to continue Verifying [yes / no ]");
			status = scanner.next();
			
		}while(status.equalsIgnoreCase("yes"));
		
		//System.out.println("Cache Server Stopped......");
		
	}

}
