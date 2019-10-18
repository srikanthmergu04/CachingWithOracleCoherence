package com.traveltripper.OracleCoherenceDemo;

import java.util.Scanner;

import com.tangosol.coherence.mvel.sh.command.basic.Exit;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.NamedCache;

/*import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;*/
 
public class CachingWithCoherence {
 
   public static void main(String[] args) {
	
 
      CacheFactory.ensureCluster();
      NamedCache cache = CacheFactory.getCache("Oracle-Cache");
      String status = null;
      Scanner scanner = new Scanner(System.in);
      do {
    	  System.out.println("Select the Following to Continue");
    	  System.out.println("1.Storing to the Cache \n2.Verify the Cache\n3.Stop the Cache Server");
    	  Integer choice = scanner.nextInt();
    	  switch (choice) {
		case 1:
			System.out.println("Enter Key :");
			String key = scanner.next();
			System.out.println("Enter Value:");
			String value = scanner.next();
			cache.put(key,value);
			System.out.println("\nKey and Value Successfully stored in Cache");
			break;
		case 2:
			VerifyCache verifyCache = new VerifyCache();
			verifyCache.verifyCacheByCacheName(cache);
			break;
		case 3:
			CacheFactory.shutdown();
			System.out.println("Cache Server Stopped....");
			System.exit(1);
			break;
		default:
			System.out.println("Wrong Selection..");
			break;
		}
    	  
    	  System.out.println("do you want to continue [yes / no]");
    	  status = scanner.next();
    	  
      }while(status.equalsIgnoreCase("yes"));
      
      if(status.equalsIgnoreCase("no")) {
    	  System.out.println("Cache Server Stopped....");
      }
   }
}