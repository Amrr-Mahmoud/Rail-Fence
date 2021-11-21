
package railfen;

public class RailClass {
    public static String enc(String ip,String key)
    {
        int len=ip.length();
        int m_row=Integer.parseInt(key);
        int m_col=(int)Math.ceil((float)len/m_row);
        
        char op[][]=new char[100][100]; 
        String op2=""; 
        int i1,i2,i; 
        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i2][i1]=ip.charAt(i);
            i2++;
            if(i2==m_row)
            {
                i2=0;
                i1++;
            } 
        }
 
        System.out.println("Cipher matrix:");
        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                System.out.print(op[i1][i2]+" ");
            }
            System.out.println();
        }
  
        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                op2 = op2+op[i1][i2];
            }
        }
        return (op2);
    }
    
    public static String dec(String ip,String key)
     {
        int len=ip.length();
        int m_row=Integer.parseInt(key);
        int m_col=(int)Math.ceil((float)len/m_row);
        char op[][]=new char[100][100];
        String op2="";
        int i1,i2,i;
        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i1][i2]=ip.charAt(i);
            i2++;
            if(i2==m_col)
            {
                i2=0;
                i1++;
            } 
        }
 
        System.out.println("Cipher matrix");
        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                System.out.print(op[i1][i2]+" ");
            }
            System.out.println();
        }
        for(i1=0;i1<m_col;i1++)
        {
            for(i2=0;i2<m_row;i2++)
            {
                op2 = op2+op[i2][i1];
            }
        }
        return (op2);
     }
}
