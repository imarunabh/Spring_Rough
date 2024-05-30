package com.example.demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrappingApplication.class, args);
		for(int i=1;i<=5;i++) {
		try {
			String url="https://books.toscrape.com/catalogue/page-"+i+".html";
			Document document = Jsoup.connect(url).get();
			Elements books=document.select(".product_pod");
			System.out.println("****************");
			System.out.println("Books - Web Scrapping");
			
			for(Element bk: books) {
				String title = bk.select("h3 > a").text();
				String price = bk.select(".price_color").text();
				String acutal_price = price.substring(1);
				
				//get books with £20
				
				System.out.println(title + " - "+price );
				
			}
					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
