import java.io.*;
class Tic
{
	static String n1, n2;
	public static void main(String args[])throws IOException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		System.out.println("Player X enter your name!");
		n1 = in.readLine();
		System.out.println("Player O enter your name!");
		n2 = in.readLine();
		char a[][] = new char[3][3];
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				a[i][j] = '_';
			}
		}

		//Displaying
		display(a);

		//Inputting
		int x,y,z;
		for(int i=1; i<=5; i++)
		{
			if(i==5)
			{
				System.out.println(n1+" enter position");
				x = Integer.parseInt(in.readLine());
				y = Integer.parseInt(in.readLine());
				a[x][y] = 'X';
				z = check(a);
				display(a);
				if(z==1)
				{
					System.out.println("GAME OVER!!");
					break;
				}
				else
				{	
					System.out.println("NO ONE WINS!!");
					System.out.println("GAME OVER!!");
					break;
				}
			}


			System.out.println(n1+" enter position");
			x = Integer.parseInt(in.readLine());
			y = Integer.parseInt(in.readLine());
			a[x][y] = 'X';
			display(a);
			z = check(a);
			if(z==1)
			{
				System.out.println("GAME OVER!!");
				break;
			}
			System.out.println(n2+" enter position");
			x = Integer.parseInt(in.readLine());
			y = Integer.parseInt(in.readLine());
			a[x][y] = 'O';
			display(a);
			z = check(a);
			if(z==1)
			{
				System.out.println("GAME OVER!!");
				break;
			}
		}
	}

	static int check(char b[][])
	{
		int j=0; int val =0; int p=0,q=0; String n="";
		for(int i=0; i<3; i++)
		{
			if((b[i][j]=='X') || (b[i][j]=='O'))
			{
				if((b[i][j] == b[i][j+1]) && (b[i][j] == b[i][j+2]))
				{
					val=1;
					p=i; q=j;
					break;
				}
			}

			if((b[j][i]=='X') || (b[j][i]=='O'))
			{
				if((b[j][i] == b[j+1][i]) && (b[j][i] == b[j+2][i]))
				{
					val=1;
					p=i; q=j;
					break;
				}
			}	
		}	

		if(val==1)
		{
			n = name(b, p, q);
			System.out.println(n+" wins!!");
			return val;
		}	
		else 
		{
			if(b[1][1]=='X'|| b[1][1]=='O')
			{
				if(((b[0][0]==b[1][1]) && (b[0][0]==b[2][2])) || ((b[0][2]==b[1][1]) && (b[0][2]==b[2][0])))
				{
					val = 1;
					n = name(b, 1, 1);
					System.out.println(n+" wins!!");
					return val;
				}
			}
			else
			{
				return val;
			}
		}	
		return val;
	}

	
	static void display(char b[][])
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	static String name(char c[][], int n, int m)
	{	
		if(c[n][m] == 'X')
		{
			return n1;
		}
	
		if(c[n][m] == 'O')
		{
			return n2;
		}
		return "";
	}
}
