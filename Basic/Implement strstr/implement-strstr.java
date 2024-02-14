//{ Driver Code Starts
import java.util.*;


class Implement_strstr
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.strstr(a,b));
			
			t--;
		}
	}
}
// } Driver Code Ends


class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    { 
        for (int i = 0; i < s.length(); i++) {
            
                String str = "";
                if (s.charAt(i) == x.charAt(0)) {
                    str += s.charAt(i);
                    for (int j = 1; j < x.length(); j++) {
                        if (i + j < s.length() && s.charAt(i + j) == x.charAt(j))
                            str += s.charAt(i + j);
                        else
                            break;
                    }
                    if (str.equals(x)) {
                        return i;
                    }
                }
        }
        return -1;
    }

}