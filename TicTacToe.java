import java.util.*;
class Tic
{
	int arr_board[][]=new int[3][3];
	int arr_check[]=new int[10];
	int var_pos;
	int var_n;
	String var_name;
	//char n;
	int var_flag=0,var_index=0;
	synchronized void drawPos(String var_name)
	{
		Scanner scan=new Scanner(System.in);
		this.var_name=var_name;
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){}
		if(var_name.equalsIgnoreCase("shadow"))
		{
			var_n=1;
			//n='*';
		}
		else
		{
			var_n=2;
			//n='o';
		}
		System.out.println("PLAYER "+var_name+" CHANCE NOW"+"\t"+"put "+var_n);
		try{
			var_pos=scan.nextInt();
			
			if(var_index==0)
			{
				arr_check[var_index]=var_pos;
				var_index++;
			}
			else
			{
				for(int i=0;i<var_index;i++)
				{
					if(var_pos==arr_check[i])
					{
						System.out.println("INVALID ENTRY"+"\t"+"ENTER AGAIN");
						drawPos(var_name);
						break;
					}
					else if(i==var_index-1)
					{
						arr_check[var_index]=var_pos;
						var_index++;
						break;
					}
				}
			}

			if(var_pos==1)
			{
				arr_board[0][0]=var_n;
			}
			if(var_pos==2)
			{
				arr_board[0][1]=var_n;
			}
			if(var_pos==3)
			{
				arr_board[0][2]=var_n;
			}
			if(var_pos==4)
			{
				arr_board[1][0]=var_n;
			}
			if(var_pos==5)
			{
				arr_board[1][1]=var_n;
			}
			if(var_pos==6)
			{
				arr_board[1][2]=var_n;
			}
			if(var_pos==7)
			{
				arr_board[2][0]=var_n;
			}
			if(var_pos==8)
			{
				arr_board[2][1]=var_n;
			}
			if(var_pos==9)
			{
				arr_board[2][2]=var_n;
			}
		}
		catch(Exception e)
		{
			System.out.println("INVALID ENTRY");
			drawPos(var_name);
		}
	}
	
	void display(String var_name)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
			/*	if(board[i][j]==n)
				{
					System.out.print((char)board[i][j]+"\t");
				}
				else
				{*/
					System.out.print(arr_board[i][j]+"\t");
				//}
			}
			System.out.println();
		}
		
		if((arr_board[0][0]==arr_board[0][1] && arr_board[0][1]==arr_board[0][2] && arr_board[0][2]==var_n) || (arr_board[0][0]==arr_board[1][1] && arr_board[1][1]==arr_board[2][2] && arr_board[2][2]==var_n) || (arr_board[0][0]==arr_board[1][0] && arr_board[1][0]==arr_board[2][0] && arr_board[2][0]==var_n) || (arr_board[2][2]==arr_board[1][2] && arr_board[1][2]==arr_board[0][2] && arr_board[0][2]==var_n) || (arr_board[2][0]==arr_board[2][1] && arr_board[2][1]==arr_board[2][2] && arr_board[2][2]==var_n) || (arr_board[0][1]==arr_board[1][1] && arr_board[1][1]==arr_board[1][2] && arr_board[1][2]==var_n) || (arr_board[0][1]==arr_board[1][1] && arr_board[1][1]==arr_board[2][1] && arr_board[2][1]==var_n) || (arr_board[2][0]==arr_board[1][1] && arr_board[1][1]==arr_board[0][2] && arr_board[0][2]==var_n))
		{
			System.out.println(var_name+" has won the game");
			System.exit(0);
		}
		if(arr_board[0][0]!=0 && arr_board[0][1]!=0 && arr_board[0][2]!=0 && arr_board[1][0]!=0 && arr_board[1][1]!=0 && arr_board[1][2]!=0 && arr_board[2][0]!=0 && arr_board[2][1]!=0 && arr_board[2][2]!=0)
		{
			System.out.println("Draw match");
			System.exit(0);
		}
	}
	
}
class Tac implements Runnable
{
	Thread th;
	String var_name;
	Tic obj_t;
	Tac(String var_name,Tic obj_t)
	{
		th=new Thread(this);
		this.var_name=var_name;
		this.obj_t=obj_t;
		th.start();
	}
	
	public void run()
	{
		while(obj_t.var_flag==0)
		{
			obj_t.drawPos(var_name);
			obj_t.display(var_name);
		}
	}
}
	
class TicTacToe
{
public static void main(String st[])
{
	Tic obj_t=new Tic();
	Tac obj_t1=new Tac("shadow",obj_t);
	Tac obj_t2=new Tac("shlok",obj_t);
	
}}