package org.bill;

import java.util.ArrayList;
import java.util.Scanner;

public class BillSys {

	static Scanner mp=new Scanner(System.in);
	static int bill_id=0;
	static ArrayList<Item_detail> itemd=new ArrayList<Item_detail>();
	static ArrayList<Bill_list> billad=new ArrayList<Bill_list>();
	static ArrayList<Custo_details>  cusd=new ArrayList<Custo_details>();
	public static void main(String[] args) {

		itemd.add(new Item_detail(1,"munch",5,100));
		itemd.add(new Item_detail(2,"kit  ",5,100));
		itemd.add(new Item_detail(3,"star ",5,100));
		itemd.add(new Item_detail(4,"treat",5,100));

		cusd.add(new Custo_details(1,"james"));
		cusd.add(new Custo_details(2,"jeya"));
		cusd.add(new Custo_details(3,"bond"));
		cusd.add(new Custo_details(4,"sudaa"));



		int  c=0,k=1;
		while(k==1)
		{
			System.out.println("1 Bill Create");
			System.out.println("2 Search bill");
			System.out.println("3.Search customerBill");
			System.out.println("4.Item Stack Deatil");
			System.out.println("5 Search Item's Bill");
			System.out.println("6 Add Customer");
			System.out.println("7 Bill List");
			System.out.println("Enter Option");
			int n=mp.nextInt();
			switch(n)
			{
			case 1:billCre();
			c++;
			break;
			case 2:if(c!=0)
			{
				searchbill();
			}
			break;
			case 3:if(c!=0)
				searchcusbil();
			break;
			case 4:stack();
			break;
			case 5:itembil();
			break;
			case 6:cusadd();
			break;
			case 7:billis();
			break;
			}
			System.out.println("do u want continue press 1");
			int x=mp.nextInt();
		}
	}
	public static void billis()
	{
		for(Bill_list m:billad)
		{
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("                 Bill id:"+m.bill_Id+"               ");
			System.out.println("                 Date:"+java.time.LocalDate.now()+"    ");
			System.out.println("                 Customer Name:"+m.name+"        ");
			System.out.println("Item id     Item name    Item price  Item quentity    Item amount");
			display(m.itedn);
			System.out.println("--------------------------------------------------------------------------------------");
		}
	}
	public static void cusadd()
	{
		System.out.println("enter the customer name");
		mp.nextLine();
		String na=mp.nextLine();
		int k=1;
		for(Custo_details m:cusd)
		{
			k++;
		}
		cusd.add(new Custo_details(k,na));
	}
	public static void itembil()
	{
		System.out.println("enter the item id");
		int x=mp.nextInt();
		for(Bill_list m:billad)
		{
			for(List_det y:m.itedn)
			{
				if(y.id==x)
				{
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.println("                 Bill id:"+m.bill_Id+"               ");
					System.out.println("                 Date:"+java.time.LocalDate.now()+"    ");
					System.out.println("                 Customer Name:"+m.name+"        ");
					System.out.println("Item id     Item name    Item price  Item quentity    Item amount");
					display(m.itedn);
					System.out.println("--------------------------------------------------------------------------------------");
				}
			}
		}
	}
	public static void stack()
	{
		System.out.println("Enter the item id:");
		int n=mp.nextInt();
		for(Item_detail m:itemd)
		{
			if(m.iteid==n)
			{
				System.out.println("The quentity of:"+m.itename+" is:"+m.itequan);
			}
		}

	}
	public static void searchcusbil() {

		System.out.println("enter the customer id");
		int n=mp.nextInt();
		for(Bill_list m:billad)
		{
			if(m.id==n)
			{
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println("                 Bill id:"+m.bill_Id+"               ");
				System.out.println("                 Date:"+java.time.LocalDate.now()+"    ");
				System.out.println("                 Customer Name:"+m.name+"        ");
				System.out.println("Item id     Item name    Item price  Item quentity    Item amount");
				display(m.itedn);
				System.out.println("--------------------------------------------------------------------------------------");
			}
		}

	}
	public static void searchbill() {
		System.out.println("Enter the bill id");
		int n=mp.nextInt();
		for(Bill_list m:billad)
		{
			if(m.bill_Id==n)
			{
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println("                 Bill id:"+n+"               ");
				System.out.println("                 Date:"+java.time.LocalDate.now()+"    ");
				System.out.println("                 Customer Name:"+m.name+"        ");
				System.out.println("Item id     Item name    Item price  Item quentity    Item amount");
				display(m.itedn);
			}
		}

	}
	public static void billCre()
	{
		int nb=1;
		for(Custo_details m:cusd)
		{
			System.out.println(m.id+"."+m.name);
		}
		System.out.println("Enter the ID");
		int m=mp.nextInt();
		Custo_details cdet=cusd.get(m-1);
		int totala=0;
		bill_id++;
		int tet=0;
		ArrayList<List_det> list=new ArrayList<List_det>();
		do {
			totala=0;
			for(Item_detail b:itemd)
			{
				System.out.println(b.iteid+" "+b.itename+" "+b.iteprice);

			}
			System.out.println("Which product you want enthe id number");
			int b=mp.nextInt();
			Item_detail ip=itemd.get(b-1);
			System.out.println("Enter the quentity of the product");
			int n=mp.nextInt();
			ip.itequan-=n;
			totala+=ip.iteprice*n;
			tet+=totala;
			list.add(new List_det(ip.iteid,ip.itename,ip.iteprice,n,totala));
			System.out.println("Do u continue press 1");
			nb=mp.nextInt();

		}while(nb==1);

		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("                 Bill id:"+bill_id+"               ");
		System.out.println("                 Date:"+java.time.LocalDate.now()+"    ");
		System.out.println("                 Customer Name:"+cdet.name+"        ");
		System.out.println("Item id     Item name    Item price  Item quentity    Item amount");
		display(list);
		billad.add(new Bill_list(cdet.id,cdet.name,bill_id,tet,list));

	}
	static void display(ArrayList<List_det> ref)
	{
		int c=0;
		for(List_det m:ref)
		{
			System.out.println(m.id+"            "+m.name+"              "+m.price+"              "+m.quenti+"                "+m.totalra);
			c+=m.totalra;
		}
		System.out.println("TOTAL BILL AMOUNT :"+c);
	}
}

class Item_detail
{
	int iteid;
	String  itename;
	int iteprice;
	int itequan;
	Item_detail(int a,String b,int c,int d)
	{
		iteid=a;
		itename=b;
		iteprice=c;
		itequan=d;


	}
}
class Custo_details
{
	int id;
	String name;
	Custo_details(int a,String b)
	{
		id=a;
		name=b;
	}
}
class List_det
{
	int id;
	String name;
	int price;
	int quenti;
	int totalra;
	List_det(int id,String na,int p,int q,int tor)
	{
		this.id=id;
		this.name=na;
		this.price=p;
		this.quenti=q;
		this.totalra=tor;
	}

}
class Bill_list
{
	int id;
	String name;
	int bill_Id;
	long total=0;
	ArrayList<List_det> itedn;
	Bill_list(int i,String na,int id,int tot,ArrayList<List_det> m)
	{
		this.id =i;
		this.name=na;
		this.bill_Id=id;
		this.total=tot;
		this.itedn=m;
	}



}